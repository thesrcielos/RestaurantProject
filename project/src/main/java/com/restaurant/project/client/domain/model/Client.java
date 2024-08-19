package com.restaurant.project.client.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
