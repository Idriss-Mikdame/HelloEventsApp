package ma.enaa.helloeventsdriss.controller;

import ma.enaa.helloeventsdriss.DTO.EvenementDto;
import ma.enaa.helloeventsdriss.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/events")
public class EventController {


    public EventServices eventService;

    public EventController(EventServices eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EvenementDto> addEvent(@RequestBody EvenementDto evenementDto) {
        EvenementDto savedEvent = eventService.ajouterEvenement(evenementDto);
        return ResponseEntity.ok(savedEvent);
    }

        @GetMapping
        public List<EvenementDto> getAllEvents() {

        return eventService.listerEvenements();
        }
        @GetMapping("/{id}")
        public EvenementDto getEventById(@PathVariable Long id) {

        return eventService.getEvenementById(id);
        }

        @PutMapping("/{id}")
        public EvenementDto updateEvent(@PathVariable Long id ,@RequestBody EvenementDto eventDto) {

            return eventService.updateEvenement(id, eventDto);
        }

        @DeleteMapping("{id}")
       public void deleteEvent(@PathVariable Long id) {
            eventService.deleteEvenement(id);
        }

}
