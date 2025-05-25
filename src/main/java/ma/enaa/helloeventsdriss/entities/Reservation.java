package ma.enaa.helloeventsdriss.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ma.enaa.helloeventsdriss.DTO.ReservationDto;

import java.util.Date;

@Entity

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idreservation;
    public Date reseravtionDate;
    public int reservationNumber;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Evenement evenement;

    public Reservation() {
    }

    public Reservation(Object o, Client client, Evenement event) {
    }


    public Long getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Long idreservation) {
        this.idreservation = idreservation;
    }

    public Date getReseravtionDate() {
        return reseravtionDate;
    }

    public void setReseravtionDate(Date reseravtionDate) {
        this.reseravtionDate = reseravtionDate;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}
