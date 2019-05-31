package raw_tests_with_testng;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Test_requests {
	@Test
	public void test_getRequest() {
		given().get("http://localhost:3000/answer").then().statusCode(200);
	}	
}
