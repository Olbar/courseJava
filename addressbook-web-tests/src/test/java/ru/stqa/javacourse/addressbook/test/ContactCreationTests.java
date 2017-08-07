package ru.stqa.javacourse.addressbook.test;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before =app.contact().all();
        ContactData contact =new ContactData().withFirstname("Ivan").withLastname("Ivanov").withCompanyAddress("Lenina 6");
        app.contact().create(contact);
        Contacts after =app.contact().all();
        assertEquals(after.size(), before.size()+1);
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

}
