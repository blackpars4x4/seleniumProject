package com.cybertek.tests.day4_findelements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_Xpath_CssSelector {
    public static void main(String[] args) {

        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        // 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // 3. Locate all the WebElements on the page using XPATH and/or CSSlocator only (total of 6)

        // a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));

        //locating the same link using class attribute's value
        //WebElement homeLink = driver.findElement(By.xpath("//a[@class='nac-link']"));

        //locating the same link using href attribute's value
        //WebElement homeLink = driver.findElement(By.xpath("//a[@href='/']"));

        // b. “Forgot password” header
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));


        // c. “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        //locating the same label using its TEXT with xpath
        //WebElement emailLabel = driver.findElement(By.xpath("//label[.='E-mail']"));

        // d. E-mail input box
        //Option#1; using syntax #1, tagName[attribute='value']
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text']"));
        //Option#2; using name attribute to same web element
        //WebElement emailInputBox = driver.findElement(By.cssSelector("input[name='email']"));

        // e. “Retrieve password” button
        //Locating the button using #2 cssSelector syntax
        //tagName.classValue
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button.radius"));


        //tagName#idValue
        //WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button#form_submit"));

        // f. “Powered byCybertek School” text
        WebElement footerText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        // 4. Verify all WebElements are displayed.
        if(homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed()
                && emailLabel.isDisplayed() && emailInputBox.isDisplayed()
                && retrievePasswordButton.isDisplayed() && footerText.isDisplayed() ){
            System.out.println("ALL WEB ELEMENTS ARE DISPLAYED. VERIFICATION PASSED!");
        }else{
            System.out.println("One or more of the web elements are not displayed. Verification FAILED!!!");
        }

    }
}