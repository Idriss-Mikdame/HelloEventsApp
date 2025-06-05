package ma.enaa.helloeventsdriss.Auth;

import lombok.Builder;

@Builder
public class RegisterRequest {
    private String nom;
    private String email;
    private String motdepasse;
    public RegisterRequest(String nom, String email, String motdepasse) {
        this.nom = nom;
        this.email = email;
        this.motdepasse = motdepasse;
    }

    public RegisterRequest() {
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
