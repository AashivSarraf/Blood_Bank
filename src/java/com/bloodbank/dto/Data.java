
package com.bloodbank.dto;

import java.util.Date;

public class Data {
    private int did;
    private String userName;
    private String email;
    private String phone;
    private String location;
    private String bloodGroup;
    private Date uploadDate;
    private int person;

    public Data(int did, String userName, String email, String phone, String location, String bloodGroup, Date uploadDate, int person) {
        this.did = did;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.bloodGroup = bloodGroup;
        this.uploadDate = uploadDate;
        this.person = person;
    }

    public Data(String userName, String email, String phone, String location, String bloodGroup, int person) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.bloodGroup = bloodGroup;
        this.person = person;
    }
    
    public Data(String userName, String email, String phone, String location, String bloodGroup, Date uploadDate) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.bloodGroup = bloodGroup;
        this.uploadDate = uploadDate;
    }
    
    

    public Data(String userName, String email, String phone, String location, String bloodGroup) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.bloodGroup = bloodGroup;
    }
    
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
    
}
