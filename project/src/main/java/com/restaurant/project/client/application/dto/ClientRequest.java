package com.restaurant.project.client.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    @Size(min = 5, max = 50, message = "name length must be between 5 and 50")
    @NotNull(message = "name cant be null")
    private String name;
    @NotNull(message = "email cant be null")
    @Email(message = "email doesn't have the right structure")
    private String email;
    @Pattern(regexp = "\\d+", message = "Phone number must contain just numbers")
    private String phoneNumber;
}
