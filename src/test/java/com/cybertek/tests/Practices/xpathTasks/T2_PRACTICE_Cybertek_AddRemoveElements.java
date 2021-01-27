package com.cybertek.tests.Practices.xpathTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_PRACTICE_Cybertek_AddRemoveElements {

    public static void main(String[] args) throws InterruptedException {
        //TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        //3. Click to button
        // tagName[.='text']
        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));

        Thread.sleep(1000);

        addElementButton.click();
        //4. Verify "Delete" button is displayed after clicking
        WebElement deleteElementButton = driver.findElement(By.xpath("//button[.='Delete']"));

        if (deleteElementButton.isDisplayed()) {
            System.out.println("Delete button is displayed. Verification passed!");
        } else {
            System.out.println("Delete button is NOT displayed. Verification failed!");
        }

        //5. Click "Delete" to button.
        //deleteElementButton.click();

        // 6. Verify button is NOT displayed after clicking.
        Thread.sleep(1000);
        try {
            deleteElementButton.click();
            if (!deleteElementButton.isDisplayed()) {
                System.out.println("Delete button is NOT displayed after clicking. Verification passed!");
            } else {
                System.out.println("Delete button is displayed after clicking. Verification failed!");
            }
        } catch (StaleElementReferenceException exception) {
            System.out.println("StaleElementException has been thrown.");

            System.out.println("It means element has been completely deleted from the HTML.");

            System.out.println("Delete button is not displayed. Verification PASSED!");
        }


    }
}
