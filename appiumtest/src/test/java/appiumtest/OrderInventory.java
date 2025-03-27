package appiumtest;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class OrderInventory extends BaseTest {

    public void orderInventoryMain() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to Order Inventory
            WebElement orderInventory = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Order Inventory\")")));
            orderInventory.click();

            WebElement new_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_new")));
            new_button.click();

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("textbox_code")));
            code.click();
            
            // Enter original data here
            code.sendKeys("test data");
            
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
            
            takeScreenshot("Before_Order_Creation");

            WebElement post_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_post")));
            post_button.click();
            
            takeScreenshot("Order_Creation_Alert");
            
            WebElement warning_yes = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("android:id/button1")));
            warning_yes.click();
            
            takeScreenshot("Created_Order");

            WebElement order = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.ListView[@content-desc=\"listview_ord_header\"]/android.widget.LinearLayout[1]/android.view.ViewGroup")));
            order.click();

            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));

            WebElement return_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.className("android.widget.ImageButton")));
            return_Button.click();

            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
        
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
