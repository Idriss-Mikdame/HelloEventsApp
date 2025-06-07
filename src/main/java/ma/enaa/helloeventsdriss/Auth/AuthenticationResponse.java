package ma.enaa.helloeventsdriss.Auth;

public class AuthenticationResponse {
    private String token;
    private Long id;
    private String nom;
    private String email;
    private String role;

    public AuthenticationResponse(String token, Long id, String nom, String email, String role) {
        this.token = token;
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.role = role;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setToken(String token) {
        this.token = token;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Builder manuel
    public static class Builder {
        private String token;
        private Long id;
        private String nom;
        private String email;
        private String role;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(token, id, nom, email, role);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
