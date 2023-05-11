/*
package rest_api_23_Andris_Grindulis.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import rest_api_23_Andris_Grindulis.helpers.TestCaseContext;

public class Hooks {
    @Before
    public void beforeHook(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO HAS STARTED");
    }
    @After
    public void afterHook(){
        deleteList(TestCaseContext.getList().getId());
        updateSpaceInfo(SPACE_NAME, TestCaseContext.getBoard().getId());
        System.out.println("SCENARIO HAS ENDED");
    }
}
*/
