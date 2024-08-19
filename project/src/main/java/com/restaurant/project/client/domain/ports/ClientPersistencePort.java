package com.restaurant.project.client.domain.ports;

import com.restaurant.project.client.domain.model.Client;

public interface ClientPersistencePort {
    Client save(Client client);
    Client update(Client client);
    void deleteById(Long id);
    Client getById(Long id);
    Client getByEmail(String email);
    boolean existsByEmail(String email);
}
