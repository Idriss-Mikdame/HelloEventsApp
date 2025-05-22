package ma.enaa.helloeventsdriss.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Client extends Utilisateur{

    public Client(){
        this.setRole(Role.CLIENT);
    }
    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Reservation> reservations;


    public Client(Long id, String nom, String email, String motdepasse, Role role, List<Reservation> reservations) {
        super(id, nom, email, motdepasse, role);
        this.reservations = reservations;
    }

    public Client(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
