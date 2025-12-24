package com.bloodbank.service;

import com.bloodbank.model.Donor;
import com.bloodbank.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonorService {
    
    @Autowired
    private DonorRepository donorRepository;
    
    public Donor addDonor(Donor donor) {
        return donorRepository.save(donor);
    }
    
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }
    
    public Donor getDonorById(Long id) {
        return donorRepository.findById(id).orElse(null);
    }
    
    public Donor updateDonor(Long id, Donor donorDetails) {
        Donor donor = donorRepository.findById(id).orElse(null);
        if (donor != null) {
            donor.setDonorName(donorDetails.getDonorName());
            donor.setBloodGroup(donorDetails.getBloodGroup());
            donor.setAge(donorDetails.getAge());
            donor.setGender(donorDetails.getGender());
            donor.setEmail(donorDetails.getEmail());
            donor.setPhone(donorDetails.getPhone());
            donor.setAddress(donorDetails.getAddress());
            donor.setLastDonationDate(donorDetails.getLastDonationDate());
            donor.setIsAvailable(donorDetails.getIsAvailable());
            return donorRepository.save(donor);
        }
        return null;
    }
    
    public boolean deleteDonor(Long id) {
        if (donorRepository.existsById(id)) {
            donorRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Donor> getDonorsByBloodGroup(String bloodGroup) {
        return donorRepository.findByBloodGroup(bloodGroup);
    }
    
    public List<Donor> getAvailableDonors() {
        return donorRepository.findByIsAvailable(true);
    }
}