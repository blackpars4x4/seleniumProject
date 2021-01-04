package com.cybertek.tests.Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F1_Facebook_Tasks_1_2 {

    public static void main(String[] args) {

        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        //3. Verify title:
        //Expected: “Facebook -Log In or Sign Up”

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        if ( actualTitle.equals(expectedTitle)){
            System.out.println("Facebook title verification passed!");

        }else {
            System.out.println("Facebook title verification failed!");
        }


    }

}
/*
TC #1: Facebook title verification
1.Open Chrome browser
2.Go to https://www.facebook.com
3.Verify title:
Expected: “Facebook -Log In or Sign Up”

TC #2: Facebook incorrect login title verification
1.Open Chrome browser
2.Go to https://www.facebook.com
3.Enter incorrect username
4.Enter incorrect password
5.Verify title changed to:
Expected: “Log into Facebook | Facebook”


•Create new class for each task.
•There are some tips in the 2nd page for whoever needs it.
•Please try to solve yourself first before moving to the tips.
 */