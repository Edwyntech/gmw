package tech.edwyn.gmw.infra.driving.model;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class AddUserRequest {
    @NotEmpty(message = "Firstname may not be empty")
    private String firstName;
    @NotEmpty(message = "Lastname may not be empty")
    private String lastName;
    @NotEmpty(message = "Email may not be empty")
    private String email;
}
