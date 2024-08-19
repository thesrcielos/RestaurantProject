package com.restaurant.project.client.application.usecases;

import com.restaurant.project.client.application.dto.ClientRequest;
import com.restaurant.project.client.application.dto.ClientResponse;

public interface ClientService {
    ClientResponse createClient(ClientRequest client);
    ClientResponse updateClient(Long id, ClientRequest request);
    ClientResponse getClientById(Long id);
    void deleteClientById(Long id);
    boolean userExistsByEmail(String email);
}
