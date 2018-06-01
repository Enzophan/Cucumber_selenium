package com.example;


import cucumber.api.DataTable;
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
import org.openqa.selenium.support.ui.Select;


import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;

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

    @When("^I enter Pickup and Destination$")
    public void i_enter_pickup_and_destination(DataTable usercredentials) throws  Throwable
    {
        //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<List<String>> data = usercredentials.raw();

        WebElement pickupLocation = driver.findElement(By.name("pickup"));
        pickupLocation.sendKeys(data.get(0).get(0));
        Thread.sleep(3000);
        pickupLocation.sendKeys(Keys.ARROW_DOWN);
        pickupLocation.sendKeys(Keys.RETURN);


        WebElement destinationLocation = driver.findElement(By.name("destination"));
        destinationLocation.sendKeys(data.get(0).get(1));
        Thread.sleep(3000);
        destinationLocation.sendKeys(Keys.ARROW_DOWN);
        destinationLocation.sendKeys(Keys.RETURN);

        Thread.sleep(3000);
        driver.findElement(By.name("btn-book-a-ride")).click();
        System.out.println("Enter location for booking successful");
    }

    @When("^I enter Pickup as \"(.*)\" for trip$")
    public void pickUp_location(String arg1) {
        WebElement pickupLocation = driver.findElement(By.name("pickup"));
        pickupLocation.sendKeys(arg1);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pickupLocation.sendKeys(Keys.ARROW_DOWN);
        pickupLocation.sendKeys(Keys.RETURN);
    }

    @When("^I enter Destinaton as \"(.*)\" for trip$")
    public void destinaton_location(String arg1) throws InterruptedException {
        WebElement pickupLocation = driver.findElement(By.name("destination"));
        pickupLocation.sendKeys(arg1);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pickupLocation.sendKeys(Keys.ARROW_DOWN);
        pickupLocation.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        driver.findElement(By.name("btn-book-a-ride")).click();
        System.out.println("Enter location for booking successful");
    }

    @When ("^Select Booking Type is \"(.*)\" for Trip$")
    public void select_car_type_for_trip(String arg1) throws Throwable
    {
        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("CarTypes")));
        List rows = (List) driver.findElements(By.xpath("//*[@id=\"CarTypes\"]/div"));
        System.out.println("Total Car Type of Fleet is : " + rows.size());

        for (int i =0;i<rows.size();i++)
        {
//            WebElement carTypes = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]"));
//            Thread.sleep(3000);
//            String valueIneed = carTypes.getText();
//            System.out.println("All content : " + valueIneed);
            WebElement carType = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[1]/div[1]"));
            Thread.sleep(3000);
            String Car = carType.getText();
            System.out.println("Car Type is : " + Car);
            WebElement bookNow = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[3]/a[1]/span"));
            Thread.sleep(3000);
            String Now = bookNow.getText();
            System.out.println("Button is : " + Now);
            WebElement bookLater = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[3]/a[2]/span"));
            Thread.sleep(3000);
            String Later = bookLater.getText();
            System.out.println("Button is : " + Later);
            WebElement actualETA = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[1]/span[2]/span"));
            Thread.sleep(3000);
            String ETA = actualETA.getText();
            System.out.println("Estimated fare is : " + ETA);
            WebElement distance = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[2]/span/span"));
            Thread.sleep(3000);
            String etaDistance = distance.getText();
            System.out.println("Estimated Distance is : " + etaDistance);
            WebElement time = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[3]/span/span"));
            Thread.sleep(3000);
            String etaTime = time.getText();
            System.out.println("Estimated Time is : " + etaTime);
        }
        WebElement selectBooknow = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[1]/div[3]/div[3]/a[1]/span"));
        WebElement selectBookLater = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[1]/div[3]/div[3]/a[2]/span"));
        Thread.sleep(3000);

        if (arg1.equalsIgnoreCase("Book Now")) {
            selectBooknow.click();
        }else {
            selectBookLater.click();
        }


        System.out.println("This Step Select Car Type.");

    }

    @When("^Enter passenger info$")
    public void enter_passenger_info() throws Throwable
    {
        Date date = new Date();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Auto Test");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Web Booking");
        WebElement phonePassenger = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[2]/div/input"));
        phonePassenger.sendKeys("+84901223344");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("qa.qupworld@gmail.com");
        WebElement flight = driver.findElement(By.name("flight"));
        flight.sendKeys("VNN-0009393");
        Select select = new Select (driver.findElement(By.name("meetDriver")));
        select.selectByVisibleText("Meet & Greet = no charge");
        WebElement note = driver.findElement(By.name("note"));
        note.sendKeys("Test date : " + date.toString() );
        WebElement tip = driver.findElement(By.name("tip"));
        tip.sendKeys("13");
        WebElement promoCode = driver.findElement(By.name("promoCode"));
        promoCode.sendKeys("AUTO001");
        WebElement next = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[10]/a[1]/span"));
        Thread.sleep(3000);
        next.click();

    }

    @When("^Enter payment info$")
    public void enter_payment_info() throws Throwable
    {
        WebElement cardHolder = driver.findElement(By.name("cardHolder"));
        cardHolder.sendKeys("Auto Test");
        WebElement cardNumber = driver.findElement(By.name("cardNumber"));
        cardNumber.sendKeys("4111111111111111");
        WebElement expired = driver.findElement(By.name("expired"));
        expired.sendKeys("12/19");
        WebElement cvv = driver.findElement(By.name("cvv"));
        cvv.sendKeys("123");
        WebElement next = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div[2]/div[2]/div/div[9]/a[1]/span"));
        Thread.sleep(3000);
        next.click();

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

    @Then("^Verify ETA Fare and ETA Distance and ETA Time by Car Type valid on the page$")
    public void verify_eta_fare_by_car_type() throws Throwable
    {

        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("CarTypes")));
        List rows = (List) driver.findElements(By.xpath("//*[@id=\"CarTypes\"]/div"));
        System.out.println("Total Car Type of Fleet is : " + rows.size());

        for (int i =0;i<rows.size();i++)
        {
            WebElement carType = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[1]/div[1]"));
            Thread.sleep(3000);
            String Car = carType.getText();
            System.out.println("Car Type is : " + Car);

            WebElement actualETA = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[1]/span[2]/span"));
            Thread.sleep(3000);
            String ETA = actualETA.getText();
            System.out.println("Estimated fare is : " + ETA);
            WebElement distance = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[2]/span/span"));
            Thread.sleep(3000);
            String etaDistance = distance.getText();
            System.out.println("Estimated Distance is : " + etaDistance);
            WebElement time = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[3]/span/span"));
            Thread.sleep(3000);
            String etaTime = time.getText();
            System.out.println("Estimated Time is : " + etaTime);
        }
//
//        if (valueIneed.equals(arg2))
//            System.out.println("Passed");
//        else
//            System.out.println("Failed");

        System.out.println("This Step verify ETA Fare.");

        driver.close();
    }

    @Then("^Booked successful$")
    public void booking_completed() throws Throwable
    {
        WebElement bookingSummary = driver.findElement(By.className("booking-summary"));
        Thread.sleep(1000);
        String summary = bookingSummary.getText();
        WebElement next = driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div[2]/div/div[1]/div[2]/a[1]/span"));
        Thread.sleep(1000);
        next.click();
        System.out.println("Booked : " + summary);
        Thread.sleep(3000);
        driver.close();
    }

    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable
    {
        driver.findElement(By.name("btnReset")).click();
        System.out.println("This Step Click reset button.");
    }
}