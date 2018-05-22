package com.test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.examples.Utils;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;


public class testOne {
	
	@Test
	
//Checking the status code
	
	public void test1() {
		given().get(
				"https://api.github.com/repos/metrolab/SingleDateAndTimePicker")
		.then().statusCode(200);		
	}	

	
	@Test
	public void test2() {		
		given().
		get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker")
		.then().
			body("owner.login", equalTo("metrolab"));
	}

	@Test
	
	public void test3() {
	    get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker").then().assertThat()
	      .body(matchesJsonSchemaInClasspath("schema.json"));
	}
				
		
	
}
