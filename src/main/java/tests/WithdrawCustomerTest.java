package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.ParseException;

import static tests.PageProvider.getWithdrawCustomerPage;
import static tests.PageProvider.getCommonPage;
import static tests.PageProvider.getTransactionPage;

public class WithdrawCustomerTest {
    String datetime = "";

    @When("^I open withdraw tab$")
    public void openWithdrawTab() throws Throwable {
        Thread.sleep(5000);
        getWithdrawCustomerPage().navigateToWithdrawTab();
    }


    @When("^I type withdraw as(.*)$")
    public void chooseWithdrawAmount(String withdrawAmount) throws InterruptedException {
        Thread.sleep(5000);
        getWithdrawCustomerPage().typeWithdrawAmount(withdrawAmount);
    }

    @When("^I click withdraw submit button$")
    public void clickWithdrawSubmitButton() throws InterruptedException {
        Thread.sleep(5000);
        getWithdrawCustomerPage().submitWithdraw();
        datetime = getCommonPage().getDateTime();
    }

    @Then("^I verify amount input of Withdraw")
    public void verifyInputWithdraw() throws InterruptedException {
        Thread.sleep(5000);
        getWithdrawCustomerPage().verifyMessage();
    }

    @Then("^I click Transaction to navigate to Transaction Tab")
    public void navigateTransactionTab() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionPage().navigateTransactionTab();
    }


    @Then("^I verify that customer withdraw successfully as(.*)$")
    public void verifyWithdrawSuccesfully(String withdraw) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getCommonPage().verifyAmountInput(withdraw, datetime, "Debit");
    }

    @Then("^I verify that customer withdraw unsuccessfully as (.*)$")
    public void verifyWithdrawunSuccesfully(String withdraw) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getCommonPage().verifyAmountInput(withdraw, datetime, "Debit");
    }
}
