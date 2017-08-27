package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;
import ru.stqa.javacourse.addressbook.model.GroupData;
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
    }

    @Test
    public void testContactAdditionToGroup() {

        ContactData newContact= new ContactData().withFirstname("Petr").withLastname("Petrov")
                .withCompanyAddress("ul. Blocka 6").withPhoto(photo);
        app.goTo().homePage();
        app.contact().create(newContact);
        Contacts before =app.db().contacts();
        int beforeGroups =app.db().groups().iterator().next().getId();// получаем id группы из бд, в которую мы будем добавлять контакт.
        Contacts countGroupsBefore=app.db().groups().iterator().next().getContacts();
        app.contact().addContactToGroup(before, beforeGroups);
        Contacts countGroupsAfter=app.db().groups().iterator().next().getContacts();
        assertThat(countGroupsAfter.size()-1, equalTo(countGroupsBefore.size()));
        verifyContactListInUI();
    }



}
