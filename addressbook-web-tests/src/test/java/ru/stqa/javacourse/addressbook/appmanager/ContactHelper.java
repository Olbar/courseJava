package ru.stqa.javacourse.addressbook.appmanager;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.Contacts;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.javacourse.addressbook.model.Groups;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
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
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getSite());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            if (contactData.getGroups().size() > 0) {
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups()
                        .iterator().next().getName());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }


    private void editContactById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "'] img[title='Edit'][alt='Edit']")).click();
    }

    public void submitContactModification() {
        click(By.cssSelector("input[value='Update']"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        editContactById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        editContactById(contact.getId());
        deleteContact();
        contactCache = null;
    }

    public void addContactToGroup(Contacts before, int beforeGroups) {
       selectContact(before.size() - 1);
       addToGroup(beforeGroups);
       returnToMainPage();
    }

    public void returnToMainPage() {
        click(By.partialLinkText("group page"));
    }

    public void addToGroup(int beforeGroups) {
        selectGroup(beforeGroups);
        click(By.name("add"));
    }

    private void selectGroup(int index) {
        wd.findElement(By.cssSelector("select[name='to_group'] option[value='"+index+"'")).click();
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.cssSelector("input[value='Delete']"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String companyAddress = cells.get(3).getText();
            String allPhones = cells.get(5).getText();
            String allMails = cells.get(4).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withCompanyAddress(companyAddress)
                    .withAllPhones(allPhones).withAllMails(allMails);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }


    public ContactData infoFromEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String companyAddress = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname)
                .withLastname(lastname).withCompanyAddress(companyAddress).withHomeNumber(home)
                .withMobileNumber(mobile).withWorkNumber(work).withMail(email)
                .withMail2(email2).withMail3(email3);
    }


    public void deleteContactFromGroup(Contacts before) {
        selectContact(before.size() - 1);
        click(By.name("remove"));

    }

    public void selectGroupList(int index) {
        wd.findElement(By.cssSelector("select[name='group'] option[value='"+index+"'")).click();

    }

    public void removeContactFromGroup(Contacts before, int beforeGroups) {
        selectGroupList(beforeGroups);
        deleteContactFromGroup(before);
        returnToMainPage();
    }

}
