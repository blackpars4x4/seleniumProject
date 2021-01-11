package com.cybertek.tests.Practices.xpathTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P2_Xpath_Practice1 {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2. Go to http://practice.cybertekschool.com/add_remove_elements/
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        // 3. Click to “Add Element” button
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        Thread.sleep(1000);

        addElement.click();

        // 4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        if (deleteButton.isDisplayed()) {
            System.out.println("Verified - PASSED!");
        } else {
            System.out.println("Not Verified = FAILED!");
        }
        // 5. Click to “Delete” button.
        //deleteButton.click(); // instead of this line try catch block will be better to verify the any exception

        // 6. Verify “Delete” button is NOT displayed after clicking.

        try {
            deleteButton.click();
            if (!deleteButton.isDisplayed()) {
                System.out.println("Delete button is NOT displayedafter clicking. PASS!");
            } else {
                System.out.println("Delete button is displayed after clicking. FAILED!");
            }
        } catch (StaleElementReferenceException exception) {
            System.out.println("StaleElementException has been thrown.");
            System.out.println("It means element has been completely deleted from the HTML.");
            System.out.println("Delete button is not displayed. Verification PASSED!");
        }
    }


}
