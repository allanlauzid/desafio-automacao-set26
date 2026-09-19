package com.accenture.challenge;

import com.accenture.challenge.ui.NavigationPage;
import com.accenture.challenge.ui.SortablePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SortableSteps {
    private static final List<String> ASCENDING =
            List.of("One", "Two", "Three", "Four", "Five", "Six");

    private WebDriver driver;
    private Scenario scenario;
    private NavigationPage navigation;
    private SortablePage sortable;
    private List<String> orderAfterDisturbance;

    @Before("@sortable")
    public void startBrowser(Scenario scenario) {
        this.scenario = scenario;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080", "--disable-dev-shm-usage");
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        navigation = new NavigationPage(driver);
        sortable = new SortablePage(driver);
    }

    @After("@sortable")
    public void stopBrowser(Scenario finishedScenario) {
        if (driver == null) {
            return;
        }
        if (finishedScenario.isFailed()) {
            capture("99-falha-sortable");
        }
        driver.quit();
    }

    @Dado("que acesso Interactions e Sortable")
    public void accessSortable() {
        navigation.openHome();
        navigation.openSortable();
        sortable.useList();
        assertEquals(ASCENDING, sortable.labels(),
                "A massa de teste esperava os seis rótulos padrão na ordem inicial");
    }

    @Quando("crio uma ordem não crescente usando drag and drop")
    public void createNonAscendingOrder() {
        sortable.moveBefore("Six", "One");
        orderAfterDisturbance = sortable.labels();
        assertNotEquals(ASCENDING, orderAfterDisturbance,
                "O drag and drop de preparação deveria alterar a ordem inicial");
        scenario.log("Ordem criada por drag and drop: " + orderAfterDisturbance);
        capture("01-ordem-nao-crescente");
    }

    @Quando("reordeno os elementos em ordem crescente usando drag and drop")
    public void arrangeAscending() {
        sortable.arrange(ASCENDING);
    }

    @Entao("os elementos aparecem na ordem crescente de One a Six")
    public void validateAscendingOrder() {
        List<String> finalOrder = sortable.labels();
        assertNotEquals(orderAfterDisturbance, finalOrder,
                "A ordenação deveria modificar a ordem criada na preparação");
        assertEquals(ASCENDING, finalOrder,
                "A ordem final deveria conter exatamente One, Two, Three, Four, Five e Six");
        scenario.log("Ordem final observada no DOM: " + finalOrder);
        capture("02-ordem-crescente");
    }

    private void capture(String name) {
        byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(image, "image/png", name);
        String executionId = System.getProperty("execution.id");
        Path destination = executionId == null || executionId.isBlank()
                ? Path.of("target", "screenshots", "ui-05", name + ".png")
                : Path.of("evidencias", "slide-08-sortable",
                        executionId + "-automatizada", "screenshots", name + ".png");
        try {
            Files.createDirectories(destination.getParent());
            Files.write(destination, image);
        } catch (IOException error) {
            throw new IllegalStateException("Não foi possível salvar a captura " + destination, error);
        }
    }
}
