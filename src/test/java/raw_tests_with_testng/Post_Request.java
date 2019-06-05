package raw_tests_with_testng;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Post_Request {
	
	/*
	 *  ### Test 17. RequestSpecBuilder
	 */
	@Test
	public void test17() {
		RequestSpecBuilder builder= new RequestSpecBuilder();
		RequestSpecification requestSpec;
		builder.addHeader("Content-Type","application/json");
		builder.addParam("user","Kamal");
		requestSpec = builder.build();
		
		given().spec(requestSpec).when().post("http://localhost:3000/post_200_With_Header").then().body("lname",equalTo("girdher"));
	}


	/*
	 *  ### Test 18. RequestSpecBuilder
	 */
	@Test
	public void test18() {
		ResponseSpecBuilder builder= new ResponseSpecBuilder();
		ResponseSpecification responseSpec;
		builder.expectStatusCode(200);
		builder.expectBody("fname",equalTo("kamal"));
		responseSpec = builder.build();
		
		given().post("http://localhost:3000/post_200_With_Header").then().spec(responseSpec);
	}
}
