package org.q2.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DiscMag extends Magazine  {

    @Basic
    private double price;

    public DiscMag(String title, int copies, double price) {
        super(title, copies, price);
        this.price = price;
    }

    public DiscMag() {
        super();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getSalePrice() {
        return price * 0.7;
    }

    @Override
    public String toString() {
        return "DiscMag{" + "price=" + price + '}';
    }

}
