package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class TransactionCustomerPage {

    @FindBy(xpath = "//div/div[3]/button[1]")
    WebElement transactionTab;

    @FindBy(xpath = "//div[3]/button[2]")
    WebElement depositTab;

    @FindBy(xpath = "//div[3]/button[3]")
    WebElement withdrawBtn;

    @FindBy(xpath = "//div[2]/table")
    WebElement table;

    @FindBy(xpath = "//div[2]/div/div[1]/button[1]")
    WebElement backBtn;

    @FindBy(xpath = "//div[2]/div/div[1]/button[2]")
    WebElement resetBtn;

    @FindBy(xpath = "//strong/span")
    WebElement welcomeName;

    @FindBy(xpath = "//div[2]/strong[2]")
    WebElement balanceLabel;

    public void navigateTransactionTab() {
        transactionTab.click();
    }

    public void resetTableTransaction(){
        resetBtn.click();
    }

    public void verifyBackButtonSuccess() {
        if (transactionTab.isDisplayed() && depositTab.isDisplayed()
                && withdrawBtn.isDisplayed() && welcomeName.isDisplayed()) {
            System.out.println("Navigate Home Page Successfully!!!");
        } else {
            System.out.println("Navigate Home Page unSuccessfully!!!");
        }
    }

    public void backButtonAtTransaction() {
        backBtn.click();
    }

    public void verifyResetButtonSuccess(){
        List<WebElement> listTr = table.findElements(By.tagName("tr"));
        for (int i = 1; i < listTr.size(); i++) {
            List<WebElement> listTd = listTr.get(i).findElements(By.tagName("td"));
            String tdAmount = String.valueOf(listTd.get(1).getText());
            if (listTr.size() < 1 && tdAmount.equalsIgnoreCase(balanceLabel.getText())) {
                System.out.println("Reset table Successfully!");
            } else
                System.out.println("Reset table unSuccessfully!");
        }
    }
}
