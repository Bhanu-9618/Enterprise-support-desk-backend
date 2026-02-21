package com.nipun.supportdesk.service.impl;

import com.nipun.supportdesk.enums.Status;
import com.nipun.supportdesk.model.dto.TicketRequestDTO;
import com.nipun.supportdesk.model.dto.TicketResponseDTO;
import com.nipun.supportdesk.model.entity.AuditLog;
import com.nipun.supportdesk.model.entity.Ticket;
import com.nipun.supportdesk.repository.AuditLogRepository;
import com.nipun.supportdesk.repository.TicketRepository;
import com.nipun.supportdesk.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final AuditLogRepository auditLogRepository;

    @Override
    @Transactional
    public TicketResponseDTO createTicket(TicketRequestDTO requestDTO) {
        Ticket ticket = new Ticket();
        ticket.setTitle(requestDTO.getTitle());
        ticket.setDescription(requestDTO.getDescription());
        ticket.setStatus(Status.OPEN);

        Ticket savedTicket = ticketRepository.save(ticket);

        AuditLog log = new AuditLog();
        log.setAction("Ticket Created: " + savedTicket.getTitle());
        log.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(log);

        return mapToResponseDTO(savedTicket);
    }

    @Override
    public List<TicketResponseDTO> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketResponseDTO> getMyTickets(String username) {
        return ticketRepository.findByCreatedByUsername(username)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TicketResponseDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
        return mapToResponseDTO(ticket);
    }

    @Override
    @Transactional
    public TicketResponseDTO updateTicketStatus(Long id, Status newStatus) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));

        Status oldStatus = ticket.getStatus();
        ticket.setStatus(newStatus);

        Ticket updatedTicket = ticketRepository.save(ticket);

        AuditLog log = new AuditLog();
        log.setAction("Ticket #" + id + " Status Updated: " + oldStatus + " -> " + newStatus);
        log.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(log);

        return mapToResponseDTO(updatedTicket);
    }

    private TicketResponseDTO mapToResponseDTO(Ticket ticket) {
        TicketResponseDTO responseDTO = new TicketResponseDTO();
        responseDTO.setId(ticket.getId());
        responseDTO.setTitle(ticket.getTitle());
        responseDTO.setDescription(ticket.getDescription());
        responseDTO.setStatus(ticket.getStatus());
        responseDTO.setCreatedAt(ticket.getCreatedAt());

        return responseDTO;
    }
}