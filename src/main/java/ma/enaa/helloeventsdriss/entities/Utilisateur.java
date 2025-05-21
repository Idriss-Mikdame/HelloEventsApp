package ma.enaa.helloeventsdriss.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String motdepasse;


}
