package ru.stqa.javacourse.mantis.tests;


import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.javacourse.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTest extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException, MessagingException {
        String newPassword="newpassword";
        app.session().login("administrator", "root");
        app.navigator().goToManagePage();
        app.navigator().goToManageOfUsersPage();
        app.navigator().chooseUser();
        String user = app.navigator().getUserName();
        String email = app.navigator().getMail();
        app.navigator().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String resetPasswordLink = findResetPasswordLink(mailMessages, email);

        app.navigator().changePasswordFinish(resetPasswordLink,newPassword);
        assertTrue(app.newSession().login(user,newPassword));

    }

    private String findResetPasswordLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }

}



