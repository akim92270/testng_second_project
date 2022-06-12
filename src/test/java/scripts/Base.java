package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import page.UnitedAirlineFlightPage;
import page.UnitedAirlineHomePage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait wait;
    Wait fluentWait;
    SoftAssert softAssert;
    UnitedAirlineHomePage unitedAirlineHomePage;
    UnitedAirlineFlightPage unitedAirlineFlightPage;
    Actions actions;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,15);
        Wait fluentWait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        unitedAirlineHomePage = new UnitedAirlineHomePage(driver);
        unitedAirlineFlightPage = new UnitedAirlineFlightPage(driver);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}