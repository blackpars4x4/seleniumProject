package com.cybertek.tests.Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_LoginVerification {
    public static void main(String[] args) throws InterruptedException {
        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        //We are going to have locate some web elements to be able to send data to them
        //3. Enter incorrect username:
        driver.findElement(By.id("email")).sendKeys("anything@gmail.com");
        //4. Enter incorrect password:
        driver.findElement(By.id("pass")).sendKeys("password" + Keys.ENTER);
        //5. Verify title change to:
        //Expected: Log into Facebook | Facebook
        String expectedTitle = "Log into Facebook | Facebook";
        Thread.sleep(20000);
        String actualTitle = driver.getTitle();

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verification Pass!");
            System.out.println("Title verification Pass!");
        }else {
            System.out.println("Title verification failed!");
        }

    }
}
