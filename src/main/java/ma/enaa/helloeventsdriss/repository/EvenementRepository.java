package ma.enaa.helloeventsdriss.repository;

import ma.enaa.helloeventsdriss.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
}
