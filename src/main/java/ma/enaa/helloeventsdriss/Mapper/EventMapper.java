package ma.enaa.helloeventsdriss.Mapper;

import jdk.jfr.Event;
import ma.enaa.helloeventsdriss.DTO.EvenementDto;
import ma.enaa.helloeventsdriss.entities.Evenement;
import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {

    EvenementDto eventToDto(Evenement event);
    Evenement dtoToEvent(EvenementDto evenementdto);

}
