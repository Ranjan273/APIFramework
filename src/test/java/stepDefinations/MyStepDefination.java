package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.PoJoOne;
import pojo.PoJoTwoLocation;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class MyStepDefination extends Utils {
    RequestSpecification myrequest;
    ResponseSpecification res;
    Response myResponse;
    TestDataBuild data=new TestDataBuild();
    @Given("Add Place Payload with {string}{string}{string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {

        /*res=new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();*/

        myrequest=given()
                .spec(requestSpecification()).body(data.addPlacePayload(name,language,address));

    }
    @When("User calls {string} with post http Request")
    public void user_calls_with_post_http_request(String string) {

        res=new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        myResponse=myrequest.when()
                .post("/maps/api/place/add/json")
                .then()
                .spec(res)
                .extract().response();

    }
    @Then("the API call is success with staus code {int}")
    public void the_api_call_is_success_with_staus_code(Integer int1) {
        assertEquals(myResponse.getStatusCode(),200);

    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        String resp=myResponse.asString();
        JsonPath jp=new JsonPath(resp);
        assertEquals(jp.get(keyValue).toString(),Expectedvalue);

    }


}
