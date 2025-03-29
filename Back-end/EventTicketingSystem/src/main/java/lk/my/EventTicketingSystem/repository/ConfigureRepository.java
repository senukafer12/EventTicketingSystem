package lk.my.EventTicketingSystem.repository;

import lk.my.EventTicketingSystem.model.Configure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigureRepository extends JpaRepository<Configure, Long> {
}
