package com.example;


import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;

public class webSteps {

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

    @Given("^Open the chrome and launch the application$")
    public void open_the_chrome_and_launch_the_application () throws Throwable
    {
        System.setProperty("webdriver.chrome.driver", "E://Testing//chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://wb.lab.qup.vn/booking.html?fleet=ecar");
        driver.get("https://wb.beta.qup.vn/booking.html?fleet=qa");
        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("contentStep1")));
        System.out.println("This Step open the chrome.");
    }

    @Given("^Open the browser is \"(.*)\" and launch the application is \"(.*)\"$")
    public void open_the_browser_and_launch_the_application (String arg1, String arg2) throws Throwable
    {

        switch (arg1){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "E://Testing//chromedriver.exe");
                driver= new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "E://Testing//geckodriver.exe");
                driver= new FirefoxDriver();
                break;

        }
        driver.manage().window().maximize();

        switch (arg2){
            case "Local":
                driver.get("http://wb.local.qup.vn/booking.html?fleet=hoanglocal");
                break;
            case "Lab":
                driver.get("https://wb.lab.qup.vn/booking.html?fleet=ecar");
                break;
            case "Beta":
                driver.get("https://wb.beta.qup.vn/booking.html?fleet=qa");
                break;
            case "AWS":
                driver.get("https://wb.qupworld.com/booking.html?fleet=qa");
                break;
        }
        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("contentStep1")));
        System.out.println("This Step open the Browser.");
        Thread.sleep(2000);
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
        Thread.sleep(2000);
        pickupLocation.sendKeys(Keys.RETURN);


        WebElement destinationLocation = driver.findElement(By.name("destination"));
        destinationLocation.sendKeys(data.get(0).get(1));
        Thread.sleep(3000);
        destinationLocation.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        destinationLocation.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        driver.findElement(By.name("btn-book-a-ride")).click();
        System.out.println("Enter location for booking successful");
    }

    @When("^I enter Pickup as \"(.*)\" for trip$")
    public void pickUp_location(String arg1) throws InterruptedException{
        WebElement pickupLocation = driver.findElement(By.name("pickup"));
        pickupLocation.sendKeys(arg1);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pickupLocation.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
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
        Thread.sleep(2000);
        pickupLocation.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        driver.findElement(By.name("btn-book-a-ride")).click();
        System.out.println("Enter location for booking successful");
    }

    @When ("^Select Booking Type is \"(.*)\" for Trip$")
    public void select_car_type_for_trip(String arg1) throws Throwable
    {
        WebElement myDynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("CarTypes")));
        List rows = (List) driver.findElements(By.xpath("//*[@id=\"CarTypes\"]/div"));
        System.out.println("Total Car Type of Fleet is : " + rows.size());
