package ru.stqa.javacourse.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;

public class ContactData {
    private  int id;
    @Expose
    private  String firstname;
    private  String middlename;
    @Expose
    private  String lastname;
    @Expose
    private  String nickname;
    private  String title;
    private  String companyName;
    @Expose
    private  String companyAddress;
    @Expose
    private  String homeNumber;
    @Expose
    private  String mobileNumber;
    @Expose
    private  String workNumber;
    @Expose
    private  String fax;
    private  String email;
    private  String email2;
    private  String email3;
    private  String site;
    private String allPhones;
    private String allMailes;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    private File photo;


    public String getAllMails() {
        return allMailes;
    }

    public ContactData withAllMails(String allMails) {
        this.allMailes = allMails;
        return this;
    }



    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ContactData withCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
        return this;
    }

    public ContactData withHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
        return this;
    }

    public ContactData withMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public ContactData withWorkNumber(String workNumber) {
        this.workNumber = workNumber;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withMail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withMail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withMail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withSite(String site) {
        this.site = site;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        return companyAddress != null ? companyAddress.equals(that.companyAddress) : that.companyAddress == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                '}';
    }

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getSite() {
        return site;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
}
