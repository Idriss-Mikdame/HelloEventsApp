package ma.enaa.helloeventsdriss.repository;

import ma.enaa.helloeventsdriss.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinetRepository extends JpaRepository<Client,Long> {
}
