package com.bloodbank.config;

import com.bloodbank.model.User;
import com.bloodbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        // Create admin user if not exists
        if (userRepository.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEmail("admin@bloodbank.com");
            admin.setRole("ADMIN");
            admin.setFullName("System Administrator");
            admin.setPhone("1234567890");
            userRepository.save(admin);
            System.out.println("Admin user created successfully");
        }
        
        // Create staff user if not exists
        if (userRepository.findByUsername("staff") == null) {
            User staff = new User();
            staff.setUsername("staff");
            staff.setPassword(passwordEncoder.encode("staff123"));
            staff.setEmail("staff@bloodbank.com");
            staff.setRole("STAFF");
            staff.setFullName("Hospital Staff");
            staff.setPhone("9876543210");
            userRepository.save(staff);
            System.out.println("Staff user created successfully");
        }
        
        // Create donor user if not exists
        if (userRepository.findByUsername("donor") == null) {
            User donor = new User();
            donor.setUsername("donor");
            donor.setPassword(passwordEncoder.encode("donor123"));
            donor.setEmail("donor@example.com");
            donor.setRole("DONOR");
            donor.setFullName("John Doe");
            donor.setPhone("5551234567");
            userRepository.save(donor);
            System.out.println("Donor user created successfully");
        }
    }
}