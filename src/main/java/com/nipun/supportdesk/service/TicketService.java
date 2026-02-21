package com.nipun.supportdesk.service;

import com.nipun.supportdesk.enums.Status;
import com.nipun.supportdesk.model.dto.TicketRequestDTO;
import com.nipun.supportdesk.model.dto.TicketResponseDTO;
import java.util.List;

public interface TicketService {

    TicketResponseDTO createTicket(TicketRequestDTO requestDTO);
    List<TicketResponseDTO> getAllTickets();
    List<TicketResponseDTO> getMyTickets(String username);
    TicketResponseDTO getTicketById(Long id);
    TicketResponseDTO updateTicketStatus(Long id, Status newStatus);
}