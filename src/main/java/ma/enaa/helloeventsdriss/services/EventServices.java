package ma.enaa.helloeventsdriss.services;

import ma.enaa.helloeventsdriss.DTO.EvenementDto;
import ma.enaa.helloeventsdriss.Mapper.EventMapper;
import ma.enaa.helloeventsdriss.entities.Evenement;
import ma.enaa.helloeventsdriss.repository.EvenementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServices {

    private final EvenementRepository evenementRepository;
    private EventMapper eventMapper;
    public EventServices(EvenementRepository evenementRepository, EventMapper eventMapper) {
        this.evenementRepository = evenementRepository;
        this.eventMapper = eventMapper;
    }

    public EvenementDto ajouterEvenement(EvenementDto evenementDto) {
        return eventMapper.eventToDto(evenementRepository.save(eventMapper.dtoToEvent(evenementDto)));
    }

    public List<EvenementDto> listerEvenements() {
        return evenementRepository.findAll().stream()
                .map(eventMapper::eventToDto)
                .collect(Collectors.toList());
    }

    public EvenementDto getEvenementById(Long id) {

        return evenementRepository.findById(id)
                .stream().map(eventMapper::eventToDto)
                .findAny().orElseThrow();
    }

    public EvenementDto updateEvenement(Long id,EvenementDto evenementDto) {
        Evenement evenement = evenementRepository.findById(id).get();
        evenement.setTitre(evenementDto.getTitre());
        evenement.setDescription(evenementDto.getDescription());
        evenement.setDate(evenementDto.getDate());
        evenement.setLieu(evenementDto.getLieu());
        evenement.setCapacite(evenementDto.getCapacite());
        return eventMapper.eventToDto(evenementRepository.save(evenement));
    }

    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }
}
