package raw_tests_with_testng;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Test_requests {
	@Test
	public void test_getRequest() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(200);
	}
	
}
