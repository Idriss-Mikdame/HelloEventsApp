package ma.enaa.helloeventsdriss.Auth;

import lombok.Builder;
import ma.enaa.helloeventsdriss.entities.Role;

@Builder
public class RegisterRequest {
    private String nom;
    private String email;
    private String motdepasse;
    private Role role;

    public RegisterRequest() {
    }

    public RegisterRequest(String nom, String email, String motdepasse, Role role) {
        this.nom = nom;
        this.email = email;
        this.motdepasse = motdepasse;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
