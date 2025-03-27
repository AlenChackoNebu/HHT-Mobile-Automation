package appiumtest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

    protected static AppiumDriver driver;

    public void openApp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Standard capabilities
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");

        // Device capabilities
        capabilities.setCapability("appium:deviceName", "Android_03");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:udid", "R9ZTB00C1BD");

        // App-specific capabilities
        capabilities.setCapability("appium:appPackage", "com.PDISoftware.EnvoyHHT");
        capabilities.setCapability("appium:appActivity", "crc64aaf8ebbeb40d89a7.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);

        System.out.println("----Application started----");
        Thread.sleep(3000);
    }

    public void login() throws Exception {
        WebElement username = driver.findElement(AppiumBy.accessibilityId("textbox_user_name"));
        WebElement password = driver.findElement(AppiumBy.accessibilityId("textbox_password"));
        WebElement login = driver.findElement(AppiumBy.accessibilityId("button_login"));

        username.sendKeys("Admin");
        password.sendKeys("admin");
        login.click();

        System.out.println("----Logged in to Envoy HHT----");
        Thread.sleep(3000);
    }

    public void closeApp() {
        if (driver != null) {
            driver.quit();
            System.out.println("----Application closed----");
        }
    }
    
    public void logout() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click OK button
        WebElement side_bar = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.accessibilityId("OK")));
        side_bar.click();

        // Click Logout
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(58)")));
        logout.click();

        System.out.println("----Logged out from Envoy HHT----");
        Thread.sleep(3000);
    }

    
    public void takeScreenshot(String screenshotName) {
        try {
            // Generate a unique timestamp-based filename for the screenshot
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png");
            FileUtils.copyFile(screenshotFile, destinationFile);
            System.out.println("Screenshot saved: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
