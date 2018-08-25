package tmssandbox.api;

import static com.jayway.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class CategoriesGetDetailsCatalouge {
	@Test
	public void Test_01_getDetails() {

		// Declare variable as per Acceptance Criteria or as per expected
		// results
		String expectedName = "Carbon credits";
		Boolean expectedCanRelist = true;
		String expectedPromotionsContent = "2x larger image";
		
		//Save API base url in a string, makes it easy to maintain and increases code readability 
		String apiBaseUrl ="https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json";

		// Make a call to the API under test and capture the response
		System.out.println("\n ******  Startring tmsandbox API Test  ******");
		System.out.println("\n--Calling API - https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false ");
		Response resp = given().parameter("catalogue","false").when().get(apiBaseUrl);

		// Validate if the Http response code 200 was received or not
		Assert.assertEquals(resp.getStatusCode(), 200);
		System.out.println("\n--http response code validation passed , http 200 response code recieved");

		// Validate if the response received is in JSON format or not
		// Extract the value of Name element in a string and Validate the first
		// acceptance criteria i.e. "Name=Carbon credits"
		String actualName = resp.then().contentType(ContentType.JSON).extract().path("Name");
		Assert.assertEquals(actualName, expectedName);
		System.out.println("\n--First Acceptance Criteria");
		System.out.println("--Name assertion passed, received expected Name value = " + actualName);

		// Extract the value of CanRelist element and validate the
		// second acceptance criteria i.e. "CanRelist=true"
		Boolean actualCanRelist = resp.then().extract().path("CanRelist");
		Assert.assertEquals(actualCanRelist, expectedCanRelist);
		System.out.println("\n--Second Acceptance Criteria");
		System.out.println("--CanRelist assertion passed, recevied expected CanRelist value = " + actualCanRelist);

		// Extract the value of Promotions element in a string and validate the
		// third acceptance criteria i.e. "Promotions"
		String actualPromotionsContent = resp.then().extract().path("Promotions[1].Description");
		Assert.assertTrue(actualPromotionsContent.contains(expectedPromotionsContent));
		System.out.println("\n--Third Acceptance Criteria");
		System.out.println("--promotions assertion passed, recevied value = \"" + actualPromotionsContent + "\" contains expected value -\""
				+ expectedPromotionsContent+"\"");
	}

}
