package ru.stqa.javacourse.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact =app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllMails(), equalTo(mergeMails(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
       return Arrays.asList(contact.getHomeNumber(), contact.getMobileNumber(), contact.getWorkNumber())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }
    private String mergeMails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTest::cleanedMail)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
}
    public static String cleanedMail(String email){
        return email.replaceAll("\\s","").replaceAll("[()]","");
    }
}
