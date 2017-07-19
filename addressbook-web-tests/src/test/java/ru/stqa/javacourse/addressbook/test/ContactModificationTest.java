package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getGroupHelper().editContact();
        app.getGroupHelper().fillContactForm(new ContactData("Ivan2", "Ivanovich2", "Ivanov2", "ivanov-i2", "user2", "roga i kopita", "Lenin st 5", "4565656", "+79213454545", "3454545", "3454546", "ivanov-i@mail.ru", "ivanov-i@gmail.com", "ivanov-i@yandex.ru", "no"));
        app.getGroupHelper().submitContactModification();
    }
}
