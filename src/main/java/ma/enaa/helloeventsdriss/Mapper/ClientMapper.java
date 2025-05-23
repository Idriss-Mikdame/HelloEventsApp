package ma.enaa.helloeventsdriss.Mapper;

import ma.enaa.helloeventsdriss.DTO.ClientDto;
import ma.enaa.helloeventsdriss.entities.Client;
import org.mapstruct.Mapper;

import javax.swing.*;

@Mapper
public interface ClientMapper {
    ClientDto toClientDto(Client client);
    Client toClinetentity(ClientDto clientDto);
}
