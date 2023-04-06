package Pages;

import Utilities.GWD;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(xpath = "(//*[contains(@id,'mat-input')])[1]")
    private WebElement userName;
    @FindBy(xpath = "(//*[contains(@id,'mat-input')])[2]")
    private WebElement passWord;
    @FindBy(className = "mat-button-wrapper")
    private  WebElement loginButton;
    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    private  WebElement dashBoard;
    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;
    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortNameInput;
    @FindBy(xpath = "//div[contains(text(),'already')]")
    private WebElement failMessage;
    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeButton;
    @FindBy(xpath = "(//ms-text-field[contains(@placeholder,'FIELD.NAME')]//input)[1]")
    private WebElement searchInput;
    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchButton;
    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    private WebElement deleteButton;
    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogButton;
    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname,'IntegrationCode')]//input")
    private WebElement integrationCode;
    @FindBy(xpath = "//ms-integer-field[contains(@formcontrolname,'priority')]//input")
    private WebElement priorityCode;
    @FindBy(xpath = "//*[contains(text(),'Accept')]")
    private WebElement acceptCookies;
    @FindBy(xpath = "//input[contains(@id,'mat-input')]")
    private WebElement formSearchInput;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;
    WebElement myElement;
    public void findAndSend(String strElement, String value){

        switch (strElement)
        {
            case "userName" : myElement = userName; break;
            case "passWord" : myElement = passWord; break;
            case "nameInput" : myElement = nameInput; break;
            case "codeInput" : myElement = codeInput; break;
            case "shortNameInput" : myElement = shortNameInput; break;
            case "searchInput" : myElement = searchInput; break;
            case "integrationCode" : myElement = integrationCode; break;
            case "priorityCode" : myElement = priorityCode; break;
            case "formSearchInput" : myElement = formSearchInput; break;
        }

        sendKeysFunction(myElement, value);

    }

    public void findAndClick(String strElement){

        switch (strElement)
        {
            case "loginButton" : myElement = loginButton; break;
            case "addButton" : myElement = addButton; break;
            case "saveButton" : myElement = saveButton; break;
            case "closeButton" : myElement = closeButton; break;
            case "searchButton" : myElement = searchButton; break;
            case "deleteButton" : myElement = deleteButton; break;
            case "deleteDialogButton" : myElement = deleteDialogButton; break;
            case "acceptCookies" : myElement = acceptCookies; break;
//            case "acceptCookies" : myElement = acceptCookies; break;
        }

        clickFunction(myElement);

    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {
            case "dashBoard": myElement = dashBoard; break;
            case "successMessage": myElement = successMessage; break;
            case "failMessage": myElement = failMessage; break;

        }
        verifyContainsText(myElement, text);
    }
//        public void findAndContainsText(String strElement, String text){
//
//            switch (strElement)
//            {
//                case "dashBoard" : myElement =dashBoard; break;
//                case "successMessage" : myElement =successMessage; break;
//                case "failMessage" : myElement =failMessage; break;
//
//            }
//            verifyContainsText(myElement,text);
//
//    }

        public boolean booleanFindAndContainsText(String strElement, String text){

            switch (strElement) {
                case "dashBoard": myElement = dashBoard; break;
                case "successMessage": myElement = successMessage; break;
                case "failMessage": myElement = failMessage; break;
            }
            return booleanContainsText(myElement, text);
        }

    public void SearchAndDelete(String strElement, String searchText){

        //scrollUp()
//        switch (strElement){
//            case "searchInput": myElement = searchInput; break;
//            case "formSearchInput": myElement = formSearchInput; break;
//        }
        findAndSend(strElement, searchText); // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas

        //waitUntilLoading();

        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"),"Search"));


        findAndClick("deleteButton");// silme butonua bas
        findAndClick("deleteDialogButton");// dilogdaki silme butonuna bas
    }

    public void SearchAndDeleteOneParameter(String searchText){

        //scrollUp()
        findAndSend("searchInput", searchText); // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas

        //waitUntilLoading();

        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"),"Search"));


        findAndClick("deleteButton");// silme butonua bas
        findAndClick("deleteDialogButton");// dilogdaki silme butonuna bas
    }
    public void takeScreenShot(String strElement) throws IOException {
        switch (strElement)
        {
//            case "dialogActionScreen" : myElement =dialogActionScreen; break;
//            case "successMessage" : myElement =successMessage; break;
//            case "failMessage" : myElement =failMessage; break;

        }
        GWD.wait.until(ExpectedConditions.visibilityOf(myElement));
        TakesScreenshot ts = (TakesScreenshot) GWD.getDriver(); // 1.Aşama ekran görünütüsü alma değişkenini tanımladım
        File hafizadakiHali = ts.getScreenshotAs(OutputType.FILE);  // 2.Aşama Saklama tipi seçildi (Dosya), data(Veritabanı) (Byte)
        FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuleri/" + strElement + "TikKontrol.png"));
    }
}
