package rest_api_23_Andris_Grindulis.helpers;

import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import rest_api_23_Andris_Grindulis.domain.Folder;
import rest_api_23_Andris_Grindulis.domain.Space;

public class TestCaseContext {
    @Setter @Getter
    private static Space space;
    @Setter @Getter
    private static Folder folder;
    @Setter @Getter
    private static Scenario scenario;

    public static void init(){
        space = null;
        folder = null;
        scenario = null;
    }
}
