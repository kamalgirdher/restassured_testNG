package raw_tests_with_testng;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

public class Test_requests {
	
	//### Test 1. given()  get()  then()  statusCode(int)
	@Test
	public void test1() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(200);
	}
	
	//### Test 2. given()  get()  then()  statusCode(Matcher)
	@Test
	public void test2() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(equalTo(200));
	}
	
	
	//### Test 3. given()  get()  then() assertThat() statusCode()
	@Test
	public void test3() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().assertThat().statusCode(200);
	}
	
	
	//### Test 4. given()  get()  then() assertThat() body()  containsString()
	
	@Test
	public void test4() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation"));
	}
	
	@Test
	public void test5() {		
	}
	
	@Test
	public void test6() {		
	}
	
	@Test
	public void test7() {		
	}
	
	@Test
	public void test8() {		
	}
	
	
	@Test
	public void test9() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation")).and().body(containsString("Successful"));
	}
	
	
	@Test
	public void test10() {
		//given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().content();
	}
	
}
