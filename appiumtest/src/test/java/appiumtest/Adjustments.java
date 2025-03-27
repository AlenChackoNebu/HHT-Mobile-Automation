package appiumtest;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class Adjustments extends BaseTest {

    public void adjustmentsMain() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to Adjustments
            WebElement adjustments = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Adjustments\")")));
            adjustments.click();
            
            System.out.println("----Navigated to Adjustments----");

            WebElement UPC_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_new")));
            UPC_Button.click();

            WebElement Select_Type = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Select Type\")")));
            Select_Type.click();

            WebElement Select_Increase = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"INC - Increase\")")));
            Select_Increase.click();

            WebElement Code = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("textbox_code")));
            Code.click();
            Code.sendKeys("008127100055");

            WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("textbox_qty")));
            qty.click();
            qty.sendKeys("10");

            WebElement post = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_post")));
            post.click();
            
            WebElement UMO_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("android:id/button2")));
            takeScreenshot("Adjustments_Error");
            UMO_Button.click();

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
