package com.boilerplate.cucumber.context;

import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * Provides a place to share state between step definitions.
 */
@Getter
@Setter
@Component
public class CucumberTestContext {

	private String name;
	private HttpResponse<String> response;
}