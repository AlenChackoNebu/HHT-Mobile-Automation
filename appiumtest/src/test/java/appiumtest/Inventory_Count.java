package appiumtest;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class Inventory_Count extends BaseTest {

    public void inventoryCountMain() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to Inventory Count
            WebElement inventoryCount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Inventory Count\")")));
            inventoryCount.click();
            
            System.out.println("----Navigated to Inventory Count----");

            WebElement UPC_Search = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_new")));
            UPC_Search.click();

            WebElement code_entry = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("textbox_code")));
            code_entry.click();
            code_entry.sendKeys("008127100055");

            WebElement post_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_post")));
            post_button.click();
            takeScreenshot("Inventroy_Error");

            // Simulate pressing the back key
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));

            WebElement clear_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_clear")));
            clear_button.click();

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
