package com.restaurant.project.client.application.mapper;

import com.restaurant.project.client.application.dto.ClientRequest;
import com.restaurant.project.client.application.dto.ClientResponse;
import com.restaurant.project.client.domain.model.Client;

public interface ClientAppMapper {
    Client requestToClient(ClientRequest clientRequest);
    ClientResponse toClientResponse(Client client);
}
