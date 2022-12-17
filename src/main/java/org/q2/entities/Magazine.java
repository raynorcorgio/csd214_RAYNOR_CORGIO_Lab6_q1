package org.q2.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Magazine extends Publication {

    @Basic
    private int orderQty;

    @Basic
    private int currIssue;



    public Magazine(String title,int copies,double price, int orderQty, int currIssue) {
        super(title,copies,price);
        this.orderQty = orderQty;
        this.currIssue = currIssue;
    }

    public Magazine(String title, int copies, double price) {
            super(title, copies, price);
    }

    public Magazine() {

    }

    //create method adjustQty to adjust the order quantity
    public void adjustQty(int orderQty) {
        this.orderQty = orderQty;
    }

    //create method recvNewIssue
    public void recvNewIssue(int currIssue) {
        this.currIssue = currIssue;
    }



    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public int getCurrIssue() {
        return currIssue;
    }

    public void setCurrIssue(int currIssue) {
        this.currIssue = currIssue;
    }



    @Override
    public String toString() {
        return "Magazine{" + "orderQty=" + orderQty + ", currIssue=" + currIssue + '}';
    }

}
