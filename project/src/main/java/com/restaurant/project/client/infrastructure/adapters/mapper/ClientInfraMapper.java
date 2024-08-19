package com.restaurant.project.client.infrastructure.adapters.mapper;

import com.restaurant.project.client.domain.model.Client;
import com.restaurant.project.client.infrastructure.adapters.entity.ClientEntity;

public interface ClientInfraMapper {
    Client toClient(ClientEntity client);
    ClientEntity toClientEntity(Client client);
}
