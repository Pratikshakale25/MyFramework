package utils;

//import io.restassured.response.Response;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiUtil {

    public static Response getRequest(String url) {
        return given().relaxedHTTPSValidation().get(url);
    }

    public static Response postRequest(String url, Object body) {
        return given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body(body)
                .post(url);
    }

    // add put, delete methods as needed
}


