package ma.enaa.helloeventsdriss.Mapper;

import ma.enaa.helloeventsdriss.DTO.ReservationDto;
import ma.enaa.helloeventsdriss.entities.Reservation;
import org.mapstruct.Mapper;

@Mapper
public interface ReservationMapper {
    ReservationDto reservationToDto(Reservation reservation);
    Reservation dtoToReservation(ReservationDto dto);
}
