package com.nipun.supportdesk.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audit_logs")
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;

    @Column(columnDefinition = "TEXT")
    private String details;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User performedBy;

    private LocalDateTime timestamp = LocalDateTime.now();
}