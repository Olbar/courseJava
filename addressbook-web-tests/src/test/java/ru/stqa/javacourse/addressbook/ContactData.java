package ru.stqa.javacourse.addressbook;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String companyName;
    private final String companyAddress;
    private final String homeNumber;
    private final String mobileNumber;
    private final String workNumber;
    private final String fax;
    private final String mail1;
    private final String mail2;
    private final String mail3;
    private final String site;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String companyName, String companyAddress, String homeNumber, String mobileNumber, String workNumber, String fax, String mail1, String mail2, String mail3, String site) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.fax = fax;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.mail3 = mail3;
        this.site = site;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getFax() {
        return fax;
    }

    public String getMail1() {
        return mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public String getMail3() {
        return mail3;
    }

    public String getSite() {
        return site;
    }
}
