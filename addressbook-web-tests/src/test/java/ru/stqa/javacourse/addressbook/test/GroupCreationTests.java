package ru.stqa.javacourse.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        int before =app.getContactHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("test", null, "test2"));
        int after =app.getContactHelper().getGroupCount();
        Assert.assertEquals(after, before+1);
    }

}
