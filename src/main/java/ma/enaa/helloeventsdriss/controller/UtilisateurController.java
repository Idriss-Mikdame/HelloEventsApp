package ma.enaa.helloeventsdriss.controller;

import ma.enaa.helloeventsdriss.DTO.UtilisateurDto;
import ma.enaa.helloeventsdriss.services.UtilisateurServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Utilisateur")
public class UtilisateurController {

    private final UtilisateurServices utilisateurServices;

    public UtilisateurController(UtilisateurServices utilisateurServices) {
        this.utilisateurServices = utilisateurServices;
    }

    @PostMapping
    private ResponseEntity<UtilisateurDto> ajoute(@RequestBody UtilisateurDto utilisateurDto){
        UtilisateurDto ajoute = utilisateurServices.ajoute(utilisateurDto);
        return ResponseEntity.ok(ajoute);
    }

    @GetMapping
    private ResponseEntity<UtilisateurDto> afficher(){
        List<UtilisateurDto> utilisateurDtoList = utilisateurServices.affiche();
        return ResponseEntity.ok((UtilisateurDto) utilisateurDtoList);
    }

    @GetMapping("{id}")
    private ResponseEntity<UtilisateurDto> afficheparid(@PathVariable Long id){

        UtilisateurDto utilisateurDto   = utilisateurServices.afficheParId(id);
        return ResponseEntity.ok(utilisateurDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UtilisateurDto> supprimer(@PathVariable Long id){
       utilisateurServices.supprime(id);
       return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<UtilisateurDto> modifier(@PathVariable Long id,@RequestBody UtilisateurDto utilisateurDto){
        UtilisateurDto modifier = utilisateurServices.mofifier(id,utilisateurDto);

        return ResponseEntity.ok(modifier);

    }
}
