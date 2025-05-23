package ma.enaa.helloeventsdriss.DTO;

import lombok.Value;
import ma.enaa.helloeventsdriss.entities.Reservation;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Reservation}
 */
public class ReservationDto   {
    private  Long idreservation;
    private  Date reseravtionDate;
    private  int reservationNumber;
    private Long iduser;
    private Long idevent;

    public ReservationDto() {
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

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public Long getIdevent() {
        return idevent;
    }

    public void setIdevent(Long idevent) {
        this.idevent = idevent;
    }
}