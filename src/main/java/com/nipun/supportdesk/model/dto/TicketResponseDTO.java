package com.nipun.supportdesk.model.dto;

import com.nipun.supportdesk.enums.Status;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TicketResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private UserDTO createdBy;
    private UserDTO assignedTo;
    private LocalDateTime createdAt;
}