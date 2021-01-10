package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {

        // TC #2: Zero Bank link text verification

        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        // Open browser and set driver instance
        WebDriver driver = new ChromeDriver();

        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // maximize the windows
        driver.manage().window().maximize();

        // 3.Verify link text from top left:
        WebElement zeroBankLink = driver.findElement(By.className("brand"));
        //   Expected: “Zero Bank”

        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();

        if(expectedLinkText.equals(actualLinkText)) {
            System.out.println("Verification is Passed!");
        }else {
            System.out.println("Verification is Failed!");
            System.out.println("actualLinkText = " + actualLinkText);
            System.out.println("expectedLinkText = " + expectedLinkText);
        }

        // 4.Verify link hrefattribute value contains:
        //   Expected: “index.html”

        String expectedInHref = "index.html";
        String actualHref = zeroBankLink.getAttribute("href");

        System.out.println("expectedInHref = " + expectedInHref);
        System.out.println("actualHref = " + actualHref);

        if( expectedInHref.equals(actualHref)) {
            System.out.println("Verification is Passed!");
        }else {
            System.out.println("Verification is Failed!");
            System.out.println("expectedInHref = " + expectedInHref);
            System.out.println("actualHref = " + actualHref);
        }

        driver.close();

    }
}
