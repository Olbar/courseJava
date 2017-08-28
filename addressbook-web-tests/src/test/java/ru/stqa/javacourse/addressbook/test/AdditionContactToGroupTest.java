package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;
import ru.stqa.javacourse.addressbook.model.GroupData;
import ru.stqa.javacourse.addressbook.model.Groups;

import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AdditionContactToGroupTest extends TestBase {

    File photo = new File("src/test/resources/cat.jpg");


    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        if(app.db().contacts().size()==0){
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Petr").withLastname("Ivanov").withCompanyAddress("Lenina 7").withPhoto(photo));
        }
    }

    @Test
    public void testContactAdditionToGroup() {
        Groups groupsBefore= app.db().contacts().iterator().next().getGroups();
        Contacts before =app.db().contacts();
        GroupData groupAdd=app.db().groups().iterator().next();

        app.goTo().homePage();
        app.contact().addContactToGroup(before, groupAdd.getId());
        
        Groups groupsAfter=app.db().contacts().iterator().next().getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore.withAdded(groupAdd)));
        verifyContactListInUI();
    }



}
