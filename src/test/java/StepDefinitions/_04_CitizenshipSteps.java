package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    LeftNav ln=new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenship");
    }

    @When("User a Citizenship name as {string} short name as {string}")
    public void userACitizenshipNameAsShortNameAs(String nameCitizenship, String shortNameCitizenship) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", nameCitizenship );
        dc.findAndSend("shortNameInput", shortNameCitizenship);
        dc.findAndClick("saveButton");
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.findAndContainsText("failMessage", "already exists");
    }

    @And("Click on close button")
    public void clickOnCloseButton() {
        dc.findAndClick("closeButton");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String searchStr) {
            dc.SearchAndDelete("searchInput", searchStr);
    }


}
