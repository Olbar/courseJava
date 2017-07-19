package ru.stqa.javacourse.addressbook.test;


import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getGroupHelper().editContact();
        app.getGroupHelper().deleteContact();
    }
}
