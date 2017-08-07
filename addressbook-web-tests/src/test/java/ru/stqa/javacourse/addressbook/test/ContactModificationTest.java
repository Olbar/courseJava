package ru.stqa.javacourse.addressbook.test;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                .withCompanyAddress("Lenina 5").withNickname("Vano").withCompanyName("Roga and Copita")
                .withHomeNumber("3232").withFax("34242").withMail1("ddd@mail.ru").withMail2("eee@mail.ru")
                .withMail3("erw@mail.ru").withMobileNumber("23423432423").withWorkNumber("2342342")
                .withTitle("ROGA").withSite("www.ru");
        app.contact().modify(contact);
        Contacts after =app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withAdded(contact)));
    }


}
