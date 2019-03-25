package com.esoft.example.m;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by query on 2017/6/17.
 */
public class User implements Serializable {

    private String username;

    private String password;

    private MultipartFile image;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
