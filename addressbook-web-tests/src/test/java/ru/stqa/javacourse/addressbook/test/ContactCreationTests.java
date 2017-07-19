package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.initContactCreation();
        app.fillContactForm(new ContactData("Ivan", "Ivanovich", "Ivanov", "ivanov-i", "user", "roga i kopita", "Lenin st 5", "4565656", "+79213454545", "3454545", "3454546", "ivanov-i@mail.ru", "ivanov-i@gmail.com", "ivanov-i@yandex.ru", "no"));
        app.submitContactCreation();
    }

}
