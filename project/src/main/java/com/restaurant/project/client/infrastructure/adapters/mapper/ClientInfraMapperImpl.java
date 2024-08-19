package com.restaurant.project.client.infrastructure.adapters.mapper;

import com.restaurant.project.annotations.Mapper;
import com.restaurant.project.client.domain.model.Client;
import com.restaurant.project.client.infrastructure.adapters.entity.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Mapper
public class ClientInfraMapperImpl implements ClientInfraMapper {

    private final ModelMapper modelMapper;
    public ClientInfraMapperImpl(){
        modelMapper = new ModelMapper();
    }

    public Client toClient(ClientEntity client){
        return modelMapper.map(client,Client.class);
    }

    public ClientEntity toClientEntity(Client client){
        return modelMapper.map(client, ClientEntity.class);
    }
}
