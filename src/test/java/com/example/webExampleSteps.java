package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class webExampleSteps {

    WebDriver driver;

    @Given("^Open the Firefox and launch the application$")
    public void open_the_Firefox_and_launch_the_application() throws Throwable
    {
        System.setProperty("webdriver.gecko.driver", "E://Testing//geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
//        driver.get("https://wb.lab.qup.vn/booking.html?fleet=ecar");
        driver.get("https://wb.beta.qup.vn/booking.html?fleet=qa");
        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("contentStep1")));
        System.out.println("This Step open the firefox.");
    }

    @Given("^Login Web Booking page$")
    public void login_web_booking() throws Throwable
    {
        driver.findElement(By.className("btLogin")).click();
        System.out.println("Accept to Login page.");
    }

    @When("^Enter Location to Booking one trip$")
    public void waiting_for_loading_successful() throws  Throwable
    {
        //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement pickupLocation = driver.findElement(By.name("pickup"));
        pickupLocation.sendKeys("San Bay Quoc Te Da Nang");
        Thread.sleep(3000);
        pickupLocation.sendKeys(Keys.ARROW_DOWN);
        pickupLocation.sendKeys(Keys.RETURN);


        WebElement destinationLocation = driver.findElement(By.name("destination"));
        destinationLocation.sendKeys("Hoi An");
        Thread.sleep(3000);
        destinationLocation.sendKeys(Keys.ARROW_DOWN);
        destinationLocation.sendKeys(Keys.RETURN);

        Thread.sleep(3000);
        driver.findElement(By.name("btn-book-a-ride")).click();
        System.out.println("Enter location for booking successful");
    }

    @When ("^Select Car Type for Trip$")
    public void select_car_type_for_trip() throws Throwable
    {
        System.out.println("This Step Select Car Type.");

    }

    @When("^Enter the Username and Password on Web Booking$")
    public void enter_the_Username_and_Password() throws Throwable
    {
//        driver.findElement(By.className("btLogin")).click();
        WebElement phoneNumber = driver.findElement(By.cssSelector("input.form-control:nth-child(2)"));
        phoneNumber.sendKeys(Keys.CONTROL + "a");
        phoneNumber.sendKeys(Keys.DELETE);
        phoneNumber.sendKeys("+84901223344");

        WebElement password = driver.findElement(By.cssSelector("input.form-control:nth-child(1)"));
        password.sendKeys("demo@12345");

        WebElement signIn = driver.findElement(By.cssSelector(".submitLogin"));
        signIn.click();

//        driver.findElement(By.name("uid")).sendKeys("username12");
//        driver.findElement(By.name("password")).sendKeys("password12");
        System.out.println("This Step enter User and Password.");
    }

    @When("^Enter the list username and password$")
    public void enter_the_list_username_and_password() throws Throwable
    {
        System.out.println("This step verify list username and password");
    }

    @Then("^Logout page$")
    public void logout_page() throws Throwable
    {
        driver.findElement(By.cssSelector(".glyphicon-log-out")).click();
        System.out.println("This Step Logout button.");
    }

    @Then("^Booked successful$")
    public void select_car_type_and_type_to_booking() throws Throwable
    {
        System.out.println("Booked.");
        Thread.sleep(3000);
        driver.quit();
    }

    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable
    {
        driver.findElement(By.name("btnReset")).click();
        System.out.println("This Step Click reset button.");
    }
}