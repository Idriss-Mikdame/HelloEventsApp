package ma.enaa.helloeventsdriss.Security;

import ch.qos.logback.core.encoder.Encoder;
import org.mapstruct.control.MappingControl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//       UserDetails user = User
//               .withUsername("idriss")
//               .password(bCryptPasswordEncoder().encode("12345"))
//               .authorities("admin").build();
//       manager.createUser(user);
//       return manager;
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeHttpRequests().anyRequest().authenticated();
        return http.build();
    }

}
