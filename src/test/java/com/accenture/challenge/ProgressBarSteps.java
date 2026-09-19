package com.accenture.challenge;

import com.accenture.challenge.ui.NavigationPage;
import com.accenture.challenge.ui.ProgressBarPage;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgressBarSteps {
    private WebDriver driver;
    private Scenario scenario;
    private NavigationPage navigation;
    private ProgressBarPage progressBar;
    private int valueBeforeStop;
    private int stoppedValue;

    @Before("@progress-bar")
    public void startBrowser(Scenario scenario) {
        this.scenario = scenario;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080", "--disable-dev-shm-usage");
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        navigation = new NavigationPage(driver);
        progressBar = new ProgressBarPage(driver);
    }

    @After("@progress-bar")
    public void stopBrowser(Scenario finishedScenario) {
        if (driver == null) {
            return;
        }
        if (finishedScenario.isFailed()) {
            capture("99-falha-progress-bar");
        }
        driver.quit();
    }

    @Dado("que acesso Widgets e Progress Bar")
    public void accessProgressBar() {
        navigation.openHome();
        navigation.openProgressBar();
        assertEquals(0, progressBar.value(), "A barra deveria iniciar em 0%");
    }

    @Quando("inicio a barra e solicito a parada antes de {int}%")
    public void startAndStopBefore(int maximum) {
        progressBar.start();
        valueBeforeStop = progressBar.waitUntilAtLeast(10);
        assertTrue(valueBeforeStop < maximum,
                "A solicitação de parada ocorreu tarde, em " + valueBeforeStop + "%");
        progressBar.stop();
        stoppedValue = progressBar.value();
        scenario.log("Valor observado imediatamente antes do clique em Stop: " + valueBeforeStop + "%");
        scenario.log("Valor estabilizado depois do clique em Stop: " + stoppedValue + "%");
    }

    @Entao("a barra permanece parada com valor maior que {int}% e menor ou igual a {int}%")
    public void validateStoppedValue(int minimum, int maximum) {
        assertTrue(stoppedValue > minimum,
                "A barra deveria ter avançado além de " + minimum + "%, mas parou em " + stoppedValue + "%");
        assertTrue(stoppedValue <= maximum,
                "A barra deveria parar em até " + maximum + "%, mas parou em " + stoppedValue + "%");
        assertEquals(stoppedValue, progressBar.value(), "A barra deveria permanecer parada");
        capture("01-barra-parada-ate-25");
    }

    @Quando("inicio a barra novamente e aguardo chegar a {int}%")
    public void resumeUntilComplete(int expected) {
        progressBar.start();
        progressBar.waitUntilComplete();
        assertEquals(expected, progressBar.value());
        capture("02-barra-em-100");
    }

    @Quando("reseto a barra")
    public void resetProgressBar() {
        progressBar.reset();
    }

    @Entao("a barra retorna a {int}%")
    public void validateReset(int expected) {
        assertEquals(expected, progressBar.value());
        capture("03-barra-resetada-em-0");
    }

    private void capture(String name) {
        byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(image, "image/png", name);
        String executionId = System.getProperty("execution.id");
        Path destination = executionId == null || executionId.isBlank()
                ? Path.of("target", "screenshots", "ui-04", name + ".png")
                : Path.of("evidencias", "slide-07-progress-bar",
                        executionId + "-automatizada", "screenshots", name + ".png");
        try {
            Files.createDirectories(destination.getParent());
            Files.write(destination, image);
        } catch (IOException error) {
            throw new IllegalStateException("Não foi possível salvar a captura " + destination, error);
        }
    }
}
