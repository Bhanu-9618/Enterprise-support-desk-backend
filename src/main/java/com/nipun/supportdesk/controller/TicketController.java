package com.nipun.supportdesk.controller;

import com.nipun.supportdesk.enums.Status;
import com.nipun.supportdesk.model.dto.TicketRequestDTO;
import com.nipun.supportdesk.model.dto.TicketResponseDTO;
import com.nipun.supportdesk.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/create-ticket")
    public ResponseEntity<TicketResponseDTO> createTicket(@RequestBody TicketRequestDTO request) {
        return ResponseEntity.ok(ticketService.createTicket(request));
    }

    @GetMapping("/get-all-tickets")
    public ResponseEntity<List<TicketResponseDTO>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TicketResponseDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam Status status) {
        return ResponseEntity.ok(ticketService.updateTicketStatus(id, status));
    }
}