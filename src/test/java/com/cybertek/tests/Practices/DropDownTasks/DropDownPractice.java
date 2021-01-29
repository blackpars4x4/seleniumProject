package com.cybertek.tests.Practices.DropDownTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {

    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        //selectByTextTest();
        //selectByValueTest();
        //selectByIndex();
        //multipleSelectDropDownTest();
        nonSelectedDropdown();

    }

    public static void setup() throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    public static void selectByTextTest() throws Exception {
        setup();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        driver.close();
    }

    public static void selectByValueTest() throws Exception {
        setup();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("DC");
        Thread.sleep(2000);

        String expected = "District of Columbia";
        String actual = select.getFirstSelectedOption().getText();

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        driver.close();
    }
    public static void selectByIndex() throws Exception {
        setup();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByIndex(1);

        Thread.sleep(2000);

        String expected = "Alabama";
        String actual = select.getFirstSelectedOption().getText();

        String expectedValue = "AL";
        String actualValue = select.getFirstSelectedOption().getAttribute("value");

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);

        System.out.println("expectedValue = " + expectedValue);
        System.out.println("actualValue = " + actualValue);

        driver.close();
    }
    public static void multipleSelectDropDownTest() throws Exception {
        setup();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.name("Languages")));

        List<WebElement>options = select.getOptions();

        for(WebElement option : options){
            Thread.sleep(1000);
            select.selectByVisibleText(option.getText());
        }
        Thread.sleep(1000);
        List<WebElement>selectedOptions = select.getAllSelectedOptions();

        for(WebElement option : selectedOptions){
            Thread.sleep(1000);
            System.out.println(option.getText());
        }

        Thread.sleep(3000);
        select.deselectAll();
        Thread.sleep(1000);

        driver.close();
    }

    public static void nonSelectedDropdown() throws Exception {
        setup();
        WebElement dropDown = driver.findElement(By.id("dropdownMenuLink"));
        WebElement option = driver.findElement(By.xpath("//a[text()='Amazon']"));

        dropDown.click();
        Thread.sleep(1000);
        option.click();

        driver.close();

    }






}
