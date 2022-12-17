package org.q2.entities;

import javax.persistence.*;

@Entity
public class Book extends Publication {

    @Basic
    private String author;


    public Book(String title, String author, int quantity, double price) {
        super(title, quantity, price);
        this.author = author;
    }

    public Book() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //create method orderCopies to order copies of the book
    public void orderCopies(int copies) {
        setCopies(getCopies() + copies);
    }



    @Override
    public String toString() {
        return "Title: " + getTitle() + " , Author: " + getAuthor() + " , Quantity to sell: " + getCopies();
    }



}
