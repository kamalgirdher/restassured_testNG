
To learn automation, Subscribe on Youtube.  :red_circle: 
https://www.youtube.com/c/xtremeExcel

or join our Telegram group.  :large_blue_circle: 
https://t.me/letsautomate

## What is RestAssured
REST Assured is a Java library that provides a domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs.
REST Assured can be used easily in combination with testing frameworks such as JUnit and TestNG. 

## Installation

 > Download and install Mockoon(https://mockoon.com) to mock services and practice extensively.

 > Create New environment in mockoon using mockoon_environment.json in the project. [Refer : 	https://megettingerror.blogspot.com/2019/06/how-to-import-environment-in-mockoon.html]

 > Download and install Postman (chrome plugin or standalone)
 


# GET

## Initial tests using RestAssured & TestNG
 > Open Test_requests.java in src/test/java/raw_tests_with_testng

--------------------------------------------------------------------------------


 ### Test 1. given()  get()  then()  statusCode(int)

  #### API response : get_200_OK_SIMPLE_BODY_MESSAGE
	{Operation Successful!}

  #### Code : 
```java
public void test1() {
	given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(200);
}
```

--------------------------------------------------------------------------------


### Test 2. given()  get()  then()  statusCode(Matcher)
> Note :  Use this import for equalsTo : import static org.hamcrest.CoreMatchers.equalsTo;

  #### API response : get_200_OK_SIMPLE_BODY_MESSAGE
	{Operation Successful!}

  #### Code :   
```java
public void test2() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(equalTo(200));
	}
```

--------------------------------------------------------------------------------

### Test 3. given()  get()  then() assertThat() statusCode()

  #### API response : get_200_OK_SIMPLE_BODY_MESSAGE
	{Operation Successful!}

  #### Code :   
```java
	public void test3() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().assertThat().statusCode(200);
	}
```
 
--------------------------------------------------------------------------------

### Test 4. given()  get()  then() assertThat() body(Matcher<?> matcher, Matcher<?>...additionalMatchers)

> Note : Use this import for containsString : import static org.hamcrest.CoreMatchers.containsString;

  #### API response : get_200_OK_SIMPLE_BODY_MESSAGE
	{Operation Successful!}

  #### Code :   
```java
	public void test4() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation"));
	}
```
> we can pass multiple matchers comma separated.
  
 --------------------------------------------------------------------------------

 ### Test 5. given()  get()  then() assertThat()  body(String path, ResponseAwareMatcher<R> responseAwareMatcher) 

 #### API response : get_200_OK_SingleNode_Response
	{
		"fname":"kamal",
		"lname":"girdher",
		"website1":"https://extremeExcel.com",
		"website2":"https://megettingerror.blogspot.com"
	}
	
	
 #### API response : get_200_OK_SimpleXML_Response
	<root>
		<fname>kamal</fname>
		<lname>girdher</lname>
	</root>	
	

  #### Code :   
```java
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
```

--------------------------------------------------------------------------------


### Test 6. given()  get()  then() assertThat()  body(List<Argument> arguments, ResponseAwareMatcher<R> responseAwareMatcher) 

 #### API response : get_200_OK_SingleNode_Response
	{
		"fname":"kamal",
		"lname":"girdher",
		"website1":"https://extremeExcel.com",
		"website2":"https://megettingerror.blogspot.com"
	}
	
	
 #### API response : get_200_OK_SimpleXML_Response
	<root>
		<fname>kamal</fname>
		<lname>girdher</lname>
	</root>	

 #### Code :
```java
public void test6() {
		
		/*
		 * For Content-Type=application/xml
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SimpleXML_Response").then().root("root.%s").body(withArgs("lname"),
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});		
		
		/*
		 * For Content-Type=application/json
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().root("%s").body(withArgs("lname"),
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});
		
		/*
		 * For Content-Type=application/json
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().root("%s").body(withArgs("lname"),
				response -> equalTo("girdher"));
		
		/*
		 * For Content-Type=application/xml
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SimpleXML_Response").then().root("root.%s").body(withArgs("lname"),
				response -> equalTo("girdher"));

	}

```

--------------------------------------------------------------------------------

### Test 7. given()  get()  then() assertThat() body(String path, List<Argument> arguments, ResponseAwareMatcher<R> responseAwareMatcher)

 #### API response : get_200_OK_SingleNode_Response
	{
		"fname":"kamal",
		"lname":"girdher",
		"website1":"https://extremeExcel.com",
		"website2":"https://megettingerror.blogspot.com"
	}

 #### Code :
```java
public void test7() {
		
		/*
		 * For Content-Type=application/json
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("website%s", withArgs("1"),
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("https://extremeExcel.com");
					}
				});		
	
		/*
		 * For Content-Type=application/json
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("website%s",withArgs("1"),
				response -> equalTo("https://extremeExcel.com"));
		
	}

```

--------------------------------------------------------------------------------

### Test 8. given()  get()  then() assertThat()  body(List<Argument> arguments, org.hamcrest.Matcher matcher, Object... additionalKeyMatcherPairs)
```java
unable to find usage of Object. Write to me at excel.microk@gmail.com if you have an example
```

--------------------------------------------------------------------------------

### Test 9. given()  get()  then() assertThat() body(String path, List<Argument> arguments,org.hamcrest.Matcher matcher, Object... additionalKeyMatcherPairs)
```java
unable to find usage of Object. Write to me at excel.microk@gmail.com if you have an example
```

--------------------------------------------------------------------------------

### Test 10. given()  get()  then() assertThat() body(String path, org.hamcrest.Matcher matcher, Object... additionalKeyMatcherPairs)
```java
unable to find usage of Object. Write to me at excel.microk@gmail.com if you have an example
```

--------------------------------------------------------------------------------

### Test 11. given()  get()  then() assertThat() body()  containsString()  and()

  #### API response : get_200_OK_SIMPLE_BODY_MESSAGE
	{Operation Successful!}

  #### Code : 
```java
public void test11() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation")).and().body(containsString("Successful"));
	}
```

--------------------------------------------------------------------------------

### Test 12. given()  get()  then() assertThat() content()

 #### API response : get_200_OK_SingleNode_Response
	{
		"fname":"kamal",
		"lname":"girdher",
		"website1":"https://extremeExcel.com",
		"website2":"https://megettingerror.blogspot.com"
	}
 #### Code :
```java
	public void test12() {
		/*
		 * For Content-Type=application/json
		 * for java v1.7 or less we use ResponseAwareMatchers
		 * 
		 * For now I see no difference in .body() and .content(). If you have answer, please
		 * reply on stackoverflow https://stackoverflow.com/questions/56408253/difference-between-restassured-body-and-content
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().content("website%s", withArgs("1"),
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("https://extremeExcel.com");
					}
				});		
	
	}
```
--------------------------------------------------------------------------------

### Test 13. given()  get()  then() assertThat() contentType()

 #### API response : get_200_OK_SingleNode_Response
	{
		"fname":"kamal",
		"lname":"girdher",
		"website1":"https://extremeExcel.com",
		"website2":"https://megettingerror.blogspot.com"
	}
 #### Code :
```java
	public void test13() {
		
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().contentType(equalTo("application/json; charset=utf-8"));
		
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().contentType("application/json; charset=utf-8");
	}
```

--------------------------------------------------------------------------------

### Test 14. given() get() then() Cookies [ getDetailedCookies(), get() , getValue()]
 #### Code :
```java
	public void test14() {
		
		//print a cookie value
		Cookies allCookies = get("https://www.stackoverflow.com").getDetailedCookies();
		Cookie myCookie = allCookies.get("prov");
		System.out.println("Cookie value is : " + myCookie.getValue());
		System.out.println("Cookie Domain is : " + myCookie.getDomain());
		System.out.println("Cookie Max age is : " + myCookie.getMaxAge());
		System.out.println("Cookie path is : " + myCookie.getPath());
		System.out.println("Cookie version is : " + myCookie.getVersion());
		System.out.println("Cookie Comment is : " + myCookie.getComment());
		System.out.println("Cookie Expires on : " +  myCookie.EXPIRES);
		
		//verify cookie value using Matchers
		given().get("https://www.stackoverflow.com").then().cookie("prov",containsString("-"));
		
		//Another way to extract cookie value
		System.out.println("Another way to read cookie value : " + given().get("https://www.stackoverflow.com").then().extract().detailedCookie("prov").getValue());
	}
```

--------------------------------------------------------------------------------


### Test 15. header() and headers()

 #### Headers:
	myHeader = kamal
	secondHeader = second
	thirdHeader = third

 #### Code :
```java
	public void test15() {
		get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().header("myHeader",equalTo("kamal"));
		
		get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().headers("myHeader",equalTo("kamal"));
		
		get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().headers("myHeader",equalTo("kamal"),"secondHeader",equalTo("second"));
	}
```

--------------------------------------------------------------------------------

### Test 16. log()
```java
	public void test16() {
		System.out.println("Log body :: ");
		System.out.println(get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().log().body());
		
		System.out.println("Log Everything:: ");
		System.out.println(get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().log().everything());
		
		System.out.println("Log when status matches: ");
		System.out.println(get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().log().ifStatusCodeIsEqualTo(200));
		
		System.out.println("Log when status matches: ");
		System.out.println(get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().log());
		
	}
```


--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
## Important questions for Interview:

  Q 1. What is RequestSpecBuilder?

  Q 2. What is difference between .body() and .content()?
	get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(...)
	get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().content(...)

  Q 3. Write a use case where we use .log() function for verification using restassured.
	get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().log()

  Q 4. What is ResponseAwareMatcher? How do we use it?
  
  Q 5. What is difference b/w below statements?
  
	>	get("/something").then().assertThat().body(containsString("OK")).and().body(containsString("something else"));		
		
		and
		
	>	get("/something").then().assertThat().body(containsString("OK")).body(containsString("something else"));
	

  Q 6. Explore the usage of below \ :cyclone: using() \ :cyclone: statusLine() \ :cyclone: appendRoot() \  :cyclone: defaultParser() \ :cyclone: detachRoot() \  :cyclone: noRoot() \  :cyclone: noRootPath() \ :cyclone: parser() \ :cyclone: spec() \ :cyclone: specification()
	
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------















  
Source : https://github.com/executeautomation/restassured

