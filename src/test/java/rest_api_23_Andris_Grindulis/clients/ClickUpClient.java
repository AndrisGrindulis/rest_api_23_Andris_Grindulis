package rest_api_23_Andris_Grindulis.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import rest_api_23_Andris_Grindulis.helpers.TestCaseContext;

import static rest_api_23_Andris_Grindulis.constants.ProjectConstants.API_TOKEN;
import static rest_api_23_Andris_Grindulis.constants.ProjectConstants.SPACE_ID;

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
    public static Response createFolder(JSONObject obj){
        return RestAssured
                .given(clickupSpec())
                .body(obj)
                .post("https://api.clickup.com/api/v2/space/" + TestCaseContext.getSpace().getId() + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createList(JSONObject obj){
        return RestAssured
                .given(clickupSpec())
                .body(obj)
                .post("https://api.clickup.com/api/v2/folder/" + TestCaseContext.getFolder().getId() + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createTask(JSONObject obj){
        return RestAssured
                .given(clickupSpec())
                .body(obj)
                .post("https://api.clickup.com/api/v2/list/" + TestCaseContext.getList().getId() + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response deleteTask(String id){
        return RestAssured
                .given(clickupSpec())
                .queryParam("custom_task_ids", "true")
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + id)
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }
    public static Response deleteList(String id){
        return RestAssured
                .given(clickupSpec())
                .when()
                .delete("https://api.clickup.com/api/v2/list/" + id)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response deleteFolder(String id){
        return RestAssured
                .given(clickupSpec())
                .when()
                .delete("https://api.clickup.com/api/v2/folder/" + id)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

}
