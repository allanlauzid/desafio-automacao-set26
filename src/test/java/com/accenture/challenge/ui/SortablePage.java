package com.accenture.challenge.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public final class SortablePage extends BasePage {
    private static final By LIST_TAB = By.id("demo-tab-list");
    private static final By LIST_ITEMS = By.cssSelector(
            "#demo-tabpane-list .vertical-list-container .list-group-item");

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public void useList() {
        click(LIST_TAB);
        wait.until(ExpectedConditions.numberOfElementsToBe(LIST_ITEMS, 6));
    }

    public List<String> labels() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LIST_ITEMS))
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();
    }

    public void moveBefore(String sourceLabel, String targetLabel) {
        List<String> before = labels();
        if (!before.contains(sourceLabel) || !before.contains(targetLabel)) {
            throw new IllegalArgumentException("Elemento ausente na lista: " + before);
        }

        WebElement source = item(sourceLabel);
        WebElement target = item(targetLabel);
        int upwardOffset = -(Math.max(4, target.getSize().getHeight() / 3));

        new Actions(driver)
                .moveToElement(source)
                .clickAndHold()
                .pause(Duration.ofMillis(250))
                .moveToElement(target)
                .moveByOffset(0, upwardOffset)
                .pause(Duration.ofMillis(350))
                .release()
                .perform();

        wait.until(ignored -> !labels().equals(before));
        wait.until(ignored -> labels().indexOf(sourceLabel) < labels().indexOf(targetLabel));
    }

    public void arrange(List<String> expectedOrder) {
        for (int targetIndex = 0; targetIndex < expectedOrder.size(); targetIndex++) {
            String expectedLabel = expectedOrder.get(targetIndex);
            List<String> current = labels();
            if (current.get(targetIndex).equals(expectedLabel)) {
                continue;
            }
            moveBefore(expectedLabel, current.get(targetIndex));
        }
        wait.until(ignored -> labels().equals(expectedOrder));
    }

    private WebElement item(String label) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//*[@id='demo-tabpane-list']" +
                        "//*[contains(@class,'list-group-item') and normalize-space()='" + label + "']")));
    }
}
