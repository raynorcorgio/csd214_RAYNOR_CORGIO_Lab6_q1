package org.q2.entities;

import javax.persistence.*;

@Entity
public abstract class Publication implements SaleableItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    private String title;

    @Basic
    private int copies;

    @Basic
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publication(String title, int copies, double price) {
        //constructors
        this.title = title;
        this.copies = copies;
        this.price = price;
    }

    public Publication(String title, String publisher) {
        this.title = title;
    }

    public Publication() {

    }

    public String getTitle() {
        //getters and setters
        return title;
    }

    //create sellCopy method to sell a copy of the publication
    public void sellCopy() {
        copies--;
    }

    public void setTitle(String title) {
        //getters and setters
        this.title = title;
    }





    public int getCopies() {
        //getters and setters
        return copies;
    }

    public void setCopies(int copies) {
        //getters and setters
        this.copies = copies;
    }

    public double getPrice() {
        //getters and setters
        return price;
    }

    public void setPrice(double price) {
        //getters and setters
        this.price = price;
    }

    @Override
    public String toString() {
        //modify this to return a string that contains all the properties of the vehicle
        return "Publication{" + "title=" + title + ", copies=" + copies + ", price=" + price + '}';
    }

    @Override
    public double getSalePrice() {
        //implement this method to return the price of the publication
        return price;
    }



}
