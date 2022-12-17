package org.q2.entities;

import javax.persistence.*;

@Entity
public class CashTill implements SaleableItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CashTill(double price) {
        //constructors
        this.price = price;
    }

    public CashTill() {

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
        //override toString method to return a modified string that contains all the properties of the ticket
        return "CashTill{" + "price=" + price + '}';
    }

    @Override
    public double getSalePrice() {
        //implement the getSalePrice method to return the price of the ticket
        return price;
    }

}
