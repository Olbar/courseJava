package ru.stqa.javacourse.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Ivanov").withCompanyAddress("Lenina 7"));
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before =app.contact().list();
        int index=before.size()-1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId())
                .withFirstname("Ivan2").withMiddlename("Ivanovich2").withLastname("Ivanov2")
                .withCompanyAddress("Lenina 5").withNickname("Vano").withCompanyName("Roga and Copita")
                .withHomeNumber("3232").withFax("34242").withMail1("ddd@mail.ru").withMail2("eee@mail.ru")
                .withMail3("erw@mail.ru").withMobileNumber("23423432423").withWorkNumber("2342342")
                .withTitle("ROGA").withSite("www.ru");
        app.contact().modify(index, contact);
        List<ContactData> after =app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        after.sort(byId);
        before.sort(byId);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}
