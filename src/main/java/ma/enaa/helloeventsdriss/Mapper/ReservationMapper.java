package ma.enaa.helloeventsdriss.Mapper;

import ma.enaa.helloeventsdriss.DTO.ReservationDto;
import ma.enaa.helloeventsdriss.entities.Reservation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
    ReservationDto reservationToDto(Reservation reservation);
    Reservation dtoToReservation(ReservationDto dto);
}
