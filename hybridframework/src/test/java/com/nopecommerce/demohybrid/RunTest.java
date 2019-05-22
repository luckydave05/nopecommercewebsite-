package com.nopecommerce.demohybrid;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith (Cucumber.class)
@CucumberOptions(features = "src\\test\\Resources\\Features\\",tags = "@register", plugin = {"pretty","html:target/cucumber-reports"})
public class RunTest
{

}
