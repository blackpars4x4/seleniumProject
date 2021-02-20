package com.cybertek.tests.day6_drowndown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrder_Practices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() throws InterruptedException {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to website:
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //maximaze the windows
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebOrderUtils.loginToSmartBear(driver);
    }



    @Test
    public void test1_link_verification() {
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

       /* //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUsername.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test");
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();*/


        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of all links on landing page: " + allLinks.size());

        //7. Print out each link text on this page
        for (WebElement each : allLinks) {
            System.out.println("each Link: " + each.getText());
        }


    }


    @Test
    public void test2_order_placing() throws InterruptedException {
        //TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button

        WebElement orderLink = driver.findElement(By.xpath("//body//a[@href='Process.aspx']"));

        //6. Click on Order
        orderLink.click();
        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));

        Thread.sleep(1000);
        productDropdown.selectByValue("FamilyAlbum");

        WebElement inputQuantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));

        Thread.sleep(1000);
        inputQuantity.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        inputQuantity.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        Faker faker = new Faker();
        //• Generate: name, street, city, state, zip code
        String name = faker.name().fullName();
        WebElement inputName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        inputName.sendKeys(name);

        String street = faker.address().streetAddress();
        WebElement inputStreet = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        inputStreet.sendKeys(street);

        String city = faker.address().cityName();
        WebElement inputCity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        inputCity.sendKeys(city);

        String state = faker.address().state();
        WebElement inputState = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        inputState.sendKeys(state);

        String zipCode = faker.address().zipCode().replaceAll("-", "");
        WebElement inputZipcode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        inputZipcode.sendKeys(zipCode);

        //10. Click on “visa” radio button
        WebElement visaRadioButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaRadioButton.click();

        //11. Generate card number using JavaFaker
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-", ""));

        Thread.sleep(2000);
        WebElement expDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expDate.sendKeys("01/25");

        //12. Click on “Process”
        WebElement processLink = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processLink.click();


        //13. Verify success message “New order has been successfully added.”
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        String expected = "New order has been successfully added.";
        //Assert.assertEquals(successMessage, expected);
        //or
        Assert.assertTrue(successMessage.isDisplayed(), "Success Message is not displayed");

    }

    @AfterClass
    public void tearDownMethod() throws InterruptedException {

        //additional 5 seconds before closing the browser
        Thread.sleep(5000);

        driver.close();

    }
}
