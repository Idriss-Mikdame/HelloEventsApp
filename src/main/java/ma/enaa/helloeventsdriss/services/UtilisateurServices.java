package ma.enaa.helloeventsdriss.services;

import ma.enaa.helloeventsdriss.DTO.UtilisateurDto;
import ma.enaa.helloeventsdriss.entities.Role;
import ma.enaa.helloeventsdriss.entities.Utilisateur;
import ma.enaa.helloeventsdriss.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServices {

    private final UtilisateurRepository utilisateurRepository;
    public UtilisateurServices(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    private UtilisateurDto toDto(Utilisateur utilisateur) {
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setEmail(utilisateur.getEmail());
        utilisateurDto.setMotdepasse(utilisateur.getMotdepasse());
        return utilisateurDto;
    }
    private Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setMotdepasse(utilisateurDto.getMotdepasse());
        //utilisateur.setRole(utilisateurDto.setRole(Role.CLIENT));
        return utilisateur;
    }
    public UtilisateurDto ajoute(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = toEntity(utilisateurDto);
        Utilisateur add = utilisateurRepository.save(utilisateur);
        return toDto(add);
    }
    public List<UtilisateurDto> affiche(){
        List<Utilisateur> utilisateurslist =utilisateurRepository.findAll();

        return utilisateurslist.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UtilisateurDto afficheParId(Long id){
        Optional<Utilisateur> utilisateur = this.utilisateurRepository.findById(id);
        return toDto(utilisateur.get());

    }

    public void supprime(Long id){
        this.utilisateurRepository.deleteById(id);
    }

    public UtilisateurDto mofifier(Long id ,UtilisateurDto utilisateurDto){
            Utilisateur utilisateur = utilisateurRepository.findById(id).get();
            utilisateur.setEmail(utilisateurDto.getEmail());
            utilisateur.setMotdepasse(utilisateur.getMotdepasse());
            utilisateur.setRole(utilisateurDto.getRole());
            Utilisateur utilisateurModifier = utilisateurRepository.save(utilisateur);
            return toDto(utilisateurModifier);
    }
}
