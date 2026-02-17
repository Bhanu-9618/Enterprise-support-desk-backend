package com.nipun.supportdesk.repository;

import com.nipun.supportdesk.enums.Status;
import com.nipun.supportdesk.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCreatedByUsername(String username);
    List<Ticket> findByStatus(Status status);
}