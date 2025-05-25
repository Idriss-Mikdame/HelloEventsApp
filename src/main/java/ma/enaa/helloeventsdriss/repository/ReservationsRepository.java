package ma.enaa.helloeventsdriss.repository;

import ma.enaa.helloeventsdriss.entities.Evenement;
import ma.enaa.helloeventsdriss.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ReservationsRepository extends JpaRepository<Reservation, Long> {


    int countByEvenement(Evenement event);
}
