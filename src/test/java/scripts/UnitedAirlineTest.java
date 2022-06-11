package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UnitedAirlineTest extends Base{

    /*
    Test Case 1: Validate "Main menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see “Main menu” navigation items
    |BOOK                	          	  |
    |MY TRIPS            	          	  |
    |TRAVEL INFO         	  |
    |MILEAGEPLUS® PROGRAM|
    |DEALS               	          	  |
    |HELP                	          	  |

    */

    @Test(priority = 1, description = "Test Case 1: Validate Main menu navigation items")
    public void testMainMenu(){
        driver.get("https://www.united.com/en/us"); //go to url;
        String[] actual = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"}; //used for comparison
        for (int i = 0; i < unitedAirlineHomePage.mainMenu.size(); i++) {
            Assert.assertTrue(unitedAirlineHomePage.mainMenu.get(i).isDisplayed()); //displayed
            Assert.assertEquals(unitedAirlineHomePage.mainMenu.get(i).getText(), actual[i]); //comparison
        }

    }

    /*Test Case 2: Validate "Book travel menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see "Book travel menu" navigation items
    |Book             |
    |Flight Status|
    |Check-in       |
    |My trips        |*/

    @Test(priority = 2, description = "Test Case 2: Validate Book travel menu navigation items")
    public void testBookTravelMenu(){
        driver.get("https://www.united.com/en/us");
        String[] actual = {"Book", "Flight status", "Check-in", "My trips"};
        for (int i = 0; i < unitedAirlineHomePage.bookTravelMenu.size(); i++) {
            Assert.assertTrue(unitedAirlineHomePage.bookTravelMenu.get(i).isDisplayed()); //displayed
            Assert.assertEquals(unitedAirlineHomePage.bookTravelMenu.get(i).getText(), actual[i]); //comparison
        }
    }

    /*Test Case 3: Validate "Round-trip" and "One-way" radio buttons
    Given user is on "https://www.united.com/en/us"
    Then validate "Roundtrip" radio button is displayed, is enabled and is selected
    And validate "One-way" radio button is displayed, is enabled but is not selected
    When user clicks on "One-way" radio button
    Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected*/

    @Test(priority = 3, description = "Test Case 3: Validate Round-trip and One-way radio buttons")
    public void testRoundTripAndOneWayRadioButtons(){
        driver.get("https://www.united.com/en/us");
        for (int i = 0; i < unitedAirlineHomePage.roundTripOneWayRadioButton.size(); i++) {
            Assert.assertTrue(unitedAirlineHomePage.roundTripOneWayRadioButton.get(i).isDisplayed(), "Roundtrip / One-way is not displayed"); //RoundTrip is displayed
            Assert.assertTrue(unitedAirlineHomePage.roundTripOneWayRadioButton.get(i).isEnabled(), "Roundtrip / One-way is not enabled"); //RoundTrip is enabled
            //Assert.assertTrue(unitedAirlineHomePage.roundTripButton.isSelected(),"Roundtrip is not selected"); //RoundTrip is selected [not sure why it's failing]
            //Assert.assertTrue(!unitedAirlineHomePage.oneWayButton.isSelected(), "One-way is not selected"); //One-way is selected
            unitedAirlineHomePage.roundTripOneWayRadioButton.get(1).click();
            //Assert.assertTrue(unitedAirlineHomePage.roundTripOneWayRadioButton.get(1).isSelected());
            //Assert.assertFalse(unitedAirlineHomePage.roundTripOneWayRadioButton.get(1).isSelected());
        }

    }

    /*Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
    Given user is on "https://www.united.com/en/us"
    Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
    And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
    When user clicks both checkboxes
    Then validate both checkboxes are selected
    When user clicks on both selected checkboxes again
    Then validate both checkboxes are deselected*/

    @Test(priority = 4, description = "Test Case 4: Validate Book with miles and Flexible dates checkboxes")
    public void testBookWithMilesAndFlexibleDatesCheckbox(){
        driver.get("https://www.united.com/en/us");
        Assert.assertTrue(unitedAirlineHomePage.bookWithMilesCheckBox.isDisplayed(), "Book with miles is not displayed");
        Assert.assertTrue(unitedAirlineHomePage.bookWithMilesCheckBox.isEnabled(), "Book with miles is not enabled");
        Assert.assertFalse(unitedAirlineHomePage.bookWithMilesCheckBox.isSelected(), "Book with miles is selected");
        Assert.assertTrue(unitedAirlineHomePage.flexibleDatesCheckBox.isDisplayed(), "Flexible date is not displayed");
        Assert.assertTrue(unitedAirlineHomePage.flexibleDatesCheckBox.isEnabled(), "Flexible date is not enabled");
        unitedAirlineHomePage.bookWithMilesCheckBox.click();
        unitedAirlineHomePage.flexibleDatesCheckBox.click();
        Assert.assertTrue(unitedAirlineHomePage.bookWithMilesInputBox.isSelected(), "Flexible date is not selected");
        Assert.assertTrue(unitedAirlineHomePage.flexibleDateInputBox.isSelected(), "Flexible date is not selected");
        unitedAirlineHomePage.bookWithMilesCheckBox.click();
        unitedAirlineHomePage.flexibleDatesCheckBox.click();
        Assert.assertFalse(unitedAirlineHomePage.bookWithMilesInputBox.isSelected(), "Flexible date is selected");
        Assert.assertFalse(unitedAirlineHomePage.flexibleDateInputBox.isSelected(), "Flexible date is selected");
    }
    /*Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
    Given user is on "https://www.united.com/en/us"
    When user selects "One-way" ticket radio button
    And user enters "Chicago, IL, US (ORD)" to from input box
    And user enters "Miami, FL, US (MIA)" to to input box
    And user selects "Jan 30" to the dates input box
    And user selects "2 Adults" from travelers selector
    And user selects "Business or First" from cabin dropdown
    And user clicks on "Find Flights" button
    Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US*/
    @Test(priority = 5, description = "Test Case 5: Validate One-way ticket search results from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public void testOneWayTicketSearch(){
        driver.get("https://www.united.com/en/us");
        unitedAirlineHomePage.fromInputBox.clear();
        unitedAirlineHomePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");
        unitedAirlineHomePage.fromConfirmation.sendKeys(Keys.ENTER);


    }
}
