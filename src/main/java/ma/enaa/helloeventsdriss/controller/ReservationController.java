package ma.enaa.helloeventsdriss.controller;

import ma.enaa.helloeventsdriss.DTO.ClientDto;
import ma.enaa.helloeventsdriss.DTO.ReservationDto;
import ma.enaa.helloeventsdriss.entities.Client;
import ma.enaa.helloeventsdriss.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    public ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationDto addReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.addReservation(reservationDto);
    }

    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return reservationService.getAllReservations();
    }
    @GetMapping("/{reservationId}")
    public ReservationDto getReservationById(@PathVariable Long reservationId) {
        return reservationService.getReservationById(reservationId);
    }
     @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
     }

}
