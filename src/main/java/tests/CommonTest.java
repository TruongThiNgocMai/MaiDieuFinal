package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import runner.TestRunner;

import static java.lang.Thread.sleep;
import static tests.PageProvider.getLoginCustomerPage;
import static tests.PageProvider.getDepositCustomerPage;
import static tests.PageProvider.getWithdrawCustomerPage;

public class CommonTest {

    @Given("Open website (.*)$")
    public void user_already_on_home_page(String website) throws InterruptedException {
        sleep(5000);
        TestRunner.driver.get(website);
        TestRunner.driver.manage().window().maximize();
    }

    @When("^I login successfully with username as (.*)$")
    public void loginBeforeWithdraw(String usernameSelected) throws InterruptedException {
        sleep(5000);
        getLoginCustomerPage().selectUserName(usernameSelected);
        Thread.sleep(5000);
        getLoginCustomerPage().clickLoginButton();
    }


    @When("^I type deposit successfully with deposit as (.*)$")
    public void alreadyDepositBeforeWithdrawl(String depositAmount) throws InterruptedException {
        Thread.sleep(5000);
        getDepositCustomerPage().navigateToDepositTab();
        sleep(5000);
        getDepositCustomerPage().typeDepositAmount(depositAmount);
        sleep(5000);
        getDepositCustomerPage().submitDeposit();
        Thread.sleep(5000);

    }
    @When ("^I verify user input Deposit successful with (.*)$")
    public void verifyDeposit(String deposit) throws InterruptedException {
        sleep(5000);
        getDepositCustomerPage().navigateToDepositTab();
        Thread.sleep(5000);
        getDepositCustomerPage().typeDepositAmount(deposit);
        getDepositCustomerPage().submitDeposit();
        Thread.sleep(5000);
    }

    @When ("^I verify user input Withdraw successful with (.*)$")
    public void verifyWithdraw(String withdraw) throws InterruptedException {
        sleep(5000);
        getWithdrawCustomerPage().navigateToWithdrawTab();
        Thread.sleep(5000);
        getWithdrawCustomerPage().typeWithdrawAmount(withdraw);
        getWithdrawCustomerPage().submitWithdraw();
        Thread.sleep(5000);
    }
}


