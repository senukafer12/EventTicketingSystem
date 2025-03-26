package lk.my.EventTicketingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int customerId;
    private int ticketsPurchased;

    public Customer() {

    }

    public Customer(int customerId) {
        this.customerId = customerId;
        this.ticketsPurchased = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTicketsPurchased() {
        return ticketsPurchased;
    }

    public void setTicketsPurchased(int ticketsPurchased) {
        this.ticketsPurchased = ticketsPurchased;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", ticketsPurchased=" + ticketsPurchased +
                '}';
    }
}
