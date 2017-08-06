package ru.stqa.javacourse.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData("Ivan", "Ivanovich", "Ivanov", "ivanov-i", "user", "roga i kopita", "Lenin st 5", "4565656", "+79213454545", "3454545", "3454546", "ivanov-i@mail.ru", "ivanov-i@gmail.com", "ivanov-i@yandex.ru", "no"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before =app.contact().list();
        int index = before.size()-1;
        app.contact().delete(index);
        List<ContactData> after =app.contact().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);
    }

}
