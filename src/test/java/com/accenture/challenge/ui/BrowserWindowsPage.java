package com.accenture.challenge.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public final class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void openNewWindow() {
        click(By.id("windowButton"));
    }

    public void waitForWindowCount(int expectedCount) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(expectedCount));
    }

    public Set<String> windowHandles() {
        return driver.getWindowHandles();
    }

    public String message() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")))
                .getText().trim();
    }

    public boolean browserWindowsPageVisible() {
        return driver.findElements(By.xpath("//h1[normalize-space()='Browser Windows']"))
                .stream()
                .anyMatch(element -> element.isDisplayed());
    }
}
