# 📱 HHT-Mobile-Automation

🚀 **Automating HHT mobile application using Appium, Java, and Selenium.**

---

## 📖 Table of Contents
- [📱 HHT-Mobile-Automation](#-hht-mobile-automation)
- [Appium Installation and Setup Guide](#-appium-installation-and-setup-guide)
  - [1️⃣ Install Java JDK](#1️⃣-install-java-jdk)
  - [2️⃣ Install Android Studio](#2️⃣-install-android-studio)
  - [3️⃣ Install Appium](#3️⃣-install-appium)
  - [4️⃣ Start Appium Server](#4️⃣-start-appium-server)
  - [5️⃣ Install Appium Desktop (Optional)](#5️⃣-install-appium-desktop-optional)
  - [6️⃣ Install Appium Doctor](#6️⃣-install-appium-doctor)
  - [7️⃣ Install Appium Client Libraries](#7️⃣-install-appium-client-libraries)
  - [8️⃣ Create and Configure an Emulator](#8️⃣-create-and-configure-an-emulator)
  - [9️⃣ Running the Appium Test Script](#9️⃣-running-the-appium-test-script)
- [Introduction to HHT Mobile Automation - Using Appium & Selenium](#-introduction-to-hht-mobile-automation--using-appium--selenium)
  - [1️⃣ Setting Up the Appium Driver](#1️⃣-setting-up-the-appium-driver)
  - [2️⃣ Executing Test Steps](#2️⃣-executing-test-steps)
  - [3️⃣ Running the Test](#3️⃣-running-the-test)
  - [4️⃣ Validation and Assertions](#4️⃣-validation-and-assertions)
  - [5️⃣ Test Completion & Reporting](#5️⃣-test-completion--reporting)
- [HHT Mobile Automation Code Explanation](#-hht-mobile-automation-code-explanation)
  - [🛠 `TestRunner`: Execution Flow & Design](#-testrunner-execution-flow--design)
  - [Supporting Test Classes: Overview](#-supporting-test-classes-overview)
    - [🔹 `BaseTest`](#-basetest)
    - [🔹 `FileTransfer`](#-filetransfer)
    - [🔹 `Inventory_Count`](#-inventory_count)
    - [🔹 `Adjustments`](#-adjustments)
    - [🔹 `Deliveries`](#-deliveries)
    - [🔹 `PriceCheck`](#-pricecheck)
    - [🔹 `OrderInventory`](#-orderinventory)
    - [🔹 `ShelfLabels`](#-shelflabels)
- [ℹ️ Additional Information](#ℹ️-additional-information)

---
## Appium Installation and Setup Guide
### 1. Install Java JDK
1. Download Java JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Install and set up the environment variables:
- ` JAVA_HOME = C:\Program Files\Java\jdk-<version> `.
-  Add ` JAVA_HOME\bin ` to the ` PATH ` variable.
### 2. Install Android Studio
1. Download and install Android Studio from the [official website](https://developer.android.com/studio).
2. Install the required SDKs and tools:
- Open Android Studio > SDK Manager.
- Install the latest SDK, SDK Tools, and AVD Manager.
3. Configure environment variables:
- ` ANDROID_HOME = C:\Users\<User>\AppData\Local\Android\Sdk `
- Add the following paths to PATH:
  - ` %ANDROID_HOME%\platform-tools `
  - ` %ANDROID_HOME%\tools `
  - ` %ANDROID_HOME%\tools\bin `
### 3. Install Appium
1. Install Node.js from [Node.js official website](https://nodejs.org/).
2. Open Command Prompt and install Appium globally:
` npm install -g appium `
3. Verify installation:
` appium -v `
### 4. Start Appium Server
Run the following command to start Appium with the correct base path:
` appium --base-path /wd/hub `
### 5. Install Appium Desktop (Optional)
Download and install [Appium Desktop](https://github.com/appium/appium-desktop/releases) for a GUI-based server.
### 6. Install Appium Doctor
Verify your setup using Appium Doctor:
- ` npm install -g appium-doctor `
- ` appium-doctor `
### 7. Install Appium Client Libraries
For Java, install the following dependencies in your project:
```
<dependency>  
    <groupId>io.appium</groupId>      
    <artifactId>java-client</artifactId>      
    <version>8.0.0</version>      
</dependency>
```
### 8. Create and Configure an Emulator
- Open Android Studio > AVD Manager.
- Create a new virtual device and select the latest system image.
- Start the emulator and verify using:
` adb devices `
### 9. Running the Appium Test Script
Write your test script using Java and Appium:
Current Capability set 
```json
{
  "appium:automationName": "UiAutomator2",
  "appium:platformName": "Android",
  "appium:platformVersion": "13",
  "appium:deviceName": "**********",
  "appium:app": "C:\\*****\\****\\*******\\envoyHHT.apk"
}
```
---

## Introduction to HHT Mobile Automation- Using Appium Selenium
This code is designed to automate the testing of our Android application using **Appium with Java in Eclipse**. It interacts with the app installed on an emulator, performing actions such as launching the app, interacting with UI elements, and validating expected results.

### Code Breakdown:
#### 1. Setting Up the Appium Driver:
- The code initializes an **AndroidDriver** by defining the desired capabilities.
- The capabilities specify the emulator/device name, the Android version, the app’s package and activity, and the Appium server details.
- It ensures that Appium connects to the emulator and launches the application under test.
#### 2. Executing Test Steps:
- The script interacts with the app by performing actions such as:
  - Clicking on buttons
  - Entering text in input fields
  - Navigating through screens
  - Validating the presence of elements
- It locates elements using XPath, ID, Accessibility ID, or other locator strategies.
#### 3. Running the Test:
- Before executing the script, Appium must be started with the following command:
  ` appium --base-path /wd/hub `
- This ensures that Appium listens for incoming requests and allows the script to communicate with the mobile device/emulator.
- The test script then connects to the Appium server ` (http://localhost:4723/wd/hub) ` and starts executing the test cases.
#### 4. Validation and Assertions:
- The script includes assertions to verify that actions were successful (e.g., checking if a button was clicked or text was entered correctly).
- It logs test execution details, making it easier to debug issues if a test fails.
#### 5. Test Completion & Reporting:
- After execution, the script cleans up by closing the driver.
- Test results are logged to help analyze failures and debugging.

---

## HHT Mobile Automation- Code Explanation
This document explains the structure and functionality of our Appium Automation Code, including the role of the **TestRunner** class.
### `TestRunner`: Execution Flow & Design
The ` TestRunner ` class is the main entry point for test execution. All test execution starts from here, ensuring a structured and modular workflow.
Execution Flow
#### 1. Initialization
- Instantiates core test modules (` BaseTest `, functional test classes).
- ` BaseTest ` handles app lifecycle and authentication.
#### 2. Test Execution
- Opens the app → Logs in → Executes test modules sequentially → Logs out → Closes the app.
- Enforces a structured, controlled test flow.
#### 3. Error Handling
- Captures exceptions (`e.getCause()`, `e.getMessage()`) for fault isolation.
- Prevents execution failures from halting the suite

### Supporting Test Classes: Overview
#### 1. `BaseTest`
Manages app lifecycle: opens the app, logs in, logs out, and closes the app. Ensures smooth execution flow.
#### 2. `FileTransfer`
Handles file-related operations within the app, ensuring seamless data movement.
#### 3. `Inventory_Count`
Executes inventory counting functionalities, validating stock levels and updates.
#### 4. `Adjustments`
Manages inventory adjustments, ensuring correct stock modifications.
#### 5. `Deliveries`
Processes delivery transactions, verifying inbound stock accuracy.
#### 6. `PriceCheck`
Automates price verification to ensure correct pricing across inventory.
#### 7. `OrderInventory`
Handles inventory ordering workflows, ensuring stock replenishment.
#### 8. `ShelfLabels`
Manages shelf label operations, ensuring accurate product labeling.

---
Each class follows a modular structure, making the framework scalable and maintainable. 🚀

## ℹ️ Additional Information  
You can also use an **Android Emulator** instead of a physical device to automate the application using Appium.  
Simply configure the emulator in **Android Studio > AVD Manager**, start the emulator, and ensure it is detected using:  

```sh
adb devices
```
---
Let me know if you want any tweaks! 😊
Happy Testing! 🎯


