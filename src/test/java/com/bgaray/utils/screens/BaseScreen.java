package com.bgaray.utils.screens;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseScreen {
    protected AndroidDriver driver;
    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    protected void clickOnElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    protected void setText(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    protected void waitForVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
            return false;
        }
    }

    public void clearTextField(WebElement element) {
        if (isElementDisplayed(element)) {
            element.clear();
        }
    }
    protected void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        duration = duration.dividedBy(2);

        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(swipe));
    }

    protected void dragAndDropByPercentage(double startXPercentage, double startYPercentage, double endXPercentage, double endYPercentage, Duration duration) {
        Point start = getCoordinateByPercentage(startXPercentage, startYPercentage);
        Point end = getCoordinateByPercentage(endXPercentage, endYPercentage);

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence dragAndDrop = new Sequence(input, 0);

        dragAndDrop.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        dragAndDrop.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        dragAndDrop.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        dragAndDrop.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(ImmutableList.of(dragAndDrop));
    }

    protected Point getSwipeStartPosition(double xPercentage, double yPercentage) {
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        int startX = (int) (screenWidth * xPercentage);
        int startY = (int) (screenHeight * yPercentage);

        return new Point(startX, startY);
    }

    protected Point getSwipeEndPosition(double xPercentage, double yPercentage) {
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        int endX = (int) (screenWidth * xPercentage);
        int endY = (int) (screenHeight * yPercentage);

        return new Point(endX, endY);
    }

    protected Point getCoordinateByPercentage(double xPercentage, double yPercentage) {
        Dimension screenSize = driver.manage().window().getSize();

        int x = (int) (screenSize.width * xPercentage);
        int y = (int) (screenSize.height * yPercentage);

        return new Point(x, y);
    }
}
