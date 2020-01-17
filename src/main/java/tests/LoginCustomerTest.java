package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static tests.PageProvider.getLoginCustomerPage;

public class LoginCustomerTest {

    @When("^I select username as (.*)$")
    public void selectUserName(String usernameSelected) throws InterruptedException {
        Thread.sleep(5000);
        getLoginCustomerPage().selectUserName(usernameSelected);
    }

    @When("^I click login button$")
    public void clickLogin() throws InterruptedException {
        Thread.sleep(5000);
        getLoginCustomerPage().clickLoginButton();
    }

    @Then("^I verify that user as (.*) login successfully$")
    public void verifyLoginSuccessfully(String user) throws InterruptedException {
        Thread.sleep(5000);
        getLoginCustomerPage().verifyCustomerLoginSuccessfully(user);
    }
}
