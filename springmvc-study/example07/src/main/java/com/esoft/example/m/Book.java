package com.esoft.example.m;

import java.io.Serializable;

/**
 * Created by query on 2017/6/18.
 */
public class Book implements Serializable {

    private String name;

    private String author;

    private double price;

    private String image;

    public Book(String name, String author, String image ,double price) {
        this.name = name;
        this.author = author;
        this.image = image;
        this.price = price;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
