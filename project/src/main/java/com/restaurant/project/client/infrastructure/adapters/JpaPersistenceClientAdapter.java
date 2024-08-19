package com.restaurant.project.client.infrastructure.adapters;

import com.restaurant.project.client.domain.model.Client;
import com.restaurant.project.client.domain.ports.ClientPersistencePort;
import com.restaurant.project.client.infrastructure.adapters.entity.ClientEntity;
import com.restaurant.project.client.infrastructure.adapters.mapper.ClientInfraMapper;
import com.restaurant.project.client.infrastructure.adapters.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaPersistenceClientAdapter implements ClientPersistencePort {

    private final ClientRepository clientRepository;
    private final ClientInfraMapper clientMapper;


    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = clientMapper.toClientEntity(client);
        clientRepository.save(clientEntity);
        return clientMapper.toClient(clientEntity);
    }

    @Override
    public Client update(Client client) {
        Long id = client.getId();
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        clientEntity.setEmail(client.getEmail());
        clientEntity.setName(client.getName());
        clientEntity.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(clientEntity);
        return clientMapper.toClient(clientEntity);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getById(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return clientMapper.toClient(clientEntity);
    }

    @Override
    public Client getByEmail(String email) {
        ClientEntity clientEntity = clientRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
        return clientMapper.toClient(clientEntity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return clientRepository.existsByEmail(email);
    }

}
