package Pages;

import Utilities.GWD;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Parent {
//    @FindBy(xpath = "//*[contains(@class,'below-static')]")
//    private  WebElement toolBar;

    public void sendKeysFunction(WebElement element, String value){
        waitUntilVisible(element); //gozukene kadar bekle
        scrollToElement(element);  //elemente kadar scroll yap
        element.clear();           //kutucugu temizle
        element.sendKeys(value);   //degeri gonder
        element.sendKeys(Keys.ENTER); //kutuya enter gönder

    }
    public void selectFormValueFunction(WebElement element, WebElement strElement){
        Actions actions = new Actions(GWD.getDriver());
        waitUntilVisible(element); //gozukene kadar bekle
        scrollToElement(element);//elemente kadar scroll yap
        //actions.sendKeys(Keys.ENTER).perform();
        clickFunction(element); //elemente tikla
        clickFunction(element);
        waitUntilVisible(strElement); //gozukene kadar bekle
        scrollToElement(strElement);  //elemente kadar scroll yap
        actions.sendKeys(Keys.ENTER).perform();
        //clickFunction(strElement); // elementi sec
        //WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(2));

        //actions.sendKeys(Keys.ESCAPE).perform();

    }
    public void selectFormFunction(WebElement element, WebElement strElement){
        Actions actions = new Actions(GWD.getDriver());
        waitUntilClickable(element);
        Action action1 = actions.moveToElement(element).click().build();
        scrollToElement(element);
        action1.perform();
        waitUntilClickable(strElement);
        Action action2 = actions.moveToElement(strElement).click().build();
        scrollToElement(strElement);
        action2.perform();
        actions.sendKeys(Keys.ESCAPE).perform();

    }

    public void sendWaitClick(WebElement element, String value){
        sendKeysFunction(element, value);
        //String str = value.;
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//mat-option[contains(@id,'mat-option')])"),value));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//mat-option[contains(@id,'mat-option')])")));
        List<WebElement> listElements=GWD.getDriver().findElements(By.xpath("(//mat-option[contains(@id,'mat-option')])"));
        for (WebElement ele : listElements) {
            //if (ele.getText().equals(value)) {
                //ele.click();
            System.out.println(ele.getText());
            //wait.until(ExpectedConditions.elementToBeClickable(listElements.get(0)));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            listElements.get(0).click();
            listElements.get(0).click();
                //break;
            }
       // }
    }
    public void waitUntilVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        //wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView;",element);

    }
//    public void clickToElement(WebElement element){
//        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
//        js.executeScript("arguments[0].click();",element);
//
//    }
    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element); // tıklanabilir olana kadar bekle
        scrollToElement(element); // elemente scroll yap
        element.click(); // click yap
    }
    public void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilStaleness(WebElement element) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void verifyContainsText(WebElement element, String text)
    {
        waitUntilVisible(element); // gözükene kadar bekle
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }
    public boolean booleanContainsText(WebElement element, String text)
    {
//        waitUntilVisible(element); // gözükene kadar bekle
        verifyContainsText(element,text);
        return element.getText().toLowerCase().contains(text.toLowerCase());
    }
    public void waitUntilLoading() {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
    }
    public void scrollToUpElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'top:0px')", element);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }
}
