package ma.enaa.helloeventsdriss.services;

import jakarta.transaction.Transactional;
import ma.enaa.helloeventsdriss.DTO.ClientDto;
import ma.enaa.helloeventsdriss.Mapper.ClientMapper;
import ma.enaa.helloeventsdriss.entities.Client;
import ma.enaa.helloeventsdriss.repository.ClinetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServices {

        private final ClinetRepository clinetRepository;
        private ClientMapper clientMapper;

    public ClientServices(ClinetRepository clinetRepository, ClientMapper clientMapper) {
        this.clinetRepository = clinetRepository;
        this.clientMapper = clientMapper;
    }
    @Transactional
    public ClientDto saveClient(ClientDto clientDto) {
        Client client = clientMapper.toClinetentity(clientDto);
        Client savedClient = clinetRepository.save(client);     // Correction de saveAll -> save
        return clientMapper.toClientDto(savedClient);           // Conversion retour DTO
    }

    public List<ClientDto> getAllClients() {
        return clinetRepository.findAll().stream()
                .map(clientMapper::toClientDto)
                .collect(Collectors.toList());

    }

    public ClientDto getClientById(Long id) {
        return clinetRepository.findById(id).map(clientMapper::toClientDto).orElse(null);
    }

   public ClientDto updateClient(Long id, ClientDto clientDto) {
        Client client =clinetRepository.findById(id).get();
        client.setNom(clientDto.getNom());
        client.setEmail(clientDto.getEmail());
        client.setMotdepasse(clientDto.getMotdepasse());
       clinetRepository.save(client);
        return clientMapper.toClientDto(client);
   }

   public void deleteClient(Long id) {
        clinetRepository.deleteById(id);
   }
}
