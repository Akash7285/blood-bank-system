package com.bloodbank.controller;

import com.bloodbank.model.Donor;
import com.bloodbank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/donor")
@CrossOrigin
public class DonorController {
    
    @Autowired
    private DonorService donorService;
    
    @PostMapping("/add")
    public ResponseEntity<Donor> addDonor(@RequestBody Donor donor) {
        Donor savedDonor = donorService.addDonor(donor);
        return ResponseEntity.ok(savedDonor);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Donor>> getAllDonors() {
        List<Donor> donors = donorService.getAllDonors();
        return ResponseEntity.ok(donors);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        Donor donor = donorService.getDonorById(id);
        if (donor != null) {
            return ResponseEntity.ok(donor);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Donor> updateDonor(@PathVariable Long id, @RequestBody Donor donor) {
        Donor updatedDonor = donorService.updateDonor(id, donor);
        if (updatedDonor != null) {
            return ResponseEntity.ok(updatedDonor);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDonor(@PathVariable Long id) {
        boolean deleted = donorService.deleteDonor(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/blood-group/{bloodGroup}")
    public ResponseEntity<List<Donor>> getDonorsByBloodGroup(@PathVariable String bloodGroup) {
        List<Donor> donors = donorService.getDonorsByBloodGroup(bloodGroup);
        return ResponseEntity.ok(donors);
    }
    
    @GetMapping("/available")
    public ResponseEntity<List<Donor>> getAvailableDonors() {
        List<Donor> donors = donorService.getAvailableDonors();
        return ResponseEntity.ok(donors);
    }
}