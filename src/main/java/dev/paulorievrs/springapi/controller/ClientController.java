package dev.paulorievrs.springapi.controller;

import dev.paulorievrs.springapi.model.Client;
import dev.paulorievrs.springapi.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping("/{id}")
    public Optional<Client> find(@PathVariable Long id) {
        return clientRepository.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        Client clientToUpdate = clientRepository.findById(id).get();
        clientToUpdate.setName(client.getName());
        return new ResponseEntity<>(clientRepository.save(clientToUpdate), HttpStatus.OK);
    }


}
