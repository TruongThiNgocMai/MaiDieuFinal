package pages;

import gherkin.lexer.Th;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutCustomerPage {
    @FindBy(xpath = "//div[3]/div/div[1]/button[2]")
    WebElement logOutBtn;

    public void clickLogoutBtn() throws InterruptedException{
        Thread.sleep(5000);
        logOutBtn.click();
    }

    public void verifyLogOut()  {
        if(!(logOutBtn.isDisplayed())){
            System.out.println("Logout Successfully");
        }
        else {
            System.out.println("Logout unSuccessfully");
        }
    }
}
