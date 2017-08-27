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


public class ContactDeletionFromGroupTest extends TestBase {

    File photo = new File("src/test/resources/cat.jpg");

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups =app.db().groups();
        if(app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            app.goTo().homePage();
        }
        if(app.db().contacts().size()==0){
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Ivanov").withCompanyAddress("Lenina 7").inGroup(groups.iterator().next()).withPhoto(photo));
        }
    }

    @Test
    public void testContactDeletionFromGroup() {
        int beforeCount = app.db().groups().iterator().next().getContacts().size();
        if(beforeCount==0){
            Contacts before =app.db().contacts();
            int beforeGroups =app.db().groups().iterator().next().getId();
            app.contact().addContactToGroup(before, beforeGroups);
            beforeCount=beforeCount+1;
        }
        int beforeGroups =app.db().groups().iterator().next().getId();
        app.goTo().homePage();
        Contacts countGroupsBefore=app.db().groups().iterator().next().getContacts();
        app.contact().removeContactFromGroup(beforeCount, beforeGroups);
        Contacts countGroupsAfter=app.db().groups().iterator().next().getContacts();
        assertThat(countGroupsAfter.size(), equalTo(countGroupsBefore.size()-1));
        verifyContactListInUI();
    }


}
