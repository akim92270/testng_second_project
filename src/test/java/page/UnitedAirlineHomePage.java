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

    @FindBy(id = "roundtrip")
    public WebElement roundTripButton;

    @FindBy(css = ".app-components-BookFlightForm-bookFlightForm__radioContainer--3WXQM label")
    public List<WebElement> roundTripOneWayRadioButton;

    @FindBy(css = "label[for='award']")
    public WebElement bookWithMilesInputBox;

    @FindBy(css = "label[for='award']>span")
    public WebElement bookWithMilesCheckBox;

    @FindBy(css = "input[id='flexibleDates']")
    public WebElement flexibleDateInputBox;

    @FindBy(css = "label[id='flexDatesLabel']>span")
    public WebElement flexibleDatesCheckBox;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(css = "li[id='autocomplete-item-0']>button")
    public WebElement fromConfirmation;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(css = "li[id='autocomplete-item-1']>button")
    public WebElement toConfirmation;

    @FindBy(css = "button[id='flexMonth']")
    public WebElement monthInputBox;

    @FindBy(id = "button[id='flexDay']")
    public WebElement dayInputBox;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement travelerSelector;  //input[value='2'] get attribute?

    @FindBy(css = "ul[aria-activedescendant='cabinType_item-3']>li")
    public List<WebElement> cabinDropdown;

    @FindBy(css = "button[type='submit']")
    public List<WebElement> findFlightsButton;
}
