package appiumtest;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class PriceCheck extends BaseTest {

    public void priceCheckMain() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to Price Check
            WebElement price_Check = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Price Check\")")));
            price_Check.click();
            
            System.out.println("----Navigated to Price Check----");

            WebElement textbox_sku = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("textbox_sku")));
            textbox_sku.click();
            
            // Enter original data here
            textbox_sku.sendKeys("test data");
            
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));

            WebElement clear_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_clear")));
            takeScreenshot("Before_Clear_Button_Click");
            clear_button.click();

            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
        
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
