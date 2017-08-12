package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts(){
        File photo = new File("src/test/resources/cat.jpg");
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new ContactData().withFirstname("Ivan 1").withLastname("Ivanov 1").withCompanyAddress("Lenin street 6")
                .withHomeNumber("2323453").withMobileNumber("4354653").withWorkNumber("899-23434").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withFirstname("Ivan 2").withLastname("Ivanov 2").withCompanyAddress("Lenin street 7")
                .withHomeNumber("2334523").withMobileNumber("43345353").withWorkNumber("899-234334").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withFirstname("Ivan 3").withLastname("Ivanov 3").withCompanyAddress("Lenin street 8")
                .withHomeNumber("2324423").withMobileNumber("43254353").withWorkNumber("899-234").withPhoto(photo)});
        return list.iterator();
    }




    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertEquals(app.contact().count(), before.size() + 1);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}