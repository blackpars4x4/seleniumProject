package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebOrderUtils {
    //Make the nethod static so that we don't need have to create instance of the class

    public static void loginToSmartBear(WebDriver driver) {

        //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUsername.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }
}
