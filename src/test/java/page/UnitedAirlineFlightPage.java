package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitedAirlineFlightPage {

    public UnitedAirlineFlightPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[class='app-components-Shopping-TripInfo-styles__tripOriginDestinationHeader--RcPyp'] span")
    public WebElement verify;
}
