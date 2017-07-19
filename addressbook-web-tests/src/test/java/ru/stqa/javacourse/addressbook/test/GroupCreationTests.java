package ru.stqa.javacourse.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test", "test1", "test2"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
