package com.boilerplate.cucumber.runner;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.boilerplate.cucumber.steps")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,
		value = "src/acceptanceTestJunit5/resources")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,
		value = "pretty, html:build/reports/tests/acceptanceTestJunit5/cucumber-report.html")
public class CucumberTest {}
