package com.boilerplate.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.boilerplate.cucumber.context.CucumberTestContext;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Steps {

	private final CucumberTestContext context;
	private final HttpClient httpClient = HttpClient.newHttpClient();

	@Before
	public void before() {
		// executed before the first step of each scenario.  Be careful using this as it's invisible to someone only reading the feature files!
		// Most of the time Background steps are a better alternative.
		// Useful for techy steps such as clearing a database.
		context.clear();
	}

	@Given("{word} exists")
	public void nameExists( final String name ) {
		// nothing to do, just an example step for context
	}

	@Given("the request name is set as {word}")
	public void requestNameIs( final String name ) {
		context.setName( name );
	}

	@When("a request is made to GET greeting")
	public void makeRequestGetGreeting() throws IOException, InterruptedException {
		String uri = context.getName() == null || context.getName().isBlank() ?
				"http://localhost:8080/greeting" : "http://localhost:8080/greeting?name=" + context.getName();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( uri ) ).GET().build();
		context.setResponse( httpClient.send( request, HttpResponse.BodyHandlers.ofString() ) );
	}

	@Then("the response code is {int}")
	public void theResponseCodeIs( Integer responseCode ) {
		assertThat( context.getResponse().statusCode() ).isEqualTo( responseCode );
	}

	@Then("the response has message {string}")
	public void theResponseHasMessage( final String message ) {
		assertThat( context.getResponse().body() ).contains( message );
	}

	@After()
	public void after( Scenario scenario ) {
		// executed at the end of each scenario, even when they fail.  Scenario param is optional.
	}

	@After("@tag")
	public void afterTag( Scenario scenario ) {
		// executed at the end of each scenario tagged with "@tag", even when they fail.  Scenario param is optional.
	}
}