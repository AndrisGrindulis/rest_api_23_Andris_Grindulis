package rest_api_23_Andris_Grindulis.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.JSON;
import io.restassured.response.Response;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import rest_api_23_Andris_Grindulis.domain.Folder;
import rest_api_23_Andris_Grindulis.domain.List;
import rest_api_23_Andris_Grindulis.domain.Space;
import rest_api_23_Andris_Grindulis.domain.Task;
import rest_api_23_Andris_Grindulis.helpers.TestCaseContext;

import static rest_api_23_Andris_Grindulis.clients.ClickUpClient.*;
import static rest_api_23_Andris_Grindulis.constants.ProjectConstants.SPACE_ID;
import static rest_api_23_Andris_Grindulis.constants.ProjectConstants.SPACE_NAME;

public class ClickUpSteps {
    @Given("The space exists and contains correct info")
    public void getSpaceDataAndCheckInfo(){
        Response response = getSpaceInfo(SPACE_ID);
        Space space = response.as(Space.class);
        Assertions.assertThat(space.getId())
                .as("we assert that space id is correct")
                .isEqualTo(SPACE_ID);
        Assertions.assertThat(space.getName())
                .as("we assert that space name is correct")
                .isEqualTo(SPACE_NAME);
        TestCaseContext.setSpace(space);
    }

    @When("I create {string} in space")
    public void iCreateInSpace(String folderName) {
        JSONObject obj = new JSONObject();
        obj.put("name", folderName);
        Response resp = createFolder(obj);
        Folder folder = resp.as(Folder.class);
        Assertions.assertThat(folder.getName())
                .as("We assert that created folder name is correct")
                .isEqualTo(folderName);
        TestCaseContext.setFolder(folder);
    }

    @And("I create {string} in the folder and verify it")
    public void iCreateInTheFolderAndVerifyIt(String listName) {
        JSONObject obj = new JSONObject();
        obj.put("name", listName);
        obj.put("content", "Default content text");
        Response resp = createList(obj);
        List list = resp.as(List.class);
        Assertions.assertThat(list.getName())
                .as("List name is correct")
                .isEqualTo(listName);
//        Assertions.assertThat(list.getIdFolder())
//                .as("Folder is correct")
//                .isEqualTo(TestCaseContext.getFolder().getId());
        TestCaseContext.setList(list);
    }

    @And("I create {string} in the new list")
    public void iCreateInTheNewList(String taskName) {
        JSONObject obj = new JSONObject();
        obj.put("name", taskName);
        Response resp = createTask(obj);
        Task task = resp.as(Task.class);
        Assertions.assertThat(task.getName())
                .as("task name is correct")
                .isEqualTo(taskName);
        TestCaseContext.setTask(task);
    }

    @Then("I verify that {string} name is removed")
    public void iVerifyThatNameIsRemoved(String taskName) {
    }
}
