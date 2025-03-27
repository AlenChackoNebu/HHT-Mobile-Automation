package appiumtest;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class Deliveries extends BaseTest {

    public void deliveriesMain() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to Deliveries
            WebElement deliveries = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Deliveries\")")));
            deliveries.click();
            
            System.out.println("----Navigated to Deliveries----");

            WebElement Button_Search = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_search")));
            Button_Search.click();

            WebElement button_Post = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_post")));
            button_Post.click();
            
            WebElement Error_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("android:id/button2")));
            takeScreenshot("Before_Error_Button_Click");
            Error_Button.click();

            // Simulate pressing the back key
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
        
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
