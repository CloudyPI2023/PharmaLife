package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class PharmaLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmaLifeApplication.class, args);
    }

}
