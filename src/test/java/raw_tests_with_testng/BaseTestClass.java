package raw_tests_with_testng;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class BaseTestClass {

	public static String baseURI = "http://localhost:3000";

	public static ValidatableResponse getRequest(String endpoint, int statusCode) {
		RestAssured.baseURI = baseURI;
		ValidatableResponse response = given().when().get(endpoint).then().assertThat().statusCode(statusCode).and()
				.contentType(ContentType.JSON);
		return response;
	}

	public static ValidatableResponse postRequest(String endpoint, int statusCode, String payload) {
		{
			RestAssured.baseURI = baseURI;
			ValidatableResponse response = given().queryParam("key", "value").body(payload).when().post(endpoint).then()
					.assertThat().statusCode(statusCode);
			return response;
		}
	}

	public static ValidatableResponse putRequest(String endpoint, int statusCode, String payload) {
		RestAssured.baseURI = baseURI;
		ValidatableResponse response = given().queryParam("key", "value").body(payload).when().put(endpoint).then()
				.assertThat().statusCode(statusCode);
		return response;

	}
}
