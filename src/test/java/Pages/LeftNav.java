package Pages;

import Utilities.GWD;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class LeftNav extends Parent{
    public LeftNav() {PageFactory.initElements(GWD.getDriver(),this);}

    @FindBy(xpath = "(//*[contains(text(),'Setup')])[1]")
    private WebElement setupOne;
    @FindBy(xpath = "(//*[contains(text(),'Parameters')])[1]")
    private WebElement parameters;
    @FindBy(xpath = "(//*[contains(text(),'Countries')])[1]")
    private WebElement countries;
    @FindBy(xpath = "(//*[contains(text(),'Citizenship')])[1]")
    private WebElement citizenship;
    @FindBy(xpath = "(//*[contains(text(),'Nationalities')])[1]")
    private WebElement nationalities;
    @FindBy(xpath = "(//*[contains(text(),'Fees')])[1]")
    private WebElement fees;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExamsOne;
    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setupTwo;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsTwo;
    @FindBy(xpath = "//div[contains(@class,'navbar-top')]")
    private WebElement leftNavBar;
    @FindBy(xpath = "(//*[contains(text(),'Human Resources')])[1]")
    private WebElement humanResources;
    @FindBy(xpath = "(//*[contains(text(),'Employees')])[1]")
    private WebElement employees;
    @FindBy (xpath = "(//span[text()='States'])")
    private WebElement states;

    WebElement myElement;
    public void findAndClick(String strElement) {

        switch (strElement) {
            case "setupOne": myElement = setupOne; break;
            case "parameters": myElement = parameters; break;
            case "countries" : myElement = countries; break;
            case "citizenship" : myElement = citizenship; break;
            case "nationalities" : myElement = nationalities; break;
            case "fees" : myElement = fees; break;
            case "entranceExamsOne" : myElement =entranceExamsOne; break;
            case "setupTwo" : myElement =setupTwo; break;
            case "entranceExamsTwo" : myElement =entranceExamsTwo; break;
            case "leftNavBar" : myElement =leftNavBar; break;
            case "humanResources" : myElement =humanResources; break;
            case "employees" : myElement =employees; break;
            case "states" : myElement =states; break;
        }

        clickFunction(myElement);
    }
}
