
package com.example.travelbackend.init;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import com.example.travelbackend.repository.UserRepository;
import com.example.travelbackend.repository.DestinationRepository;
import com.example.travelbackend.model.User;
import com.example.travelbackend.model.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired private UserRepository userRepository;
    @Autowired private DestinationRepository destinationRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().isEmpty()){
            User admin = new User("admin", passwordEncoder.encode("adminpass"), "ADMIN");
            userRepository.save(admin);
            System.out.println("Created admin user: admin / adminpass");
        }
        if(destinationRepository.count() == 0){
            Destination d1 = new Destination();
            d1.setName("Sample Destination");
            d1.setRegion("Global");
            d1.setShortDescription("Demo destination");
            d1.setLongDescription("This is a sample destination created on startup.");
            d1.setPrice(999);
            d1.setDuration(3);
            d1.setRating(4.5);
            d1.setImages(Arrays.asList("/assets/images/real/dest-1.svg"));
            destinationRepository.save(d1);
            System.out.println("Inserted sample destination.");
        }
    }
}
