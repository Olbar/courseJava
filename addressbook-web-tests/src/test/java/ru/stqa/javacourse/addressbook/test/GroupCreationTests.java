package ru.stqa.javacourse.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before =app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("test", null, "test2"));
        List<GroupData> after =app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()+1);
    }

}
