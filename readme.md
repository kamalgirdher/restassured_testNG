What is RestAssured
REST Assured is a Java library that provides a domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs.
REST Assured can be used easily in combination with testing frameworks such as JUnit and TestNG. 



Installation
 > Download and install Mockoon(https://mockoon.com) to mock services and practice extensively.
 > Create New environment in mockoon using mockoon_environment.json in the project.
 > Download and install Postman (chrome plugin or standalone)
 



Initial tests using RestAssured & TestNG
 > Open Test_requests.java in src/test/java/raw_tests_with_testng

```java
public void test_getRequest() {
	given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(200);
	}
```




What is RequestSpecBuilder




Source : https://github.com/executeautomation/restassured

