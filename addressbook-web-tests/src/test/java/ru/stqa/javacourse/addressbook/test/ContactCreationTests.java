package ru.stqa.javacourse.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before =app.getContactHelper().getContactList();
        ContactData contact =new ContactData("Ivan", "Ivanovich", "Ivanov", "ivanov-i", "user", "roga i kopita", "Lenin st 5", "4565656", "+79213454545", "3454545", "3454546", "ivanov-i@mail.ru", "ivanov-i@gmail.com", "ivanov-i@yandex.ru", "no");
        app.getContactHelper().createContact(contact);
        List<ContactData> after =app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
