package API.APIHelpers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HelperMethods {
    private static RequestSpecification authURIPATH(String endPoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification
                .baseUri(("https://reqres.in/api")+ endPoint);
        return requestSpecification;
    }

    public static RequestSpecification preRequest(String endPoint) {
        return authURIPATH(endPoint)
                .contentType(ContentType.JSON).accept(ContentType.JSON);
    }

    public static String getJSON(String endPoint, Method method) {
        return preRequest(endPoint)
                .request(method).getBody().asPrettyString();
    }

    public  String requestWithQueryParams(String endPoint, String key, String value, Method method) {
        return preRequest(endPoint)
                .queryParam(key, value)
                .request(method).getBody().asPrettyString();
    }

    public  static  <T> Response requestWithBody(String endPoint, T body, Method method) {
        return preRequest(endPoint)
                .body(body)
                .request(method);
    }


}
