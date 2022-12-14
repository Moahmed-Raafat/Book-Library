package com.example.booklibrary;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String name;
    private String author;
    private String imageUrl;
    private String information;

    private boolean isExpanded;


    public Book(int id, String name, String author, String imageUrl, String information) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.information = information;

        isExpanded=false;
    }

    public Book(String name, String author, String imageUrl, String information) {
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.information = information;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getInformation() {
        return information;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public boolean isExpanded()
    {
        return isExpanded;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
