package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size()==0) {
            app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Ivanov").withCompanyAddress("Lenina 7"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before =app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstname("Ivan2").withMiddlename("Ivanovich2").withLastname("Ivanov2")
                .withCompanyAddress("Lenina 5").withHomeNumber("234")
                .withMobileNumber("24234").withWorkNumber("3242");
        app.contact().modify(contact);
        assertEquals(app.contact().count(), before.size());
        Contacts after =app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact)));
    }


}
