package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    File photo = new File("src/test/resources/cat.jpg");

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size()==0){
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Ivanov").withCompanyAddress("Lenina 7").withPhoto(photo));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before =app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstname("Ivan2").withMiddlename("Ivanovich2").withLastname("Ivanov2")
                .withCompanyAddress("Lenina 5").withHomeNumber("234")
                .withMobileNumber("24234").withWorkNumber("3242").withPhoto(photo);
        app.goTo().homePage();
        app.contact().modify(contact);
        assertEquals(app.contact().count(), before.size());
        Contacts after =app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
