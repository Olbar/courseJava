package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/cat.jpg");
        ContactData contact = new ContactData().withFirstname("Ivan").withLastname("Ivanov")
                .withCompanyAddress("Lenina 6").withHomeNumber("23423")
                .withMobileNumber("3543").withWorkNumber("43543").withPhoto(photo)
                .withMail("ewrhj@mail.ru").withMail2("hh-2@mail.ru").withMail3("hsdh@jhj.ru");
        app.contact().create(contact);
        assertEquals(app.contact().count(), before.size() + 1);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}