package lk.my.EventTicketingSystem.service;

import lk.my.EventTicketingSystem.model.Configure;
import lk.my.EventTicketingSystem.model.Ticket;
import lk.my.EventTicketingSystem.repository.ConfigureRepository;
import lk.my.EventTicketingSystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ConfigureRepository configureRepository;
    private int ticketsAvailable;

    public void configureSystem(Configure configure) {
        ticketsAvailable = configure.getTotalTickets(); //save configuration logic if necessary.
    }

    @Async
    public void startVendorReleasingTickets(int vendorId, int releaseInterval) throws InterruptedException {
        while (ticketsAvailable > 0) {
            Ticket ticket = new Ticket(vendorId, 0); // vendor releases ticket
            ticketRepository.save(ticket);
            ticketsAvailable--;
            Thread.sleep(releaseInterval*1000);
            System.out.println("Vendor " + vendorId + " released a ticket.");
        }
    }

    @Async
    public void startCustomerPurchasingTickets(int customerId, int purchaseInterval) throws InterruptedException {
        while (ticketsAvailable > 0) {
            Ticket ticket = ticketRepository.findFirstByOrderByIdAsc(); // Customer buys first ticket
            if (ticket != null) {
                ticket.setCustomerId(customerId);
                ticketRepository.save(ticket);
                ticketsAvailable--;
                System.out.println("Customer " + customerId + " purchased ticket: " + ticket);
            }
            Thread.sleep(purchaseInterval * 1000);
        }
    }
}
