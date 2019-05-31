package raw_tests_with_testng;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.testng.annotations.Test;

public class Test_requests {
	@Test
	public void test1() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(200);
	}
	
	@Test
	public void test2() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().assertThat().statusCode(200);
	}
	
	@Test
	public void test3() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation"));
	}
	
}
