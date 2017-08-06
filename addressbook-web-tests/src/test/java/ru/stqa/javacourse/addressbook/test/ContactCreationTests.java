package ru.stqa.javacourse.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        List<ContactData> before =app.contact().list();
        ContactData contact =new ContactData().withFirstname("Ivan").withLastname("Ivanov").withCompanyAddress("Lenina 6");
        app.contact().create(contact);
        List<ContactData> after =app.contact().list();
        Assert.assertEquals(after.size(), before.size()+1);

        Comparator<? super ContactData> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        after.sort(byId);
        before.sort(byId);
        before.add(contact);
        Assert.assertEquals(before,after);
    }

}
