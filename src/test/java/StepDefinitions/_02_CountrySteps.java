package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static Utilities.GWD.threadBrowserName;

public class _02_CountrySteps {
    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    String randomGenName= RandomStringUtils.randomAlphabetic(8);
    String randomGenCode= RandomStringUtils.randomNumeric(4);
    public static ArrayList<String> setRandomGenName = new ArrayList<>();
    public static Map<String, String> m=new HashMap<>();

    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("leftNavBar");
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("countries");
    }

    @When("Create a country")
    public void createACountry() {
//        String randomGenName= RandomStringUtils.randomAlphabetic(8);
//        String randomGenCode= RandomStringUtils.randomNumeric(4);
        //dc.findAndClick("addButton");
        dc.findAndSend("nameInput",randomGenName);
        dc.findAndSend("codeInput",randomGenCode);
        dc.findAndClick("saveButton");

    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        //ln.findAndClick("leftNavBar");
//        String randomGenName= RandomStringUtils.randomAlphabetic(8);
//        String setRandomGenName = randomGenName;
//        String randomGenCode= RandomStringUtils.randomNumeric(4);
        dc.findAndClick("addButton");
        //dc.findAndSend("nameInput", name);
        dc.findAndSend("nameInput", randomGenName);
        //dc.findAndSend("codeInput", code);
        dc.findAndSend("codeInput", randomGenCode);
        dc.findAndClick("saveButton");
        setRandomGenName.add(randomGenName);
        System.out.println("create Step "+setRandomGenName);
        String brwsrName = threadBrowserName.get();
        m.put(brwsrName,randomGenName);
//        System.out.println(m.keySet() + " : " + m.values());
    }
    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage", "success");
    }

    @When("User delete item from Dialog name as {string}")
    public void userDeleteItemFromDialogNameAs(String searchStr) {
//        System.out.println("delete Step "+setRandomGenName);
        String browserName = threadBrowserName.get();
        dc.SearchAndDelete("searchInput", m.get(browserName));
//        System.out.println(m.get(browserName));
    }
}
