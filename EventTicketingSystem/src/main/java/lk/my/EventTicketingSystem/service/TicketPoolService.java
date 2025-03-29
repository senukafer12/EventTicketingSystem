package lk.my.EventTicketingSystem.service;

import lk.my.EventTicketingSystem.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TicketPoolService {
    private AtomicInteger ticketCounter = new AtomicInteger(1);

    public Ticket createTicket(int vendorId) {
        return new Ticket(vendorId, 0); // ticket created by vendor
    }

    public synchronized Ticket purchaseTicket(int customerId) {
        Ticket ticket = new Ticket(0, customerId); // simulate  customer purchasing ticket
        return ticket;
    }
}
