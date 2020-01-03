package com.example;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="Features",glue={"src/test/resources"})
@CucumberOptions(
        features={
//                "src/test/resources/MyTest.feature"
//                "src/test/resources/TC_ETAFare_01_Local.feature"
                "src/test/resources/TC_ETAFare_01_Beta.feature",

//                "src/test/resources/TC_LoginWB_01.feature"
//                "src/test/resources/TC_LoginWB_AddCard_01.feature"


        }
)

public class TestRunner
{

}
