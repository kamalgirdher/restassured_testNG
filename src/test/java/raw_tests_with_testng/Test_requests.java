package raw_tests_with_testng;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Test_requests {

	/* 
	 * ### Test 1. given() get() then() statusCode(int)
	 */
	@Test
	public void test1() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(200);
	}

	
	/*
	 * ### Test 2. given() get() then() statusCode(Matcher) 
	 */
	@Test
	public void test2() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(equalTo(200));
	}

	/*
	 *  ### Test 3. given() get() then() assertThat() statusCode()
	 */
	@Test
	public void test3() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().assertThat().statusCode(200);
	}

	/*
	 *  ### Test 4. given() get() then() assertThat() body() containsString()
	 */
	@Test
	public void test4() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation"));
	}

	/*
	 *  ### Test 5. given() get() then() root() body(String path,ResponseAwareMatcher<R> responseAwareMatcher)
	 */
	@Test
	public void test5() {

		/*
		 * For Content-Type=application/json
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("lname",
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});

		/*
		 * For Content-Type=application/json
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("lname",
				response -> equalTo("girdher"));
		
		
		
		/*
		 * For Content-Type=application/xml
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SimpleXML_Response").then().root("root").body("lname",
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});
		
		/*
		 * For Content-Type=application/xml
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SimpleXML_Response").then().root("root").body("lname",
				response -> equalTo("girdher"));
		
	}

	/*
	 *  ### Test 6. given() get() then() assertThat() body(List<Argument> arguments,ResponseAwareMatcher<R> responseAwareMatcher)
	 */
	@Test
	public void test6() {
	}

	/*
	 *  ### Test 7. given() get() then() assertThat() body(String path,List<Argument> arguments, ResponseAwareMatcher<R> responseAwareMatcher)
	 */
	@Test
	public void test7() {
	}

	/*
	 *  ### Test 8. given() get() then() assertThat() body(List<Argument> arguments,
	 */
	// org.hamcrest.Matcher matcher, Object... additionalKeyMatcherPairs)
	@Test
	public void test8() {
	}

	/*
	 *  ### Test 9. given() get() then() assertThat() body(String path,
	 *  List<Argument> arguments,org.hamcrest.Matcher matcher,
	 *  Object... additionalKeyMatcherPairs)
	 */
	@Test
	public void test9() {
	}

	/*
	 *  ### Test 10. given() get() then() assertThat() body(String path,
	 *  org.hamcrest.Matcher matcher, Object... additionalKeyMatcherPairs)
	 */
	@Test
	public void test10() {
	}

	/*
	 *  ### Test 11. given() get() then() assertThat() body() containsString() and()
	 */
	@Test
	public void test11() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation"))
				.and().body(containsString("Successful"));
	}

	/*
	 *  ### Test 12. given() get() then() assertThat() content
	 */
	@Test
	public void test12() {
		// given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().content();
	}

}
