package rest_api_23_Andris_Grindulis.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static rest_api_23_Andris_Grindulis.constants.ProjectConstants.API_TOKEN;

public class ClickUpClient {
    private static RequestSpecification clickupSpec(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN);
                //.queryParam("token", API_TOKEN);
    }
    public static Response getSpaceInfo(String space_id){
        return RestAssured
                .given(clickupSpec())
                .when()
                .get("https://api.clickup.com/api/v2/space/" + space_id)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createFolder(String name, String space_id){
        return RestAssured
                .given(clickupSpec())
                .queryParam("name", name)
                .queryParam("idSpace", space_id)
                .post("https://api.clickup.com/api/v2/space/" + space_id + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

}
