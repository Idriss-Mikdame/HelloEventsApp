package ma.enaa.helloeventsdriss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloEventsDrissApplication {

    public static void main(String[] args) {

        SpringApplication.run(HelloEventsDrissApplication.class, args);
    }
//    @Bean
//    CommandLineRunner start(AccountServices accountServices){
//        return args -> {
//            accountServices.addNewRoles(new Roles("ADMIN"));
//            accountServices.addNewRoles(new Roles("USER"));
//
//            accountServices.addNewUser(new Utilisateur("idriss@gmail.com","1234",new ArrayList<>()));
//            accountServices.addNewUser(new Utilisateur("ali@gmail.com","1234",new ArrayList<>()));
//            accountServices.addNewUser(new Utilisateur("youness@gmail.com","1234",new ArrayList<>()));
//            accountServices.addNewUser(new Utilisateur("adbo@gmail.com","1234",new ArrayList<>()));
//
//        };
//    }

}
