package ma.enaa.helloeventsdriss.repository;

import ma.enaa.helloeventsdriss.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationsRepository extends CrudRepository<Reservation, Integer> {
}
