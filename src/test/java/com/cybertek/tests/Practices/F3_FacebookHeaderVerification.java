package com.cybertek.tests.Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F3_FacebookHeaderVerification {
    public static void main(String[] args) {


        //TC #3: Facebook header verification
        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        // 3.Verify header text is as expected:
        // Expected: “Connect with friends and the world around you on Facebook.”
        String expectedHeader = "Connect with friends and the world around you on Facebook.";
        String actualHeader = driver.findElement(By.className("_8eso")).getText();

        if(expectedHeader.equals(actualHeader)){
            System.out.println("Header verification is passed!");
        }else {
            System.out.println("Header verification is failed!");
        }

    }
}
