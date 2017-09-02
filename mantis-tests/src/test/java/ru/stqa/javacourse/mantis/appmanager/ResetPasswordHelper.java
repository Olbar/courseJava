package ru.stqa.javacourse.mantis.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResetPasswordHelper extends HelperBase{

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }


    public void goToManagePage(){
        wd.findElement(By.cssSelector("a.manage-menu-link")).click();
    }

    public void goToManageOfUsersPage(){
        wd.findElement(By.linkText("Управление пользователями")).click();
    }

    public void chooseUser(){
        WebElement webElement = wd.findElements(By.cssSelector("table tr td a:not([href='manage_user_edit_page.php?user_id=1'])")).get(0);
        webElement.click();
    }
    public void resetPassword(){
        wd.findElement(By.cssSelector("form[id='manage-user-reset-form'] input.button")).click();
    }

    public String getUserName(){
        String username = wd.findElement(By.cssSelector("input#edit-username")).getAttribute("value");
        return username;
    }

    public String getMail(){
        String email = wd.findElement(By.cssSelector("input#email-field")).getAttribute("value");
        return email;
    }

    public void changePasswordFinish(String resetPasswordLink, String newpassword){
            wd.get(resetPasswordLink);
            type(By.name("password"),newpassword);
            type(By.name("password_confirm"),newpassword);
            click(By.cssSelector("input[type='submit']"));
    }
}
