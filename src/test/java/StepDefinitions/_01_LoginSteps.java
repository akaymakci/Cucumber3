package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class _01_LoginSteps {
    DialogContent dc = new DialogContent();
    @Given("Navigate to basqar")
    public void navigateToBasqar() {
        GWD.getDriver().get("https://test.mersys.io/");
        GWD.getDriver().manage().window().maximize();

    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
//
//        GWD.wait.until(ExpectedConditions.visibilityOf(dc.userName));
//        dc.userName.sendKeys("turkeyts");
//        dc.passWord.sendKeys("TechnoStudy123");
//        dc.loginButton.click();
        dc.findAndSend("userName","turkeyts");
        dc.findAndSend("passWord","TechnoStudy123");
//        dc.clickFunction(dc.loginButton);
//        dc.loginButton.click();
        dc.findAndClick("loginButton");
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
//        GWD.wait.until(ExpectedConditions.elementToBeClickable(dc.dashBoard));
//        dc.waitUntilVisible(dc.dashBoard);
//        Assert.assertTrue(dc.dashBoard.getText().contains("Dashboard"));
        dc.findAndContainsText("dashBoard", "Dashboard");
    }


}
