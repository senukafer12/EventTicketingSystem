package lk.my.EventTicketingSystem.repository;

import lk.my.EventTicketingSystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findFirstByOrderByIdAsc();
}
