package ru.stqa.javacourse.addressbook.model;

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

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", workNumber='" + workNumber + '\'' +
                ", mail1='" + mail1 + '\'' +
                ", mail2='" + mail2 + '\'' +
                ", mail3='" + mail3 + '\'' +
                '}';
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (companyAddress != null ? !companyAddress.equals(that.companyAddress) : that.companyAddress != null)
            return false;
        if (homeNumber != null ? !homeNumber.equals(that.homeNumber) : that.homeNumber != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(that.mobileNumber) : that.mobileNumber != null) return false;
        if (workNumber != null ? !workNumber.equals(that.workNumber) : that.workNumber != null) return false;
        if (mail1 != null ? !mail1.equals(that.mail1) : that.mail1 != null) return false;
        if (mail2 != null ? !mail2.equals(that.mail2) : that.mail2 != null) return false;
        return mail3 != null ? mail3.equals(that.mail3) : that.mail3 == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (homeNumber != null ? homeNumber.hashCode() : 0);
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (workNumber != null ? workNumber.hashCode() : 0);
        result = 31 * result + (mail1 != null ? mail1.hashCode() : 0);
        result = 31 * result + (mail2 != null ? mail2.hashCode() : 0);
        result = 31 * result + (mail3 != null ? mail3.hashCode() : 0);
        return result;
    }

    public String getSite() {
        return site;
    }
}
