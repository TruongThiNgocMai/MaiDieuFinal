package pages;

import gherkin.lexer.Th;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class DepositCustomerPage{
    @FindBy(xpath = "//div[3]/button[2]")
    WebElement depositTab;
    @FindBy(xpath = "//div[4]/div/form/div/input")
    WebElement depositNumber;
    @FindBy(xpath = "//form/button")
    WebElement depositButton;
    @FindBy(xpath = "//div[4]/div/span")
    WebElement messageLabel;

    public void navigateToDepositTab() throws InterruptedException {
        Thread.sleep(5000);
        depositTab.click();
    }

    public void typeDepositAmount(String depositAmount) throws InterruptedException {
        Thread.sleep(5000);
        depositNumber.clear();
        depositNumber.sendKeys(depositAmount);
    }

    public void submitDeposit() throws InterruptedException {
        Thread.sleep(5000);
        depositButton.click();
    }

    public void verifyMessageSuccessfully() throws InterruptedException {
        if (messageLabel.isDisplayed()) {
            Assert.assertEquals(messageLabel.getText(),"Deposit Successful", "Label message of Deposit is not display!");
        }
    }
}



