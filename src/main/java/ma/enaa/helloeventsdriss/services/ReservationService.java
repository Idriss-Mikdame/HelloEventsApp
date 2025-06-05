package ma.enaa.helloeventsdriss.services;

import jakarta.transaction.Transactional;

import ma.enaa.helloeventsdriss.DTO.ReservationDto;
import ma.enaa.helloeventsdriss.Mapper.ReservationMapper;
import ma.enaa.helloeventsdriss.entities.Client;
import ma.enaa.helloeventsdriss.entities.Reservation;
import ma.enaa.helloeventsdriss.repository.ClinetRepository;
import ma.enaa.helloeventsdriss.repository.EvenementRepository;
import ma.enaa.helloeventsdriss.repository.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ReservationService {

    private final ReservationsRepository reservationsRepository;
    private final ClinetRepository clientRepository;
    private final EvenementRepository evenementRepository;
    private ReservationMapper reservationMapper;

    public ReservationService(ReservationsRepository reservationsRepository, ClinetRepository clientRepository, EvenementRepository evenementRepository, ReservationMapper reservationMapper) {
        this.reservationsRepository = reservationsRepository;
        this.clientRepository = clientRepository;
        this.evenementRepository = evenementRepository;
        this.reservationMapper = reservationMapper;
    }
    @Transactional
    public ReservationDto addReservation(ReservationDto reservationDto) {
        var client = clientRepository.findById(reservationDto.getIduser())
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID : " + reservationDto.getIduser()));

        var event = evenementRepository.findById(reservationDto.getIdevent())
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec l'ID : " + reservationDto.getIdevent()));



        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setEvenement(event);
        reservation.setReseravtionDate(new Date());
        reservation.setReservationNumber(reservationDto.getReservationNumber());

        var res = reservationsRepository.save(reservation);

        return new ReservationDto(
                res.getIdreservation(),
                res.getClient().getId(),
                res.getEvenement().getId());
    }






    public List<ReservationDto> getAllReservations() {
        return reservationsRepository.findAll().stream()
                .map(reservationMapper::reservationToDto)
                .collect(Collectors.toList());
    }

    public ReservationDto getReservationById(Long id) {
        return reservationsRepository.findById(id)
                .map(res->reservationMapper.reservationToDto(res))
                .orElseThrow(()->new RuntimeException(""));
    }
    public void deleteReservationById(Long id) {
        reservationsRepository.deleteById(id);
    }
}