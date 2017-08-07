package ru.stqa.javacourse.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Set<ContactData> before =app.contact().all();
        ContactData contact =new ContactData().withFirstname("Ivan").withLastname("Ivanov").withCompanyAddress("Lenina 6");
        app.contact().create(contact);
        Set<ContactData> after =app.contact().all();
        Assert.assertEquals(after.size(), before.size()+1);

        contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);
    }

}
