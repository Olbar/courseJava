package ru.stqa.javacourse.rest.tests;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite

    public void init() {
        RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
    }


    public void skipIfNotFixed(int issueId)  {
        if (isIssueOpen(issueId)) {
            System.out.println("Ignored because of issue " + issueId);
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private boolean isIssueOpen(int issueId)  {
        String json = RestAssured.get("http://demo.bugify.com/api/issues/" + issueId + ".json").asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        int state = issues.getAsJsonArray().iterator().next().getAsJsonObject().get("state").getAsInt();
        if (state == 3) {
            return false;
        } else {
            return true;
        }
    }
}
