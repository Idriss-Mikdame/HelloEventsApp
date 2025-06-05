package ma.enaa.helloeventsdriss.Mapper;

import ma.enaa.helloeventsdriss.DTO.ReservationDto;
import ma.enaa.helloeventsdriss.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    @Mapping(source = "reservation.idreservation", target = "idreservation")
    @Mapping(source = "reservation.client.id", target = "iduser")
    @Mapping(source = "reservation.evenement.id", target = "idevent")
    ReservationDto reservationToDto(Reservation reservation);
    Reservation dtoToReservation(ReservationDto dto);

}
