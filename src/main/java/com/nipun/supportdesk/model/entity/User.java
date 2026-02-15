package com.nipun.supportdesk.model.entity;

import com.nipun.supportdesk.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Column(unique = true)
    private String userName;

    @NotBlank(message = "Password is required")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
