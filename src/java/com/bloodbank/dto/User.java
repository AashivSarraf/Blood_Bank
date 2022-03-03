
package com.bloodbank.dto;

import java.util.Date;

public class User {
    private int userid;
    private String userName;
    private String email;
    private String password;
    private Date registerDate;
    private int otp;
    private boolean verifyStatus;

    public User(int userid, String userName, String email, String password, Date registerDate, int otp, boolean verifyStatus) {
        this.userid = userid;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
        this.otp = otp;
        this.verifyStatus = verifyStatus;
    }

    public User() {
        
    }

    public User(int userid, String userName, String email) {
        this.userid=userid;
        this.userName=userName;
        this.email=email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public boolean isVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(boolean verifyStatus) {
        this.verifyStatus = verifyStatus;
    }
    
    
    
}
