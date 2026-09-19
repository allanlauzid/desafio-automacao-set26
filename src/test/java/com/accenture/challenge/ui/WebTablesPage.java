package com.accenture.challenge.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public final class WebTablesPage extends BasePage {
    private static final By SEARCH = By.id("searchBox");
    private static final By ROWS = By.cssSelector("table tbody tr");
    private static final By MODAL = By.id("registration-form-modal");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public void showTwentyRows() {
        new Select(wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("select.form-control"))))
                .selectByValue("20");
    }

    public void create(PersonData person) {
        clearSearch();
        int rowsBefore = driver.findElements(ROWS).size();
        click(By.id("addNewRecordButton"));
        fillForm(person);
        click(By.id("submit"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MODAL));
        wait.until(driver -> driver.findElements(ROWS).size() == rowsBefore + 1
                && findRow(person.email()).isPresent());
    }

    public void edit(String currentEmail, PersonData edited) {
        clearSearch();
        WebElement row = waitForRow(currentEmail);
        row.findElement(By.cssSelector("[id^='edit-record-']")).click();
        fillForm(edited);
        click(By.id("submit"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MODAL));
    }

    public int delete(String email) {
        clearSearch();
        int rowsBefore = driver.findElements(ROWS).size();
        WebElement row = waitForRow(email);
        row.findElement(By.cssSelector("[id^='delete-record-']")).click();
        wait.until(driver -> findRow(email).isEmpty());
        return rowsBefore - driver.findElements(ROWS).size();
    }

    public String deleteActionId(String email) {
        clearSearch();
        return waitForRow(email)
                .findElement(By.cssSelector("[id^='delete-record-']"))
                .getAttribute("id");
    }

    public PersonData read(String email) {
        clearSearch();
        List<WebElement> cells = waitForRow(email).findElements(By.tagName("td"));
        return new PersonData(
                cells.get(0).getText().trim(),
                cells.get(1).getText().trim(),
                cells.get(3).getText().trim(),
                Integer.parseInt(cells.get(2).getText().trim()),
                Integer.parseInt(cells.get(4).getText().trim()),
                cells.get(5).getText().trim()
        );
    }

    public boolean exists(String email) {
        clearSearch();
        return findRow(email).isPresent();
    }

    public void clearSearch() {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH));
        search.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        wait.until(driver -> search.getAttribute("value").isEmpty());
        wait.until(driver -> !driver.findElements(ROWS).isEmpty());
    }

    public void dismissModalIfPresent() {
        if (driver.findElements(By.cssSelector(".modal.show")).stream().anyMatch(WebElement::isDisplayed)) {
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(MODAL));
        }
    }

    private WebElement waitForRow(String email) {
        return wait.until(driver -> findRow(email).orElse(null));
    }

    private Optional<WebElement> findRow(String email) {
        return driver.findElements(ROWS).stream()
                .filter(WebElement::isDisplayed)
                .filter(row -> row.findElements(By.tagName("td")).stream()
                        .anyMatch(cell -> email.equals(cell.getText().trim())))
                .findFirst();
    }

    private void fillForm(PersonData person) {
        type(By.id("firstName"), person.firstName());
        type(By.id("lastName"), person.lastName());
        type(By.id("userEmail"), person.email());
        type(By.id("age"), Integer.toString(person.age()));
        type(By.id("salary"), Integer.toString(person.salary()));
        type(By.id("department"), person.department());
    }
}
