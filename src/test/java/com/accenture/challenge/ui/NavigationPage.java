package com.accenture.challenge.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class NavigationPage extends BasePage {
    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public void openHome() {
        driver.get("https://demoqa.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'card-body')]/h5[normalize-space()='Forms']")));
    }

    public void openPracticeForm() {
        click(By.xpath("//div[contains(@class,'card-body')]/h5[normalize-space()='Forms']"));
        click(By.xpath("//span[normalize-space()='Practice Form']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[normalize-space()='Practice Form']")));
    }
}
