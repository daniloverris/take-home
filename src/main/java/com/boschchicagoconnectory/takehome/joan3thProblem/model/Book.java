package com.boschchicagoconnectory.takehome.joan3thProblem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigInteger;

public class Book {
    @Indexed
    private String title;
    private String description;
    @Id
    private BigInteger isbn;
    private String author;
    @Indexed
    private String genre;
    private Integer pages;
    private String ageRange;
    private Float price;
    private Integer qty;
    @Indexed
    private String lastName;
    @Indexed
    private String firstName;

    public Book() {}

    public Book(String title, String description, BigInteger isbn, String author, String genre, Integer pages, String ageRange, Float price, Integer qty) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.ageRange = ageRange;
        this.price = price;
        this.qty = qty;
        this.lastName = author.split(" ")[1];
        this.firstName = author.split(" ")[0];
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[Title=%s, Description=%s, ISBN=%s, Author=%s, Genre=%s, Pages=%s, AgeRange=%s, Price=%s, Qty=%s)]",
        title, description, isbn, author, genre, pages, ageRange, price, qty);
    }

}
