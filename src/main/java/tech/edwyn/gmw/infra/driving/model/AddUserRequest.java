package tech.edwyn.gmw.infra.driving.model;

import lombok.Data;

@Data
public class AddUserRequest {
    private String firstName;
    private String lastName;
    private String email;
}
