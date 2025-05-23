package ma.enaa.helloeventsdriss.DTO;

import lombok.Value;
import ma.enaa.helloeventsdriss.entities.Client;

import java.io.Serializable;

/**
 * DTO for {@link Client}
 */

public class ClientDto  {
    Long id;
    String nom;
    String email;
    String motdepasse;

    public ClientDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
}