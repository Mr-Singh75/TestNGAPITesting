package ApiTesting.DemoTest;

import org.testng.annotations.AfterClass;
import org.hamcrest.core.IsEqual;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class TestCases {

	ResponseSpecification res;
	
	@BeforeClass
	public void setSpecification() {
		res = RestAssured.expect();
		res.statusLine("HTTP/1.1 200 OK");
		res.contentType(ContentType.JSON);
		ExtentReportManager.createReport();
		
		
	}
	
	@Test(description="Fetching User Details",testName="testFetchUser")
	public void testFetchUsers() {
		ExtentReportManager.test = ExtentReportManager.getTest();
		//ExtentReportManager.test = ExtentReportManager.reports.startTest("testFetchUser","Fetching User Details");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "GET");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/users?page=2");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "Page");
		RestAssured.baseURI = "https://reqres.in";
		given().when().get("https://reqres.in/api/users?page=2").then().spec(res).assertThat().body("page", IsEqual.equalTo(2));
		
		
		
		
	}
	
	@Test(description="Delayed Response",testName="testDelayedResponse")
	public void testDelayedResponse() {
		ExtentReportManager.test = ExtentReportManager.getTest();
//		ExtentReportManager.test = ExtentReportManager.reports.startTest("testDelayedResponse","Delayed Response");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "GET");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/users?delay=3");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "Total");
		RestAssured.baseURI = "https://reqres.in";
		given().when().get("https://reqres.in/api/users?delay=3").then().spec(res).assertThat().body("total", IsEqual.equalTo(12));
		
	}
	
	@Test(description="Fetching Single User",testName="testFetchSingleUser")
	public void testFetchSingleUser() {
		ExtentReportManager.test = ExtentReportManager.getTest();
//		ExtentReportManager.test = ExtentReportManager.reports.startTest("testFetchSingleUser","Fetching Single User");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "GET");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/users/2");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "ID and FIRST NAME");
		RestAssured.baseURI = "https://reqres.in";
		given().when().get("https://reqres.in/api/users/2").then().spec(res).assertThat().body("data['id']", IsEqual.equalTo(2));
		given().when().get("https://reqres.in/api/users/2").then().spec(res).assertThat().body("data['first_name']", IsEqual.equalTo("Janet"));
		
	}
	
	@Test(description="Fetching List Of User Details",testName="testFetchListOfUsers")
	public void testFetchListOfUsers()
	{
		ExtentReportManager.test = ExtentReportManager.getTest();
//		ExtentReportManager.test = ExtentReportManager.reports.startTest("testFetchListOfUsers","Fetching List Of User Details");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "GET");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/unknown");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "total");
		RestAssured.baseURI = "https://reqres.in";
		given().when().get("https://reqres.in/api/unknown").then().spec(res).assertThat().body("total", IsEqual.equalTo(12));
		
		
	}
	
	

	
	@Test(description="Creating the user",testName="testCreateUser") 
	public void testCreateUser() {
		ExtentReportManager.test = ExtentReportManager.getTest();
//		ExtentReportManager.test = ExtentReportManager.reports.startTest("testCreateUser","Creating the user");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "POST");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/users");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "Name");
		RestAssured.baseURI = "https://reqres.in";
		HashMap<String,String> params = new HashMap<>();
		params.put("name", "morpheus");
		params.put("job", "Tech Lead");
		given().when().contentType("application/json").body(params).post("https://reqres.in/api/users").then().assertThat().body("name", IsEqual.equalTo("morpheus"));
		
		
		
	}
	
	
	
	@Test(description="Registering the new user",testName="testRegisterUser")
	public void testRegisterUser() {
		ExtentReportManager.test = ExtentReportManager.getTest();
//		ExtentReportManager.test = ExtentReportManager.reports.startTest("testRegisterUser","Registering the new user");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "POST");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/register");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "ID");
		RestAssured.baseURI = "https://reqres.in";
		HashMap<String,String> params = new HashMap<>();
		params.put("email", "eve.holt@reqres.in");
		params.put("password", "pistol");
		given().when().contentType("application/json").body(params).post("https://reqres.in/api/register").then().assertThat().body("id", IsEqual.equalTo(4));
	}
	
	@Test(description="Login user Response",testName="testLoginUser")
	public void testLoginUser() {
		ExtentReportManager.test = ExtentReportManager.getTest();
//		ExtentReportManager.test = ExtentReportManager.reports.startTest("testLoginUser","Login user Response");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "POST");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/login");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "Token");
		RestAssured.baseURI = "https://reqres.in";
		HashMap<String,String> params = new HashMap<>();
		params.put("email", "eve.holt@reqres.in");
		params.put("password","cityslicka");
		given().when().contentType("application/json").body(params).post("https://reqres.in/api/login").then().assertThat().body("token", IsEqual.equalTo("QpwL5tke4Pnpja7X4"));
	}
	
	@Test(description="Unsuccesful Register Users",testName="testUnsuccesfulRegisterUser")
	public void testUnsuccesfulRegisterUser() {
		ExtentReportManager.test = ExtentReportManager.getTest();
//		ExtentReportManager.test = ExtentReportManager.reports.startTest("testUnsuccesfulRegisterUser","Unsuccesful Register Users");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "POST");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/register");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "Error Message");
		RestAssured.baseURI = "https://reqres.in";
		HashMap<String,String> params = new HashMap<>();
		params.put("email", "eve.holt@reqres.in");
		
		given().when().contentType("application/json").body(params).post("https://reqres.in/api/register").then().assertThat().body("error", IsEqual.equalTo("Missing password"));
	}
	@Test(description="Login of Unsuccesful User",testName="testLoginUnseccusfulUser")
	public void testLoginUnseccusfulUser() {
		ExtentReportManager.test = ExtentReportManager.getTest();
//		ExtentReportManager.test = ExtentReportManager.reports.startTest("testLoginUnseccusfulUser","Login of Unsuccesful User");
		ExtentReportManager.test.log(LogStatus.INFO, "Specifying Base URI", "https://reqres.in");
		ExtentReportManager.test.log(LogStatus.INFO, "API Call", "POST");
		ExtentReportManager.test.log(LogStatus.INFO, "Resource Route", "https://reqres.in/api/login");
		ExtentReportManager.test.log(LogStatus.INFO, "Value Compared", "Error Message");
		RestAssured.baseURI = "https://reqres.in";
		HashMap<String,String> params = new HashMap<>();
		params.put("email", "peter@klaven");
		
		given().when().contentType("application/json").body(params).post("https://reqres.in/api/login").then().assertThat().body("error", IsEqual.equalTo("Missing password"));
	}
	
	@AfterClass
	public void closeReport() {
		ExtentReportManager.reports.flush();
	}
	
}
