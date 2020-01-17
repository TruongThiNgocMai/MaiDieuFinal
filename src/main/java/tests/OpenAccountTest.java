package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static tests.PageProvider.getOpenAccountPage;
import static tests.PageProvider.getCommonPage;

public class OpenAccountTest {

    @When("^I choose account as (.+) and currency as (.+)$")
    public void openAccount(String fullname, String currency) throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().getUserInformation(fullname);
        Thread.sleep(5000);
        getOpenAccountPage().getCurrency(currency);
    }

    @And("^I click open account$")
    public void clickOpenAccount() throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().clickProcess();
    }

    @Then("^I verify that user is already open$")
    public void verifyUserAlreadyOpen() throws InterruptedException {
        Thread.sleep(5000);
        getCommonPage().getAccountNumber();
    }
}
