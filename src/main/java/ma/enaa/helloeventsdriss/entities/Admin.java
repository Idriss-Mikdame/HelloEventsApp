package ma.enaa.helloeventsdriss.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Admin extends Utilisateur{


    public Admin() {
        this.setRole(Role.ADMIN);
    }
    @OneToMany(mappedBy = "admin" , cascade = CascadeType.ALL)
    private List<Evenement> evenements;










    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    public Admin(Long id, String nom, String email, String motdepasse, Role role, List<Evenement> evenements) {
        super(id, nom, email, motdepasse, role);
        this.evenements = evenements;
    }

    public Admin(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
