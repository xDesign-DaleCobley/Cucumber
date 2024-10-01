package com.boilerplate.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.boilerplate.cucumber.context.CucumberTestContext;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Steps {

	private final CucumberTestContext context;
	private final HttpClient httpClient = HttpClient.newHttpClient();

	@Given("the request name is set as {word}")
	public void requestNameIs( final String name ) {
		context.setName( name );
	}

	@When("a request is made to GET greeting")
	public void makeRequestGetGreeting() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri( URI.create( "http://localhost:8080/greeting?name=" + context.getName() ) )
				.GET()
				.build();
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
}