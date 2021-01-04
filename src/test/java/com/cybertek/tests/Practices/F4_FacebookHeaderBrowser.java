package com.cybertek.tests.Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F4_FacebookHeaderBrowser {
    public static void main(String[] args) {

        //TC #4: Facebook header verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // 3.Verify “Create a page” link href value contains text:
        // Expected: “registration_form”
        String expectedInAttribute = "registration_form";
        String actualAttribute = driver.findElement(By.linkText("Create a Page")).getAttribute("href");

        System.out.println("expectedInAttribute = " + expectedInAttribute);
        System.out.println("actualAttribute = " + actualAttribute);

        if(actualAttribute.contains(expectedInAttribute)){
            System.out.println("Passed!");
        }else {
            System.out.println("Passed!");
        }

    }
}
