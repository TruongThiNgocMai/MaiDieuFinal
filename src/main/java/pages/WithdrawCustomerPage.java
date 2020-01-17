package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static tests.PageProvider.getCommonPage;

public class WithdrawCustomerPage {
    String currentDate;
    @FindBy(xpath = "//div/div[3]/button[3]")
    WebElement withdrawTab;
    @FindBy(xpath = "//div/div[4]/div/form/div/input")
    WebElement withdrawNumber;
    @FindBy(xpath = "//div/form/button")
    WebElement withdrawButton;
    @FindBy(xpath = "//div[4]/div/span")
    WebElement message;

    public void navigateToWithdrawTab() {
        this.withdrawTab.click();
    }

    public void typeWithdrawAmount(String withdrawAmount) {
        this.withdrawNumber.clear();
        this.withdrawNumber.sendKeys(withdrawAmount);
    }

    public void submitWithdraw() {
        withdrawButton.click();
        currentDate = getCommonPage().getDateTime();
    }

    public void verifyMessage() {
        if (message.isDisplayed())
            Assert.assertEquals(message.getText(), "Transaction successful", "Input Withdraw unSuccessful");
    }
}
