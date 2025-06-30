package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.ApiUtil;
import java.util.List;
import static org.junit.Assert.*;

public class ApiSteps {

    private static ThreadLocal<Response> response = new ThreadLocal<>();

    @When("I send GET request to {string}")
    public void iSendGetRequestTo(String url) {
        response.set(ApiUtil.getRequest(url));
    }

    @Then("Response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.get().getStatusCode());
    }

    @Then("Response should contain {string}")
    public void responseShouldContain(String expectedText) {
        assertTrue(response.get().getBody().asString().contains(expectedText));
        System.out.println(response.get().getBody().asString());
    }

    @And("Response should contain brands:")
    public void responseShouldContainBrands(DataTable dataTable) {
        List<String> expectedBrands = dataTable.asList();
        List<String> actualBrands = response.get().jsonPath().getList("brands.brand");

        System.out.println("Actual brands: "+actualBrands);
        for (String brand : expectedBrands) {
            assertTrue("Missing brand: " + brand, actualBrands.contains(brand));
        }

    }
}

