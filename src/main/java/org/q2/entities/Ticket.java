package org.q2.entities;

import javax.persistence.*;

@Entity
public class Ticket implements SaleableItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    private String name;

    @Basic
    private double price;

    @Basic
    private String event;

    private static int ticketCount = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ticket(String name, double price) {
        this.name = name;
        this.price = price;
//        this.event = event;
        ticketCount++;
    }

    public Ticket() {

    }

//    public Ticket(String name, double price, String event) {
//        //constructors
//        this.name = name;
//        this.price = price;
//        this.event = event;
//    }

//    public Ticket(int ticketNum, double ticketPrice) {
//        //constructors
//
//    }

    public String getName() {
        //getters and setters
        return name;
    }

    public void setName(String name) {
        //getters and setters
        this.name = name;
    }

    public double getPrice() {
        //getters and setters
        return price;
    }

    public void setPrice(double price) {
        //getters and setters
        this.price = price;
    }

    public String getEvent() {
        //getters and setters
        return event;
    }

    public void setEvent(String event) {
        //getters and setters
        this.event = event;
    }

    @Override
    public String toString() {
        //override toString method to return a modified string that contains all the properties of the ticket
        return "Ticket{" + "name=" + name + ", price=" + price + ", event=" + event + '}';
    }

    @Override
    public double getSalePrice() {
        //implement the getSalePrice method to return the price of the ticket
        return price;
    }

}
