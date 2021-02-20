package com.cybertek.tests.Practices.DropDownTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownTask1_2_3_4_5 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void tc1_simpleDropDown() {
        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        //3. Verify “Simple dropdown” default selected value is correct
        Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));


        String expected = "Please select an option";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected, "Default selected option is not as expected.");
        //Expected: “Please select an option”
        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
        String expectedState = "Select a State";
        String actualState = selectState.getFirstSelectedOption().getText();
        Assert.assertEquals(actualState, expectedState, "Default selected option is not as expected.");

    }

    @Test
    public void tc2_stateDropDown() throws InterruptedException {
        //TC #2: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        Thread.sleep(2000);
        select.selectByVisibleText("Illinois");
        select.selectByValue("IL");

        //4. Select Virginia
        Thread.sleep(2000);
        select.selectByVisibleText("Virginia");
        select.selectByValue("VA");
        //5. Select California
        Thread.sleep(2000);
        select.selectByVisibleText("California");
        select.selectByValue("CA");
        //6. Verify final selected option is California.
        Thread.sleep(2000);
        String expected = "California";
        String actual = select.getFirstSelectedOption().getText();


        Assert.assertEquals(actual, expected, "Final selected option is not as expected.");
        //Use all Select options. (visible text, value, index)
    }

    @Test
    public void tc3_selectDate() throws InterruptedException {
        //TC #3: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //3. Select “December 1st, 1921” and verify it is selected.
        //Select year using : visible text
        Thread.sleep(1000);
        try {
            selectYear.selectByVisibleText("1923");
        } catch (NoSuchElementException e) {
            System.out.println("No selected year element found in the Dropdown Menu");// for if the input is 1921 or less
        }
        //Select month using : value attribute
        Thread.sleep(1000);
        selectMonth.selectByValue("11");
        //Select day using : index number
        Thread.sleep(1000);
        selectDay.selectByIndex(0);

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";


        //getting our actual values from browser
        String actualYear = selectYear.getFirstSelectedOption().getText();
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String actualDay = selectDay.getFirstSelectedOption().getText();

        //creating assertions to compare actual vs expected values

        //AssertTrue expects one argument that is supposed to be returning boolean value
        Assert.assertEquals(expectedYear, actualYear, "ActualYear is not equal to ExpectedYear!!!");

        Assert.assertEquals(expectedMonth, actualMonth);

        Assert.assertEquals(actualDay, expectedDay);

    }

    @Test
    public void tc4_multipleSelect() throws InterruptedException {
        //TC #4: Selecting value from multiple select dropdown
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        Select multipleDropDown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));


        List<WebElement> options = multipleDropDown.getOptions();

        //3. Select all the options from multiple select dropdown.

        for (WebElement option : options) {
            Thread.sleep(500);
            option.click();
            System.out.println("Each Languages: " + option.getText());
            Assert.assertTrue(option.isSelected(), "The option " + option.getText() + " is not selected!");
        }


        //4. Print out all selected values.
        multipleDropDown.deselectAll();
        //5. Deselect all values.
        for (WebElement option : options) {
            Thread.sleep(500);
            Assert.assertFalse(option.isSelected(), "One or more options are still selected");
        }
    }

    @Test
    public void tc5_nonSelectedDropDown() throws InterruptedException {
        //TC #5: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        WebElement websiteDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        //3. Click to non-select dropdown
        Thread.sleep(500);
        websiteDropdown.click();
        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        Thread.sleep(500);
        facebookLink.click();
        //5. Verify title is “Facebook - Log In or Sign Up”
        String expected = "Facebook - Log In or Sign Up";
        String actual = driver.getTitle();


    }


    @AfterClass
    public void tearDownMethod() throws InterruptedException {

        //additional 5 seconds before closing the browser
        Thread.sleep(5000);

        driver.close();

    }
}
