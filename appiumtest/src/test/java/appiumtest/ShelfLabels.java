package appiumtest;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class ShelfLabels extends BaseTest {

    public void shelfLabelsMain() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to Shelf Labels
            WebElement shelfLabels = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Shelf Labels\")")));
            shelfLabels.click();

            WebElement new_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_new")));
            new_button.click();

            WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("textbox_code")));
            textBox.click();
            
            // Enter original data here
            textBox.sendKeys("test data");
            
            driver.executeScript("mobile: pressKey", Collections.singletonMap("keycode", 4));
            
            WebElement postButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("button_post")));
            postButton.click();

            WebElement warning_yes = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("android:id/button1")));
            warning_yes.click();
            
            takeScreenshot("Shelf_Labels");

            WebElement back_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.className("android.widget.ImageButton")));
            back_button.click();
        
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
