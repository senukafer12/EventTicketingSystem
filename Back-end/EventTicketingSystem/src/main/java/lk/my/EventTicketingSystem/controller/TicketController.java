package lk.my.EventTicketingSystem.controller;

import lk.my.EventTicketingSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/start-vendor")
    public ResponseEntity<String> startVendor(@RequestParam int vendorId, @RequestParam int releaseInterval) throws InterruptedException {
        ticketService.startVendorReleasingTickets(vendorId, releaseInterval);
        return ResponseEntity.ok("Vendor " + vendorId + " started releasing tickets.");
    }

    @PostMapping("/start-customer")
    public ResponseEntity<String> startCustomer(@RequestParam int customerId, @RequestParam int purchaseInterval) throws InterruptedException {
        ticketService.startCustomerPurchasingTickets(customerId, purchaseInterval);
        return ResponseEntity.ok("Customer " + customerId + " started purchasing tickets.");
    }
}
