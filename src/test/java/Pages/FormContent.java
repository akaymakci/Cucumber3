package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent {
    public FormContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//mat-select[@formcontrolname='academicPeriod']/div/div)[2]")
    private WebElement academicPeriod;
    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;
    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[2]")
    private WebElement gradeLevel;
    @FindBy(xpath = "//mat-option[@role='option']/span[text()=' Junior Level B ']")
    private WebElement gradeLevel2;
    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname,'firstName')]//input")
    private WebElement firstNameInput;
    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname,'lastName')]//input")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[contains(@formcontrolname,'date')]")
    private WebElement dateOfBirthInput;
    @FindBy(xpath = "(//mat-select[contains(@formcontrolname,'gender')]//div)[3]")
    private WebElement genderInput;
    @FindBy(xpath = "//span[contains(text(),'Male')]")
    private WebElement genderMale;
    @FindBy(xpath = "//span[contains(text(),'Female')]")
    private WebElement genderFemale;
    @FindBy(xpath = "//input[contains(@formcontrolname,'employeeId')]")
    private WebElement employeeIDInput;
    @FindBy(xpath = "(//mat-select[contains(@formcontrolname,'type')]//div)[3]")
    private WebElement employeeTypeInput;
    @FindBy(xpath = "//span[contains(@class,'mat-option')][contains(text(),'Teacher')]")
    private WebElement employeeTypeTeacher;
    @FindBy(xpath = "//span[contains(@class,'mat-option')][contains(text(),'Supervisor')]")
    private WebElement employeeTypeSupervisor;
    @FindBy(xpath = "//span[contains(@class,'mat-option')][contains(text(),'Other')]")
    private WebElement employeeTypeOther;
    @FindBy(xpath = "//mat-select[contains(@formcontrolname,'status')]")
    private WebElement statusInput;
//    @FindBy(id = "mat-select-6")
//    private WebElement statusInput;
    @FindBy(xpath = "//span[contains(text(),' Passive ')]")
    private WebElement statusPassive;
    @FindBy(xpath = "//span[contains(text(),' Active ')]")
    private WebElement statusActive;
    @FindBy(xpath = "//*[contains(@class,'below-static')]")
    private  WebElement toolBar;
//    @FindBy(xpath ="(//div[contains(@class,'mat-select-arrow')])[11]")
//    private WebElement documentTypeInput;
    @FindBy(xpath ="(//mat-select[contains(@formcontrolname,'type')]//div)[7]")
    private WebElement documentTypeInput;
    @FindBy(xpath ="//span[contains(@class,'mat-option')][contains(text(),'Personal ID')]")
    private WebElement documentTypePersonelId;
    @FindBy(xpath ="//span[contains(@class,'mat-option')][contains(text(),'Passport')]")
    private WebElement documentTypePassport;
    @FindBy(xpath ="//span[contains(@class,'mat-option')][contains(text(),'Birth')]")
    private WebElement documentTypeBirthCertificate;
    @FindBy(xpath ="(//input[contains(@formcontrolname,'documentNumber')])")
    private WebElement documentNumberInput;
    @FindBy(xpath ="(//div[contains(text(),'Contact & Address')])")
    private WebElement contactAddressTab;
    @FindBy(xpath ="//input[contains(@formcontrolname,'country')]")
    private WebElement countryInput;

    WebElement myElement;

    public void findAndClick(String strElement){  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "academicPeriod" : myElement =academicPeriod; break;
            case "academicPeriod1" : myElement =academicPeriod1; break;
            case "gradeLevel" : myElement =gradeLevel; break;
            case "gradeLevel2" : myElement =gradeLevel2; break;
            case "contactAddressTab" : myElement =contactAddressTab; break;

        }

        clickFunction(myElement);

    }

    public void findAndSend(String strElement, String value) {

        switch (strElement) {

            case "firstNameInput" : myElement =firstNameInput; break;
            case "lastNameInput" : myElement =lastNameInput; break;
            case "dateOfBirthInput" : myElement =dateOfBirthInput; break;
            case "employeeIDInput" : myElement =employeeIDInput; break;
            case "documentNumberInput" : myElement =documentNumberInput; break;
            //case "countryInput" : myElement =countryInput; break;
        }
        sendKeysFunction(myElement, value);
    }
    WebElement myFormElement;
    public void findAndSelect(String strElement, String formElement) {

        switch (strElement) {

            case "genderInput" : myElement =genderInput; break;
            case "employeeTypeInput" : myElement =employeeTypeInput; break;
            case "statusInput" : myElement =statusInput; break;
            case "documentTypeInput" : myElement =documentTypeInput; break;

        }
        switch (formElement){

            case "genderFemale" : myFormElement =genderFemale; break;
            case "genderMale" : myFormElement =genderMale; break;
            case "employeeTypeTeacher" : myFormElement =employeeTypeTeacher; break;
            case "employeeTypeSupervisor" : myFormElement =employeeTypeSupervisor; break;
            case "employeeTypeOther" : myFormElement =employeeTypeOther; break;
            case "statusPassive" : myFormElement =statusPassive; break;
            case "statusActive" : myFormElement =statusActive; break;
            case "documentTypePersonelId" : myFormElement =documentTypePersonelId; break;
            case "documentTypePassport" : myFormElement =documentTypePassport; break;
            case "documentTypeBirthCertificate" : myFormElement =documentTypeBirthCertificate; break;

        }
        //selectFormValueFunction(myElement, myFormElement);
        selectFormFunction(myElement,myFormElement);
    }
    public void sendWaitClickFunction(String strElement, String value){

        switch (strElement) {
            case "countryInput" : myElement =countryInput; break;
        }
        sendWaitClick(myElement, value);
    }
}
