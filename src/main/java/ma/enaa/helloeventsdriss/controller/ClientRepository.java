package ma.enaa.helloeventsdriss.controller;

import ma.enaa.helloeventsdriss.DTO.ClientDto;
import ma.enaa.helloeventsdriss.entities.Client;
import ma.enaa.helloeventsdriss.services.ClientServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/clients")
public class ClientRepository {

    public ClientServices clientServices;
    public ClientRepository(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @GetMapping
    public List<ClientDto> getAllClients() {

        return clientServices.getAllClients();
    }
    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        return clientServices.saveClient(clientDto);

    }

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable("id") Long id) {

        return clientServices.getClientById(id);
    }

    @PutMapping("{id}")
    public ClientDto updateClient(@PathVariable  Long id,@RequestBody ClientDto clientDto) {
        return clientServices.updateClient(id, clientDto);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable  Long id) {
        clientServices.deleteClient(id);
    }
}
