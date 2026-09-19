package com.accenture.challenge.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Path;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PracticeFormPage extends BasePage {
    private static final By MODAL = By.className("modal-content");
    private static final By ACTIVE_MODAL = By.cssSelector(".modal.show");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void fill(StudentData student) {
        type(By.id("firstName"), student.firstName());
        type(By.id("lastName"), student.lastName());
        type(By.id("userEmail"), student.email());

        int genderIndex = List.of("Male", "Female", "Other").indexOf(student.gender()) + 1;
        click(By.cssSelector("label[for='gender-radio-" + genderIndex + "']"));
        type(By.id("userNumber"), student.mobile());

        click(By.id("dateOfBirthInput"));
        new Select(driver.findElement(By.className("react-datepicker__month-select")))
                .selectByIndex(student.dateOfBirth().getMonthValue() - 1);
        new Select(driver.findElement(By.className("react-datepicker__year-select")))
                .selectByVisibleText(Integer.toString(student.dateOfBirth().getYear()));
        click(By.cssSelector(String.format(
                ".react-datepicker__day--%03d:not(.react-datepicker__day--outside-month)",
                student.dateOfBirth().getDayOfMonth())));

        WebElement subject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subjectsInput")));
        subject.sendKeys(student.subject());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-option-0")));
        subject.sendKeys(Keys.ENTER);

        int hobbyIndex = List.of("Sports", "Reading", "Music").indexOf(student.hobby()) + 1;
        click(By.cssSelector("label[for='hobbies-checkbox-" + hobbyIndex + "']"));

        type(By.id("currentAddress"), student.address());
        chooseReactOption("react-select-3-input", student.state());
        chooseReactOption("react-select-4-input", student.city());
    }

    public void upload(Path file) {
        driver.findElement(By.id("uploadPicture")).sendKeys(file.toAbsolutePath().toString());
    }

    public void submit() {
        click(By.id("submit"));
    }

    public Map<String, String> receipt() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MODAL));
        Map<String, String> values = new HashMap<>();
        for (WebElement row : driver.findElements(By.cssSelector(".modal-content tbody tr"))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 2) {
                values.put(cells.get(0).getText(), cells.get(1).getText());
            }
        }
        return values;
    }

    public void close() {
        WebElement closeButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("closeLargeModal")));
        closeButton.click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.invisibilityOfElementLocated(ACTIVE_MODAL));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(MODAL));
            return;
        } catch (TimeoutException nativeClickDidNotCloseModal) {
            System.out.println("Clique nativo não fechou o popup; usando Escape como contingência acessível.");
            new Actions(driver).sendKeys(Keys.ESCAPE).perform();
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(ACTIVE_MODAL));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MODAL));
    }

    public boolean modalVisible() {
        return driver.findElements(MODAL).stream().anyMatch(WebElement::isDisplayed);
    }

    private void chooseReactOption(String inputId, String value) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id(inputId)));
        input.sendKeys(value);
        input.sendKeys(Keys.ENTER);
    }
}
