package rest_api_23_Andris_Grindulis.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import rest_api_23_Andris_Grindulis.helpers.TestCaseContext;

import static rest_api_23_Andris_Grindulis.clients.ClickUpClient.*;

public class Hooks {
    @Before
    public void beforeHook(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO HAS STARTED");
    }
    @After
    public void afterHook(){
        deleteTask(TestCaseContext.getTask().getId());
        deleteList(TestCaseContext.getList().getId());
        deleteFolder(TestCaseContext.getFolder().getId());
        System.out.println("SCENARIO HAS ENDED");
    }
}
