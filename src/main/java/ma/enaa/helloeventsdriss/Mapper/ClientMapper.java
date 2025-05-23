package ma.enaa.helloeventsdriss.Mapper;

import ma.enaa.helloeventsdriss.DTO.ClientDto;
import ma.enaa.helloeventsdriss.entities.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface ClientMapper {
    ClientDto toClientDto(Client client);
    Client toClinetentity(ClientDto clientDto);
}
