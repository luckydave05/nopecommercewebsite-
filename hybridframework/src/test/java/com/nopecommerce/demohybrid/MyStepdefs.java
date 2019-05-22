package com.nopecommerce.demohybrid;

import PageObject.HomePage;
import PageObject.RegisterPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    HomePage homePage = new HomePage ();
    RegisterPage registerPage = new RegisterPage ();
    @Given("user is on home page")
    public void userIsOnHomePage() {


    }

//    @Then("user should be see dollar sign")
//    public void userShouldBeSeeDollarSign() {
//        homePage.presentDollarSign ();
//
//
//
//    }

    @Then("user should be see dollar sign and see featured products in selected currency")
    public void userShouldBeSeeDollarSignAndSeeFeaturedProductsInSelectedCurrency()
    {
            homePage.presentDollarSignAndSeeFeatureProductInSelectedCurrency ();

    }


    @Given("user is on homepage and click register page")
    public void userIsOnHomepageAndClickRegisterPage()
    {
    registerPage.registerPage ();
    }

    @When("user enter all mandatory details")
    public void userEnterAllMandatoryDetails()

    {
        registerPage.registerPersonalDetails ();
    }

    @Then("user should be able to register sucessfully")
    public void userShouldBeAbleToRegisterSucessfully() {

    }
}
