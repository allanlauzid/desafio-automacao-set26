package com.accenture.challenge;

import com.accenture.challenge.ui.BrowserWindowsPage;
import com.accenture.challenge.ui.NavigationPage;
import com.accenture.challenge.ui.PracticeFormPage;
import com.accenture.challenge.ui.StudentData;
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

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeFormSteps {
    private WebDriver driver;
    private Scenario scenario;
    private NavigationPage navigation;
    private PracticeFormPage form;
    private BrowserWindowsPage browserWindows;
    private StudentData student;
    private long seed;
    private String originalWindow;
    private String newWindow;
    private Set<String> originalHandles;

    @Before("@ui and not @web-tables and not @progress-bar and not @sortable")
    public void startBrowser(Scenario scenario) {
        this.scenario = scenario;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080", "--disable-dev-shm-usage");
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        navigation = new NavigationPage(driver);
        form = new PracticeFormPage(driver);
        browserWindows = new BrowserWindowsPage(driver);
    }

    @After("@ui and not @web-tables and not @progress-bar and not @sortable")
    public void stopBrowser(Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                String evidenceName = scenario.getSourceTagNames().contains("@ui-02")
                        ? "falha-ui-02"
                        : "falha-ui-01";
                scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                        "image/png", evidenceName);
            }
            driver.quit();
        }
    }

    @Dado("que acesso o DemoQA")
    public void accessDemoQa() {
        navigation.openHome();
    }

    @Dado("abro Forms e Practice Form")
    public void openPracticeForm() {
        navigation.openPracticeForm();
    }

    @Quando("preencho todos os campos com dados fictícios válidos")
    public void fillForm() {
        seed = Long.getLong("test.seed", System.currentTimeMillis());
        student = generateStudent(seed);
        scenario.log("Semente dos dados: " + seed);
        scenario.log("Dados fictícios: " + student);
        form.fill(student);
    }

    @Quando("envio o arquivo TXT versionado no projeto")
    public void uploadTxt() throws URISyntaxException {
        Path file = Path.of(Objects.requireNonNull(
                getClass().getResource("/files/practice-form-upload.txt")).toURI());
        form.upload(file);
    }

    @Quando("submeto o formulário")
    public void submitForm() {
        form.submit();
    }

    @Entao("o popup apresenta os mesmos dados enviados")
    public void validatePopup() {
        Map<String, String> receipt = form.receipt();
        assertEquals(student.firstName() + " " + student.lastName(), receipt.get("Student Name"));
        assertEquals(student.email(), receipt.get("Student Email"));
        assertEquals(student.gender(), receipt.get("Gender"));
        assertEquals(student.mobile(), receipt.get("Mobile"));
        assertEquals(student.dateOfBirth().format(
                DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH)),
                receipt.get("Date of Birth"));
        assertEquals(student.subject(), receipt.get("Subjects"));
        assertEquals(student.hobby(), receipt.get("Hobbies"));
        assertEquals("practice-form-upload.txt", receipt.get("Picture"));
        assertEquals(student.address(), receipt.get("Address"));
        assertEquals(student.state() + " " + student.city(), receipt.get("State and City"));
        scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                "image/png", "popup-practice-form");
    }

    @Quando("fecho o popup")
    public void closePopup() {
        form.close();
    }

    @Entao("o popup deixa de ser exibido")
    public void validatePopupClosed() {
        assertFalse(form.modalVisible(), "O popup permaneceu visível após o fechamento");
    }

    @Dado("abro Alerts, Frame & Windows e Browser Windows")
    public void openBrowserWindows() {
        navigation.openBrowserWindows();
    }

    @Quando("solicito a abertura de uma nova janela")
    public void requestNewWindow() {
        originalWindow = driver.getWindowHandle();
        originalHandles = Set.copyOf(browserWindows.windowHandles());
        browserWindows.openNewWindow();
    }

    @Entao("uma nova janela é aberta")
    public void validateNewWindow() {
        browserWindows.waitForWindowCount(originalHandles.size() + 1);
        Set<String> addedHandles = new HashSet<>(browserWindows.windowHandles());
        addedHandles.removeAll(originalHandles);
        assertEquals(1, addedHandles.size(),
                "Deveria existir exatamente uma nova janela");
        newWindow = addedHandles.iterator().next();
        assertNotEquals(originalWindow, newWindow,
                "A nova janela deve ter um identificador diferente da original");
        driver.switchTo().window(newWindow);
    }

    @Entao("apresenta a mensagem {string}")
    public void validateNewWindowMessage(String expectedMessage) {
        assertEquals(expectedMessage, browserWindows.message());
        scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                "image/png", "nova-janela-ui-02");
    }

    @Quando("fecho a nova janela")
    public void closeNewWindow() {
        assertEquals(newWindow, driver.getWindowHandle(),
                "O foco deveria estar na nova janela antes de fechá-la");
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Entao("apenas a janela original permanece aberta")
    public void validateOnlyOriginalWindow() {
        browserWindows.waitForWindowCount(originalHandles.size());
        assertEquals(originalHandles, browserWindows.windowHandles());
        assertEquals(originalWindow, driver.getWindowHandle());
        assertTrue(browserWindows.browserWindowsPageVisible(),
                "A página Browser Windows deveria continuar disponível na janela original");
    }

    private static StudentData generateStudent(long seed) {
        Random random = new Random(seed);
        String firstName = choose(random, List.of("Ana", "Beatriz", "Camila", "Diana"));
        String lastName = choose(random, List.of("Lima", "Moraes", "Souza", "Vieira"));
        String email = "qa" + Long.toUnsignedString(seed) + random.nextInt(10_000) + "@example.com";
        String mobile = (6 + random.nextInt(4)) + String.format("%09d", random.nextInt(1_000_000_000));
        LocalDate birth = LocalDate.of(
                1980 + random.nextInt(26), 1 + random.nextInt(12), 1 + random.nextInt(28));
        String[] location = choose(random, List.of(
                new String[]{"NCR", "Delhi"},
                new String[]{"Haryana", "Karnal"},
                new String[]{"Rajasthan", "Jaipur"},
                new String[]{"Uttar Pradesh", "Agra"}
        ));
        return new StudentData(
                firstName,
                lastName,
                email,
                choose(random, List.of("Male", "Female", "Other")),
                mobile,
                birth,
                choose(random, List.of("Maths", "English", "Chemistry")),
                choose(random, List.of("Sports", "Reading", "Music")),
                "Rua de Teste, " + (1 + random.nextInt(999)),
                location[0],
                location[1]
        );
    }

    private static <T> T choose(Random random, List<T> values) {
        return values.get(random.nextInt(values.size()));
    }
}
