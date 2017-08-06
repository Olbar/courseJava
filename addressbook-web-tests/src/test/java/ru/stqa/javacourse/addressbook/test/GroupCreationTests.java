package ru.stqa.javacourse.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData("test", null, "test2");
        app.group().create(group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getId(),g2.getId());
        after.sort(byId);
        before.sort(byId);
        Assert.assertEquals(before,after);
    }

}
