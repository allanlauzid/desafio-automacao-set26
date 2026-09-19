package com.accenture.challenge.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ProgressBarPage extends BasePage {
    private static final By PROGRESS_BAR = By.id("progressBar");
    private static final By START_STOP = By.id("startStopButton");
    private static final By RESET = By.id("resetButton");

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public int value() {
        WebElement bar = wait.until(ExpectedConditions.visibilityOfElementLocated(PROGRESS_BAR));
        String accessibleValue = bar.getAttribute("aria-valuenow");
        if (accessibleValue != null && !accessibleValue.isBlank()) {
            return Integer.parseInt(accessibleValue.trim());
        }
        String visibleValue = bar.getText().trim().replace("%", "");
        return visibleValue.isBlank() ? 0 : Integer.parseInt(visibleValue);
    }

    public void start() {
        click(START_STOP);
        wait.until(ExpectedConditions.textToBe(START_STOP, "Stop"));
    }

    public void stop() {
        click(START_STOP);
        wait.until(ExpectedConditions.textToBe(START_STOP, "Start"));
    }

    public int waitUntilAtLeast(int target) {
        WebDriverWait preciseWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        preciseWait.pollingEvery(Duration.ofMillis(50));
        return preciseWait.until(ignored -> {
            int current = value();
            return current >= target ? current : null;
        });
    }

    public void waitUntilComplete() {
        wait.until(ignored -> value() == 100);
        wait.until(ExpectedConditions.elementToBeClickable(RESET));
    }

    public void reset() {
        click(RESET);
        wait.until(ignored -> value() == 0);
        wait.until(ExpectedConditions.elementToBeClickable(START_STOP));
    }
}
