package ru.stqa.javacourse.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.javacourse.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getCompanyAddress());
        type(By.name("home"), contactData.getHomeNumber());
        type(By.name("mobile"), contactData.getMobileNumber());
        type(By.name("work"), contactData.getWorkNumber());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getMail1());
        type(By.name("email2"), contactData.getMail2());
        type(By.name("email3"), contactData.getMail3());
        type(By.name("homepage"), contactData.getSite());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }


    private void editContactById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"'] img[title='Edit'][alt='Edit']")).click();
    }

    public void submitContactModification() {
        click(By.cssSelector("input[value='Update']"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void modify(ContactData contact) {
       editContactById(contact.getId());
       fillContactForm(contact);
       submitContactModification();
       returnToHomePage();
    }

    public void delete(ContactData contact) {
        editContactById(contact.getId());
        deleteContact();
    }



    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.cssSelector("input[value='Delete']"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            int id =Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = element.findElement(By.cssSelector("table[id='maintable'] tr[name='entry'] td:nth-child(3)")).getText();
            String lastname = element.findElement(By.cssSelector("table[id='maintable'] tr[name='entry'] td:nth-child(2)")).getText();
            String companyAddress = element.findElement(By.cssSelector("table[id='maintable'] tr[name='entry'] td:nth-child(4)")).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withCompanyAddress(companyAddress);
            contacts.add(contact);
        }
        return contacts;
    }


}
