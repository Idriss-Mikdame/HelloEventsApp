package ma.enaa.helloeventsdriss.controller;

import ma.enaa.helloeventsdriss.DTO.ClientDto;
import ma.enaa.helloeventsdriss.entities.Client;
import ma.enaa.helloeventsdriss.services.ClientServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRepository {

    public ClientServices clientServices;
    public ClientRepository(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @GetMapping("allClients")
    public List<ClientDto> getAllClients() {

        return clientServices.getAllClients();
    }
    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        return clientServices.saveClient(clientDto);

    }

    @GetMapping("/get-by-id")
    public ClientDto getClientById(@RequestParam("id") Long id) {
        return clientServices.getClientById(id);
    }

    @PutMapping
    public ClientDto updateClient(@PathVariable  Long id,@RequestBody ClientDto clientDto) {
        return clientServices.updateClient(id, clientDto);
    }

    @DeleteMapping
    public void deleteClient(@PathVariable  Long id) {
        clientServices.deleteClient(id);
    }
}
