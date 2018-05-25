package com.example;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="Features",glue={"src/test/resources"})
@CucumberOptions(
        features={"src/test/resources/MyTest.feature"}
)

public class TestRunner
{

}
