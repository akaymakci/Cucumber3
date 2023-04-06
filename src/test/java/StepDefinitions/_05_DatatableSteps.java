package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class _05_DatatableSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    FormContent fc = new FormContent();

    @And("Click on the element in the left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) {
        List<String> listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            //System.out.println("listElement.get(i) = " + listElement.get(i));
            ln.findAndClick(listElement.get(i));
        }
    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {
        List<String> listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            //System.out.println("listElement.get(i) = " + listElement.get(i));
            dc.findAndClick(listElement.get(i));

        }
    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            //System.out.println("listElement.get(i) = " + listElement.get(i));
            dc.findAndSend(listElement.get(i).get(0),listElement.get(i).get(1));

        }
    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            //System.out.println("listElement.get(i) = " + listElement.get(i));
            dc.SearchAndDelete(listElement.get(i).get(0), listElement.get(i).get(1));

        }
    }

//    @And("Click on the element in the Form Content")
//    public void clickOnTheElementInTheFormContent(DataTable elements) {
//        List<List<String>> listElement = elements.asLists(String.class);
//        for (int i = 0; i < listElement.size(); i++) {
//            //System.out.println("listElement.get(i) = " + listElement.get(i));
//            fc.findAndSelect(listElement.get(i).get(0),listElement.get(i).get(1));
//        }
//    }

    @And("User sending the keys in Form Content")
    public void userSendingTheKeysInFormContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            //System.out.println("listElement.get(i) = " + listElement.get(i));
            fc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));

        }
    }

    @And("User select form value in Form Content")
    public void userSelectFormValueInFormContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            //System.out.println("listElement.get(i) = " + listElement.get(i));
            fc.findAndSelect(listElement.get(i).get(0), listElement.get(i).get(1));

        }
    }

    @And("Click on the element in the FormContent")
    public void clickOnTheElementInTheFormContent(DataTable elements) {
        List<String> listElements = elements.asList(String.class);
        for (int i = 0; i < listElements.size(); i++) {
            fc.findAndClick(listElements.get(i));

        }
    }

    @And("User sending text and wait until to be present in Form Content")
    public void userSendingTextAndWaitUntilToBePresentInFormContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            //System.out.println("listElement.get(i) = " + listElement.get(i));
            fc.sendWaitClickFunction(listElement.get(i).get(0), listElement.get(i).get(1));

        }
    }

}
