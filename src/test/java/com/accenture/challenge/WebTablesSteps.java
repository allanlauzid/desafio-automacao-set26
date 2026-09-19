package com.accenture.challenge;

import com.accenture.challenge.ui.NavigationPage;
import com.accenture.challenge.ui.PersonData;
import com.accenture.challenge.ui.WebTablesPage;
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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebTablesSteps {
    private final List<String> trackedEmails = new ArrayList<>();
    private final List<PersonData> bonusRecords = new ArrayList<>();
    private WebDriver driver;
    private Scenario scenario;
    private NavigationPage navigation;
    private WebTablesPage table;
    private PersonData original;
    private PersonData edited;
    private long seed;

    @Before("@web-tables")
    public void startBrowser(Scenario scenario) {
        this.scenario = scenario;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080", "--disable-dev-shm-usage");
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        navigation = new NavigationPage(driver);
        table = new WebTablesPage(driver);
    }

    @After("@web-tables")
    public void stopBrowser(Scenario finishedScenario) {
        if (driver == null) {
            return;
        }
        if (finishedScenario.isFailed()) {
            attachScreenshot("falha-web-tables");
        }
        try {
            table.dismissModalIfPresent();
            for (String email : List.copyOf(trackedEmails)) {
                if (table.exists(email)) {
                    table.delete(email);
                }
            }
        } catch (RuntimeException cleanupError) {
            scenario.log("Limpeza não concluída: " + cleanupError.getClass().getSimpleName());
        } finally {
            driver.quit();
        }
    }

    @Dado("que acesso Elements e Web Tables")
    public void accessWebTables() {
        navigation.openHome();
        navigation.openWebTables();
        table.showTwentyRows();
    }

    @Quando("crio um registro com dados fictícios únicos")
    public void createUniqueRecord() {
        seed = Long.getLong("test.seed", System.currentTimeMillis());
        original = new PersonData(
                "Ana",
                "Teste",
                "qa.webtable." + Long.toUnsignedString(seed) + "@example.com",
                27,
                4800,
                "Quality Assurance"
        );
        edited = new PersonData(
                "Ana",
                "Editada",
                original.email(),
                28,
                5200,
                "Automation"
        );
        trackedEmails.add(original.email());
        scenario.log("Semente dos dados: " + seed);
        scenario.log("Registro original: " + original);
        table.create(original);
    }

    @Entao("o registro apresenta os dados cadastrados")
    public void validateCreatedRecord() {
        assertEquals(original, table.read(original.email()));
        attachScreenshot("registro-criado-ui-03");
    }

    @Quando("edito o mesmo registro")
    public void editSameRecord() {
        table.edit(original.email(), edited);
    }

    @Entao("o registro apresenta os dados atualizados")
    public void validateEditedRecord() {
        assertEquals(edited, table.read(edited.email()));
        attachScreenshot("registro-editado-ui-03");
    }

    @Quando("excluo o registro criado")
    public void deleteCreatedRecord() {
        table.delete(edited.email());
        trackedEmails.remove(edited.email());
    }

    @Entao("o registro não aparece mais na tabela")
    public void validateDeletedRecord() {
        assertFalse(table.exists(edited.email()),
                "O registro excluído ainda aparece na tabela");
        attachScreenshot("registro-excluido-ui-03");
    }

    @Quando("crio {int} registros com dados únicos")
    public void createDynamicRecords(int quantity) {
        seed = Long.getLong("test.seed", System.currentTimeMillis());
        scenario.log("Semente dos dados: " + seed);
        for (int index = 0; index < quantity; index++) {
            char suffix = (char) ('A' + index);
            PersonData person = new PersonData(
                    "Registro" + suffix,
                    "Dinamico" + suffix,
                    "qa.webtable." + Long.toUnsignedString(seed) + "." + index + "@example.com",
                    20 + index,
                    3000 + (index * 100),
                    "Quality " + suffix
            );
            bonusRecords.add(person);
            trackedEmails.add(person.email());
            table.create(person);
        }
        scenario.log("Registros criados dinamicamente: " + bonusRecords.size());
    }

    @Entao("os {int} registros aparecem na tabela")
    public void validateDynamicRecords(int quantity) {
        assertEquals(quantity, bonusRecords.size());
        Map<String, String> actionIds = new LinkedHashMap<>();
        for (PersonData person : bonusRecords) {
            assertEquals(person, table.read(person.email()));
            actionIds.put(person.email(), table.deleteActionId(person.email()));
        }
        scenario.log("IDs de exclusão observados: " + actionIds);
        scenario.log("Quantidade de IDs de exclusão distintos: "
                + actionIds.values().stream().distinct().count());
        attachScreenshot("doze-registros-criados-ui-bonus-01");
    }

    @Quando("excluo todos os registros criados")
    public void deleteAllCreatedRecords() {
        for (PersonData person : bonusRecords) {
            if (!table.exists(person.email())) {
                scenario.log("Registro já ausente após ação anterior: " + person.email());
                trackedEmails.remove(person.email());
                continue;
            }
            String actionId = table.deleteActionId(person.email());
            int removedRows = table.delete(person.email());
            scenario.log("Ação " + actionId + " em " + person.email()
                    + " removeu " + removedRows + " linha(s)");
            for (PersonData candidate : bonusRecords) {
                if (!table.exists(candidate.email())) {
                    trackedEmails.remove(candidate.email());
                }
            }
        }
    }

    @Entao("nenhum dos {int} registros permanece na tabela")
    public void validateAllDynamicRecordsDeleted(int quantity) {
        assertEquals(quantity, bonusRecords.size());
        for (PersonData person : bonusRecords) {
            assertFalse(table.exists(person.email()),
                    "O registro ainda aparece na tabela: " + person.email());
        }
        table.clearSearch();
        attachScreenshot("doze-registros-excluidos-ui-bonus-01");
        assertTrue(trackedEmails.isEmpty(),
                "Ainda existem registros criados pendentes de limpeza");
    }

    private void attachScreenshot(String name) {
        scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                "image/png", name);
    }
}
