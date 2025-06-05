package ma.enaa.helloeventsdriss.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String motdepasse;
    @Enumerated(EnumType.STRING)
    public Role role;


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String nom;
        private String email;
        private String motdepasse;
        private Role role;


        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder motdepasse(String motdepasse) {
            this.motdepasse = motdepasse;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Utilisateur build() {
            return new Utilisateur(id, nom, email, motdepasse, role);
        }
    }
    public Utilisateur(Long id, String nom, String email, String motdepasse, Role role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motdepasse = motdepasse;
        this.role = role;
    }

    public Utilisateur() {

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return motdepasse;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
