package ma.enaa.helloeventsdriss.Auth;

import io.jsonwebtoken.Jwts;
import ma.enaa.helloeventsdriss.Config.JwtServices;
import ma.enaa.helloeventsdriss.entities.Role;
import ma.enaa.helloeventsdriss.entities.Utilisateur;
import ma.enaa.helloeventsdriss.repository.UtilisateurRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutehnticateServices {
    private final UtilisateurRepository repo;
    private final PasswordEncoder encoder;
    private final JwtServices jwtServices;
    private final AuthenticationManager authenticationManager;
    public AutehnticateServices(UtilisateurRepository repo, PasswordEncoder encoder, JwtServices jwtServices, AuthenticationManager authenticationManager) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtServices = jwtServices;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse register(RegisterRequest registerRequest) {
        if (registerRequest.getRole() == null) {
            throw new IllegalArgumentException("Le rôle est obligatoire");
        }

        var user = Utilisateur.builder()
                .nom(registerRequest.getNom())
                .email(registerRequest.getEmail())
                .motdepasse(encoder.encode(registerRequest.getMotdepasse()))
                .role(registerRequest.getRole())
                .build();

        repo.save(user);

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getMotdepasse())
                .roles(user.getRole().name()) // maintenant, on est sûr que ce n'est pas null
                .build();

        var JwtToken = jwtServices.generateToken(userDetails);

        return AuthenticationResponse.builder()
                .token(JwtToken)
                .build();
    }
    public AuthenticationResponse Autehnticated(AutehticationRequest registerRequest) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            registerRequest.getEmail()
                            , registerRequest.getMotdepasse()
                    )
            );
        var user = repo.findByEmail(registerRequest.getEmail())
                .orElseThrow();
        var JwtToken = jwtServices.generateToken(user);
        return AuthenticationResponse.builder()
                .token(JwtToken)
                .build();
    }
}
