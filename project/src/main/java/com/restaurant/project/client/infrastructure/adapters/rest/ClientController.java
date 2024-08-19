package com.restaurant.project.client.infrastructure.adapters.rest;

import com.restaurant.project.client.application.dto.ClientRequest;
import com.restaurant.project.client.application.dto.ClientResponse;
import com.restaurant.project.client.application.usecases.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse registerClient(@RequestBody @Valid ClientRequest clientRequest){
        return clientService.createClient(clientRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse updateClient(@PathVariable Long id, @RequestBody @Valid ClientRequest request){
        return clientService.updateClient(id,request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClientById(Long id){
        clientService.deleteClientById(id);
    }


}
