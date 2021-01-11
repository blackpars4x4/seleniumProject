package com.cybertek.tests.Practices.xpathTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Practice_Cybertek_Forgot_Password {
    public static void main(String[] args) {

        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        // 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        // a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));

        // b. “Forgot password” header
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        // c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));

        // d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='text']"));

        // e. “Retrieve password” button
        WebElement retrievePassword = driver.findElement(By.xpath("//button[@id='form_submit']"));

        // f. “Powered byCybertek School” text
        WebElement powerByLinkText = driver.findElement(By.xpath("//a[.='Cybertek School']/.."));

        // 4. Verify all WebElements are displayed.
        if (homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed() && emailText.isDisplayed()
                && emailInputBox.isDisplayed() && retrievePassword.isDisplayed() && powerByLinkText.isDisplayed()){
            System.out.println("All of the web Elements are displayed. PASS!");
        }else {
            System.out.println("All of the web Elements are not displayed. FAILED!");
        }


    }
}