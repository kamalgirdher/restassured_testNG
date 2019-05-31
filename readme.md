
To learn automation, Subscribe on Youtube.
https://www.youtube.com/c/xtremeExcel

or join our Telegram group.
https://t.me/letsautomate

## What is RestAssured
REST Assured is a Java library that provides a domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs.
REST Assured can be used easily in combination with testing frameworks such as JUnit and TestNG. 

## Eclipse project setup
> to be updated

## Installation

 > Download and install Mockoon(https://mockoon.com) to mock services and practice extensively.

 > Create New environment in mockoon using mockoon_environment.json in the project.

 > Download and install Postman (chrome plugin or standalone)
 


# GET

## Initial tests using RestAssured & TestNG
 > Open Test_requests.java in src/test/java/raw_tests_with_testng

--------------------------------------------------------------------------------
 ### Test 1. given()  get()  then()  statusCode(int)

```java
public void test1() {
	given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(200);
	}
```

### Test 2. given()  get()  then()  statusCode(Matcher)
> Note :  Use this import for equalsTo : import static org.hamcrest.CoreMatchers.equalsTo;
```java
public void test2() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(equalTo(200));
	}
```
--------------------------------------------------------------------------------

### Test 3. given()  get()  then() assertThat() statusCode()

```java
	public void test3() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().assertThat().statusCode(200);
	}
```
--------------------------------------------------------------------------------

### Test 4. given()  get()  then() assertThat() body(Matcher<?> matcher, Matcher<?>...additionalMatchers)

> Note : Use this import for containsString : import static org.hamcrest.CoreMatchers.containsString;
```java
	public void test4() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation"));
	}
```
> we can pass multiple matchers comma separated.


### Test 5. given()  get()  then() assertThat()  body(String path, ResponseAwareMatcher<R> responseAwareMatcher) 
```java
	public void test5() {
		//for java v1.7 or less we use ResponseAwareMatchers
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("lname",
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});
		
		//for java v1.8 we use lambda expressions
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("lname",
				response -> equalTo("girdher"));
	}
```

### Test 6. given()  get()  then() assertThat()  body(List<Argument> arguments, ResponseAwareMatcher<R> responseAwareMatcher) 
```java
```


### Test 7. given()  get()  then() assertThat() body(String path, List<Argument> arguments, ResponseAwareMatcher<R> responseAwareMatcher)
```java
```

### Test 8. given()  get()  then() assertThat()  body(List<Argument> arguments, org.hamcrest.Matcher matcher, Object... additionalKeyMatcherPairs)
```java
```


### Test 9. given()  get()  then() assertThat() body(String path, List<Argument> arguments,org.hamcrest.Matcher matcher, Object... additionalKeyMatcherPairs)
```java
```


### Test 10. given()  get()  then() assertThat() body(String path, org.hamcrest.Matcher matcher, Object... additionalKeyMatcherPairs)
```java
```



--------------------------------------------------------------------------------


### Test 11. given()  get()  then() assertThat() body()  containsString()  and()
```java
public void test11() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation")).and().body(containsString("Successful"));
	}
```

### Test 12. given()  get()  then() assertThat() content


e.g.  get("/something").then().assertThat().body(containsString("OK")).and().body(containsString("something else"));
 
is that same as: 
 get("/something").then().assertThat().body(containsString("OK")).body(containsString("something else"));
 




appendRoot()
content()
contentType()
cookie()
cookies()
defaultParser()
detachRoot()
extract()
header()
headers()
log()
noRoot()
noRootPath()
parser()
root()
spec()
specification()
statusCode()
statusLine()
using()










## What is RequestSpecBuilder




Source : https://github.com/executeautomation/restassured

