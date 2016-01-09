package com.epam.api.cp.entities;


import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name="users")
@XmlRootElement
public class User implements Serializable {


    private static final Logger logger = Logger.getLogger("User");
    private static final long serialVersionUID = -6642827527318525644L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    //private byte[] userAvatar;
    @Column(name = "email")
    private String email;

    @Column(name = "skype_name")
    private String skypeName;

    @Column(name = "phone_numbers")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "guest")
    private boolean guest;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public byte[] getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(byte[] userAvatar) {
        this.userAvatar = userAvatar;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkypeName() {
        return skypeName;
    }

    public void setSkypeName(String skypeName) {
        this.skypeName = skypeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            String encodedPassword = Base64.encode(digest);
            this.password = encodedPassword;
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE,"Password creation failed",e);
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.SEVERE, "Password creation failed", e);
            throw new RuntimeException(e);
        }
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }
}
