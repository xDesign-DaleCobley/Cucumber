package com.boilerplate.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.boilerplate.cucumber.steps",
		features = "src/acceptanceTestJunit4/resources",
		plugin = { "pretty", "html:build/reports/tests/acceptanceTestJunit4/cucumber-report.html" })
public class CucumberTest {}
