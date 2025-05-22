package ma.enaa.helloeventsdriss.services;

//import ma.enaa.helloeventsdriss.entities.Role;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServices {

//    private final UtilisateurRepository utilisateurRepository;
//    public UtilisateurServices(UtilisateurRepository utilisateurRepository) {
//        this.utilisateurRepository = utilisateurRepository;
//    }
//    private UtilisateurDto toDto(Utilisateur utilisateur) {
//        UtilisateurDto utilisateurDto = new UtilisateurDto();
//        utilisateurDto.setEmail(utilisateur.getEmail());
//        utilisateurDto.setMotdepasse(utilisateur.getMotdepasse());
//        return utilisateurDto;
//    }
//    private Utilisateur toEntity(UtilisateurDto utilisateurDto) {
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setEmail(utilisateurDto.getEmail());
//        utilisateur.setMotdepasse(utilisateurDto.getMotdepasse());
////        utilisateur.setRole(utilisateurDto.setRole(Role.CLIENT));
//        return utilisateur;
//    }
//    public UtilisateurDto ajoute(UtilisateurDto utilisateurDto){
//        Utilisateur utilisateur = toEntity(utilisateurDto);
////        Role role = utilisateurDto.getRole() == Role.ADMIN ? Role.ADMIN : Role.CLIENT;
////        utilisateur.setRole(role);
//        Utilisateur add = utilisateurRepository.save(utilisateur);
//        return toDto(add);
//    }
//    public List<UtilisateurDto> affiche(){
//        List<Utilisateur> utilisateurslist =utilisateurRepository.findAll();
//
//        return utilisateurslist.stream()
//                .map(this::toDto)
//                .collect(Collectors.toList());
//    }
//
//    public UtilisateurDto afficheParId(Long id){
//        Optional<Utilisateur> utilisateur = this.utilisateurRepository.findById(id);
//        return toDto(utilisateur.get());
//
//    }
//
//    public void supprime(Long id){
//        this.utilisateurRepository.deleteById(id);
//    }
//
//    public UtilisateurDto mofifier(Long id ,UtilisateurDto utilisateurDto){
//            Utilisateur utilisateur = utilisateurRepository.findById(id).get();
//            utilisateur.setEmail(utilisateurDto.getEmail());
//            utilisateur.setMotdepasse(utilisateur.getMotdepasse());
////            utilisateur.setRole(utilisateurDto.getRole());
//            Utilisateur utilisateurModifier = utilisateurRepository.save(utilisateur);
//            return toDto(utilisateurModifier);
//    }
}
