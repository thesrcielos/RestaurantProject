package com.restaurant.project.client.application.mapper;

import com.restaurant.project.annotations.Mapper;
import com.restaurant.project.client.application.dto.ClientRequest;
import com.restaurant.project.client.application.dto.ClientResponse;
import com.restaurant.project.client.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Mapper
@RequiredArgsConstructor
public class ClientAppMapperImpl implements ClientAppMapper {
    private final ModelMapper mapper;
    public ClientAppMapperImpl(){
        mapper = new ModelMapper();
    }


    @Override
    public Client requestToClient(ClientRequest clientRequest) {
        return mapper.map(clientRequest,Client.class);
    }

    @Override
    public ClientResponse toClientResponse(Client client) {
        return mapper.map(client,ClientResponse.class);
    }
}
