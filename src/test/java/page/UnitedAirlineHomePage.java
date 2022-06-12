package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedAirlineHomePage {
    public UnitedAirlineHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[id^='headerNav']")
    public List<WebElement> mainMenu;

    @FindBy(css = ".app-components-BookTravel-bookTravel__travelNav--3RNBj li")
    public List<WebElement> bookTravelMenu;

    @FindBy(id = "oneway")
    public WebElement oneWayButton;

    @FindBy(css = "label[for='roundtrip']")
    public WebElement roundTripLabel;

    @FindBy(id = "roundtrip")
    public WebElement roundTripInput;

    @FindBy(css = "input[name='AwardTravel']")
    public WebElement bookWithMilesInputBox;

    @FindBy(css = "label[for='award']>span")
    public WebElement bookWithMilesCheckBox;

    @FindBy(css = "input[id='flexibleDates']")
    public WebElement flexibleDateInputBox;

    @FindBy(css = "label[id='flexDatesLabel']>span")
    public WebElement flexibleDatesCheckBox;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(css = "input[id='DepartDate']")
    public WebElement dayInputBox;

    @FindBy(css = "div[id='passengerSelector']>button")
    public WebElement travelerSelector;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement plusButton;

    @FindBy(css = "li[id='cabinType_item-2']")
    public WebElement businessFlight;

    @FindBy(css = "button[class*='app-components-ListBox-ListBox']")
    public WebElement cabinTypeDropdownMenu;

    @FindBy(css = "button[type='submit']")
    public WebElement findFlightsButton;

}
