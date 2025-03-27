package appiumtest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class FileTransfer extends BaseTest {

    public void fileTransferMain() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // ---- File Transfer through Main Window ----
            WebElement filesTransferElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.Button[@text='Files Transfer']")));
            filesTransferElement.click();

            WebElement sendFileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.Button[@content-desc='button_send_file']")));
            sendFileButton.click();
            takeScreenshot("After_Send_File_Click");
            
            WebElement confirmationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button2']")));
            confirmationButton.click();
            

            System.out.println("----File Transfer Error----");

            // ---- Get Files from Envoy from File Transfer ----
            WebElement getFileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.Button[@content-desc='button_get_file']")));
            getFileButton.click();
            takeScreenshot("After_get_File_Click");
            
            WebElement confirmationButton01 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button2']")));
            confirmationButton01.click();
            

            System.out.println("----File Retrieval Error----");

            // Simulate pressing the back key
            Map<String, Object> keyEvent = new HashMap<String, Object>();
            keyEvent.put("keycode", 4);
            driver.executeScript("mobile: pressKey", keyEvent);

        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
