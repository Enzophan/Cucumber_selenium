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

public class webExampleSteps {

    WebDriver driver;

    @Given("^Open the Firefox and launch the application$")
    public void open_the_Firefox_and_launch_the_application() throws Throwable
    {
        System.setProperty("webdriver.gecko.driver", "E://Testing//geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://wb.lab.qup.vn/booking.html?fleet=ecar");
        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("contentStep1")));
        System.out.println("This Step open the firefox.");
    }

    @Given("^Book Reservation$")
    public void waiting_for_loading_successful() throws  Throwable
    {
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("^Enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable
    {
        driver.findElement(By.className("btLogin")).click();
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

    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable
    {
        driver.findElement(By.name("btnReset")).click();
        System.out.println("This Step Click reset button.");
    }
}