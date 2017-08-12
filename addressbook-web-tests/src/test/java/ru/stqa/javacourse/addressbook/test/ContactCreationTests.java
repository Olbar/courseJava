package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;
import ru.stqa.javacourse.addressbook.model.GroupData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        File photo = new File("src/test/resources/cat.jpg");
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().withFirstname(split[0])
                    .withLastname(split[1]).withCompanyAddress(split[2])
                    .withHomeNumber(split[3]).withMobileNumber(split[4]).withWorkNumber(split[5]).withPhoto(photo)});
            line = reader.readLine();
        }
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