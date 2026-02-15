package com.nipun.supportdesk.model.dto;

import com.nipun.supportdesk.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private Role role;
}