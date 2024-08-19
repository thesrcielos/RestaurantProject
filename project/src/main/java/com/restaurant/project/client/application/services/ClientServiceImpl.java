package com.restaurant.project.client.application.services;

import com.restaurant.project.client.application.dto.ClientRequest;
import com.restaurant.project.client.application.dto.ClientResponse;
import com.restaurant.project.client.application.mapper.ClientAppMapper;
import com.restaurant.project.client.application.usecases.ClientService;
import com.restaurant.project.client.domain.model.Client;
import com.restaurant.project.client.domain.ports.ClientPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientPersistencePort clientPersistencePort;
    private final ClientAppMapper clientMapper;
    @Override
    public ClientResponse createClient(ClientRequest request) {
        Client client = clientMapper.requestToClient(request);
        if (userExistsByEmail(client.getEmail())){
            throw new RuntimeException("User with email "+client.getEmail()+" already exists");
        }
        Client savedClient = clientPersistencePort.save(client);
        return clientMapper.toClientResponse(savedClient);
    }

    @Override
    public ClientResponse updateClient(Long id, ClientRequest request) {
        Client client = clientMapper.requestToClient(request);
        client.setId(id);
        return clientMapper.toClientResponse(clientPersistencePort.update(client));
    }

    @Override
    public ClientResponse getClientById(Long id) {
        return clientMapper.toClientResponse(clientPersistencePort.getById(id));
    }

    @Override
    public void deleteClientById(Long id) {
        clientPersistencePort.deleteById(id);
    }

    @Override
    public boolean userExistsByEmail(String email) {
        return clientPersistencePort.existsByEmail(email);
    }
}
