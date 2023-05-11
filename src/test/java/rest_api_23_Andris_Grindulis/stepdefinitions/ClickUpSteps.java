package rest_api_23_Andris_Grindulis.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import rest_api_23_Andris_Grindulis.domain.Folder;
import rest_api_23_Andris_Grindulis.domain.Space;
import rest_api_23_Andris_Grindulis.helpers.TestCaseContext;

import static rest_api_23_Andris_Grindulis.clients.ClickUpClient.createFolder;
import static rest_api_23_Andris_Grindulis.clients.ClickUpClient.getSpaceInfo;
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
    }

    @When("I create {string} in space")
    public void iCreateInSpace(String folderName) {
        Response response = createFolder(folderName, TestCaseContext.getSpace().getId());
        Folder folder = response.as(Folder.class);
        TestCaseContext.setFolder(folder);
        Assertions.assertThat(folder.getName())
                .as("We check that folder was created correcly")
                .isEqualTo(folderName);
        TestCaseContext.getScenario().log(folder.getId());
    }

    @And("I create {string} in the folder")
    public void iCreateInTheFolder(String listName) {
    }

    @And("I verify that {string} name is correct")
    public void iVerifyThatNameIsCorrect(String listName) {
    }

    @And("I create {string} in the new list")
    public void iCreateInTheNewList(String taskName) {
    }

    @Then("I verify that {string} name is correct and remove it")
    public void iVerifyThatNameIsCorrectAndRemoveIt(String taskName) {
    }
}
