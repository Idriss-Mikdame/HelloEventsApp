package ma.enaa.helloeventsdriss.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
public class AutehnticationController {

    private final AutehnticateServices autehnticateServices;

    public AutehnticationController(AutehnticateServices autehnticateServices) {
        this.autehnticateServices = autehnticateServices;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> Register(@RequestBody RegisterRequest registerRequest){
    return ResponseEntity.ok(autehnticateServices.register(registerRequest));

    }

    @PostMapping("/Authentication")
    public ResponseEntity<AuthenticationResponse> Autehntication(@RequestBody AutehticationRequest registerRequest){

        return ResponseEntity.ok(autehnticateServices.Autehnticated(registerRequest));

    }
}