//
//        for (int i =0;i<rows.size();i++)
//        {
////            WebElement carTypes = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]"));
////            Thread.sleep(3000);
////            String valueIneed = carTypes.getText();
////            System.out.println("All content : " + valueIneed);
//            WebElement carType = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[1]/div[1]"));
//            Thread.sleep(3000);
//            String Car = carType.getText();
//            System.out.println("Car Type is : " + Car);
//            WebElement bookNow = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[3]/a[1]/span"));
//            Thread.sleep(3000);
//            String Now = bookNow.getText();
//            System.out.println("Button is : " + Now);
//            WebElement bookLater = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[3]/a[2]/span"));
//            Thread.sleep(3000);
//            String Later = bookLater.getText();
//            System.out.println("Button is : " + Later);
//            WebElement actualETA = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[1]/span[2]/span"));
//            Thread.sleep(3000);
//            String ETA = actualETA.getText();
//            System.out.println("Estimated fare is : " + ETA);
//            WebElement distance = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[2]/span/span"));
//            Thread.sleep(3000);
//            String etaDistance = distance.getText();
//            System.out.println("Estimated Distance is : " + etaDistance);
//            WebElement time = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[" + (i+1)+ "]/div[3]/div[2]/div[3]/span/span"));
//            Thread.sleep(3000);
//            String etaTime = time.getText();
//            System.out.println("Estimated Time is : " + etaTime);
//        }
        WebElement selectBooknow = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[1]/div[3]/div[3]/a[1]/span"));
        WebElement selectBookLater = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[1]/div[3]/div[3]/a[2]/span"));
        Thread.sleep(3000);

        if (arg1.equalsIgnoreCase("Book Now")) {
            selectBooknow.click();
        }else {if (arg1.equalsIgnoreCase("Book Later")){
            selectBookLater.click();
        }else {
            System.out.println("Booking Type not found");
        }

        }
        System.out.println("This Step Select Car Type.");

    }

    @When("^Enter ride info for \"(.*)\"$")
    public void enter_ride_info_for(String arg1) throws Throwable
    {
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 2);
        date = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        String DateToStr = format.format(date);

        if (arg1.equalsIgnoreCase("Book Now")){
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
        }else {
            if (arg1.equalsIgnoreCase("Book Later")){
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
                WebElement datePicker = driver.findElement(By.name("date"));
                datePicker.sendKeys(DateToStr);
                datePicker.sendKeys(Keys.TAB);
                WebElement timePicker = driver.findElement(By.name("time"));
                timePicker.sendKeys("02:40 PM");
                timePicker.sendKeys(Keys.TAB);
                Select select = new Select (driver.findElement(By.name("meetDriver")));
                select.selectByVisibleText("Meet & Greet = no charge");
                WebElement note = driver.findElement(By.name("note"));
                note.sendKeys("Test date : " + date.toString() );
                WebElement tip = driver.findElement(By.name("tip"));
                tip.sendKeys("13");
                WebElement promoCode = driver.findElement(By.name("promoCode"));
                promoCode.sendKeys("AUTO001");
                WebElement applyPromo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[9]/div[2]/div[2]/div"));
                applyPromo.click();
                WebElement next = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[10]/a[1]/span"));
                Thread.sleep(3000);
                next.click();
            }
        }
        }

    @When("^Enter passenger info and ride info$")
    public void enter_passenger_info_and_ride_info(DataTable usercredentials) throws Throwable{
        List<List<String>> data = usercredentials.raw();

        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 2);
        date = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        String DateToStr = format.format(date);
        System.out.println(DateToStr);


        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys(data.get(1).get(0));
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys(data.get(1).get(1));
        WebElement phonePassenger = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[2]/div/input"));
        phonePassenger.sendKeys(data.get(1).get(2));
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(data.get(1).get(3));

        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("flight")));
        List rows = (List) driver.findElements(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[5]/div/div[1]/input"));

        System.out.println("Flight number is : " + rows.size());
        for (int i =0;i<rows.size();i++) {

            WebElement flight = driver.findElement(By.name("flight"));
            Thread.sleep(1000);
            flight.sendKeys("VNN-0009393");

        };

        List rowsNew = (List) driver.findElements(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[5]/div/div[1]/div[1]/input"));
        System.out.println("Flight number is (Flight #, e.g AA1097): " + rowsNew.size());
        for (int i =0;i<rowsNew.size();i++) {
            WebElement flight = driver.findElement(By.name("flight"));
            Thread.sleep(1000);
            flight.sendKeys(data.get(1).get(4));

        };

        List rowsDate = (List) driver.findElements(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[4]/div"));
        System.out.println("Date Picker is : " + rowsDate.size());
        for (int i =0;i<rowsDate.size();i++) {
            boolean datePickerDisplay=driver.findElement(By.name("date")).isDisplayed();
            System.out.println("Date Picker has display? :" + datePickerDisplay);
            if(datePickerDisplay == true) {
                WebElement datePicker = driver.findElement(By.name("date"));
                datePicker.sendKeys(DateToStr);
                datePicker.sendKeys(Keys.TAB);
                WebElement timePicker = driver.findElement(By.name("time"));
                timePicker.sendKeys("19:40 PM");
                timePicker.sendKeys(Keys.TAB);
            }

        };

        List meetDriver = (List) driver.findElements(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[6]"));
        System.out.println("Meet & Greet is : " + meetDriver.size());
        for (int i =0;i<meetDriver.size();i++) {
            boolean meetDriverDisplay=driver.findElement(By.name("meetDriver")).isDisplayed();
            System.out.println("Meet & Greet has display? :" + meetDriverDisplay);
            if(meetDriverDisplay == true){
                Select select = new Select (driver.findElement(By.name("meetDriver")));
                select.selectByValue(data.get(1).get(5));
            }
        };


        WebElement note = driver.findElement(By.name("note"));
        note.sendKeys("Test date : " + date.toString() );
        WebElement tip = driver.findElement(By.name("tip"));
        tip.sendKeys(Keys.CONTROL + "a");
        tip.sendKeys(Keys.DELETE);
        tip.sendKeys(data.get(1).get(6));
        WebElement promoCode = driver.findElement(By.name("promoCode"));
        promoCode.sendKeys(data.get(1).get(7));
        WebElement applyPromo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[9]/div[2]/div[2]/div"));
        applyPromo.click();

        WebElement next = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/div[2]/div/div[10]/a[1]/span"));
        Thread.sleep(3000);
        next.click();
        System.out.println("Enter passenger info and ride info successful");

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
    public void enter_the_list_username_and_password(DataTable usercredentials) throws Throwable
    {
        List<List<String>> data = usercredentials.raw();
        WebElement phoneNumber = driver.findElement(By.cssSelector("input.form-control:nth-child(2)"));
        phoneNumber.sendKeys(Keys.CONTROL + "a");
        phoneNumber.sendKeys(Keys.DELETE);
        phoneNumber.sendKeys(data.get(1).get(0));

        WebElement password = driver.findElement(By.cssSelector("input.form-control:nth-child(1)"));
        password.sendKeys(data.get(1).get(1));

        WebElement signIn = driver.findElement(By.cssSelector(".submitLogin"));
        signIn.click();
        System.out.println("This step verify list username and password");
    }

    @Then("^Logout page$")
    public void logout_page() throws Throwable
    {
//        driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[1]/div/ul/li[6]")).click();

        WebElement logOut = (new WebDriverWait(driver, 200))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[1]/div/ul/li[6]/span")));
        driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[1]/div/ul/li[6]/span")).click();


        WebElement myDynamicElement = (new WebDriverWait(driver, 200))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("contentStep1")));
        Thread.sleep(3000);
        System.out.println("This Step Logout button.");
    }

    @Then("^Passenger add credit card after logined$")
    public void passenger_add_credit_card(DataTable usercredentials) throws Throwable{
        List<List<String>> data = usercredentials.raw();
        WebElement paymentMethod = (new WebDriverWait(driver, 200))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[1]/div/ul/li[2]/span")));
        paymentMethod.click();

        //Select Home Fleet or Provider Fleet
        Select affiliation = new Select(driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/select[1]")));
        affiliation.selectByVisibleText(data.get(1).get(0));

//       Add Card
        driver.findElement(By.className("addCard")).click();

        WebElement cardHolder = driver.findElement(By.id("loginCardNumber"));
        cardHolder.sendKeys(data.get(1).get(1));

        WebElement cardNumber = driver.findElement(By.id("CardNumber"));
        cardNumber.sendKeys(data.get(1).get(2));

        WebElement cvv = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div/form/div[3]/div/input"));
        cvv.sendKeys(data.get(1).get(3));

        WebElement expiredDate = driver.findElement(By.name("expired"));
        expiredDate.sendKeys(data.get(1).get(4));

//      Submit add card
        driver.findElement(By.className("saveCard")).click();

        Thread.sleep(3000);
        System.out.println("This Add Credit Card.");
    }


    @Then("^Passenger remove credit card after logined$")
    public void passenger_remove_credit_card (DataTable usercredentials) throws Throwable
    {
        List<List<String>> data = usercredentials.raw();
        WebElement paymentMethod = (new WebDriverWait(driver, 200))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[1]/div/ul/li[2]/span")));
        paymentMethod.click();

        //Select Home Fleet or Provider Fleet
        Select affiliation = new Select(driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/select[1]")));
        affiliation.selectByVisibleText(data.get(1).get(0));


        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("listCard")));
        List rows = (List) driver.findElements(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div/ul/li"));
        System.out.println("Total Credit Card of User is : " + rows.size());

        for (int i =0 ; i < rows.size() ; i++ )
        {
//          Find URL Image
            WebElement imageCardType = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div/ul/li[" + (i+1)+ "]/img"));
            Thread.sleep(3000);
            String imageCardTypeSRC = imageCardType.getAttribute("src");
            System.out.println("URL Image of Credit Card is : " + imageCardTypeSRC);

            WebElement creditCard = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div/ul/li[" + (i+1)+ "]/span"));
            Thread.sleep(3000);
            String creditCardName = creditCard.getText();
            System.out.println("Credit Card Name is : " + creditCardName);

            WebElement options = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div/ul/li[" + (i+1)+ "]/div/span"));
            Thread.sleep(3000);
            options.click();
            driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div/ul/li[" + (i+1)+ "]/div/p")).click();

            WebElement confirmRemoveCard = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/span[2]"));
            Thread.sleep(3000);
            confirmRemoveCard.click();
            Thread.sleep(5000);
        }

        Thread.sleep(3000);
        System.out.println("This Remove Credit Card.");
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

        System.out.println("This Step verify ETA Fare.");

    }

    @Then("^I compare with ETA Fare, Distance, Time by Car Type$")
    public void i_compare_with_eta_fare (DataTable usercredentials) throws Throwable
    {
        List<List<String>> data = usercredentials.raw();

        WebElement carType = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[1]/div[1]/div[1]"));
        Thread.sleep(3000);
        String Car = carType.getText();
        System.out.println("Car Type is : " + Car);

        if(Car.equalsIgnoreCase(data.get(1).get(0))){
            System.out.println("Estimate fare is Passed");
        } else {
            System.out.println("Estimate fare is Failed, Expected is: " + data.get(1).get(0));
            driver.close();
        }

        WebElement actualETA = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[1]/div[3]/div[2]/div[1]/span[2]/span"));
        Thread.sleep(3000);
        String ETA = actualETA.getText();
        System.out.println("Estimated fare is : " + ETA);

        if(ETA.equalsIgnoreCase(data.get(1).get(1))){
            System.out.println("Estimate fare is Passed");
        } else {
            System.out.println("Estimate fare is Failed, Expected is: " + data.get(1).get(1));
            driver.close();
        }

        WebElement distance = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[1]/div[3]/div[2]/div[2]/span/span"));
        Thread.sleep(3000);
        String etaDistance = distance.getText();
        System.out.println("Estimated Distance is : " + etaDistance);

        if(etaDistance.equalsIgnoreCase(data.get(1).get(2))){
            System.out.println("Estimate fare is Passed");
        } else {
            System.out.println("Estimate fare is Failed, Expected is: " + data.get(1).get(2));
            driver.close();
        }

        WebElement time = driver.findElement(By.xpath("//*[@id=\"CarTypes\"]/div[1]/div[3]/div[2]/div[3]/span/span"));
        Thread.sleep(3000);
        String etaTime = time.getText();
        System.out.println("Estimated Time is : " + etaTime);

        if(etaTime.equalsIgnoreCase(data.get(1).get(3))){
            System.out.println("Estimate fare is Passed");
        } else {
            System.out.println("Estimate fare is Failed, Expected is: " + data.get(1).get(3));
            driver.close();
        }

    }

    @Then("^Booked successful$")
    public void booking_completed(DataTable usercredentials) throws Throwable
    {
        List<List<String>> data = usercredentials.raw();

        WebElement bookingSummary = driver.findElement(By.className("booking-summary"));
        Thread.sleep(1000);
        String summary = bookingSummary.getText();
        System.out.println("Booked : " + summary);
        Thread.sleep(3000);
        WebElement estimateFare = driver.findElement(By.cssSelector(".confirmEta"));
        Thread.sleep(3000);
        String valueIneed = estimateFare.getText();
        System.out.println("Estimate fare is : " + valueIneed);

        if(valueIneed.equalsIgnoreCase(data.get(1).get(0))){
            System.out.println("Estimate fare is Passed");
        } else {
            System.out.println("Estimate fare is Failed, Expected is: " + data.get(1).get(0));
            driver.close();
        }

        WebElement next = driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div[2]/div/div[1]/div[2]/a[1]/span"));
        Thread.sleep(1000);
        next.click();

    }

    @Then("^Verify status booking after request$")
    public void verify_status_booking_after_request()throws Throwable{

        WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("message-panel")));

        WebElement titleStatus = driver.findElement(By.className("title"));
        Thread.sleep(1000);
        String title = titleStatus.getText();
        System.out.println("Title status booking is : " + title);

        WebElement messageStatus = driver.findElement(By.className("message"));
        Thread.sleep(1000);
        String message = messageStatus.getText();
        System.out.println("Message of booking is : " + message);

        if(title.equalsIgnoreCase("OOPS!!!")){
            System.out.println("Create the booking is failed!!!");
            driver.close();
        };

        WebElement bookAnotherRide = driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div[2]/div/div[2]/div[2]/a[2]"));
        Thread.sleep(1000);
        bookAnotherRide.click();
        Thread.sleep(4000);

        driver.close();
    }

    @Then ("^Select \"(.*)\" tab$")
    public void select_tab (String arg) throws Throwable{

        WebElement logoImage = (new WebDriverWait(driver, 200))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[1]/img")));

        switch (arg){
            case "My Bookings":
                WebElement myBookings = (new WebDriverWait(driver, 200))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[1]/div/ul/li[1]/text()")));
                Thread.sleep(1000);
                myBookings.click();
                Thread.sleep(3000);
                break;
            case "Payment Method":
                WebElement paymentMethod = (new WebDriverWait(driver, 200))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div/div[1]/div/ul/li[2]/span")));
                Thread.sleep(1000);
                paymentMethod.click();
                Thread.sleep(3000);
                break;

        }
    }



    @Then("^Closing Web Booking$")
    public void closing_web_booking () throws Throwable {
        driver.close();
    }

    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable
    {
        driver.findElement(By.name("btnReset")).click();
        System.out.println("This Step Click reset button.");
    }
}