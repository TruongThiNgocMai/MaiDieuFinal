package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static java.lang.Thread.sleep;

public class LoginCustomerPage {

    @FindBy(id = "userSelect")
    WebElement account;

    @FindBy(xpath = "//form/button")
    WebElement loginBtn;

    @FindBy(xpath = "//div[3]/div/div[1]/button[2]")
    WebElement logoutBtn;

    @FindBy(xpath = "//div[3]/button[1]")
    WebElement transactionBtn;

    @FindBy(xpath = "//div[3]/button[2]")
    WebElement depositTab;

    @FindBy(xpath = "//div[3]/button[3]")
    WebElement withdrawBtn;

    @FindBy(xpath = "//strong/span")
    WebElement accountName;

    public void selectUserName(String usernameSelected)  {
        account.click();

        List<WebElement> listUserName = account.findElements(By.tagName("option"));
        for (WebElement userName : listUserName) {
            if (userName.getText().toLowerCase().equalsIgnoreCase(usernameSelected)) {
                userName.click();
                break;
            }
        }
    }

    public void clickLoginButton()  {
        if (loginBtn.isDisplayed()) {
            loginBtn.click();
        } else {
            System.out.println("Element not present");
        }
    }

    public void verifyCustomerLoginSuccessfully(String userNameSelected) {
        if (logoutBtn.isDisplayed() && depositTab.isDisplayed() && transactionBtn.isDisplayed()
                && withdrawBtn.isDisplayed() && accountName.isDisplayed()) {
            Assert.assertEquals(accountName.getText(), userNameSelected, "User login unsuccessful");
        }
    }
}
