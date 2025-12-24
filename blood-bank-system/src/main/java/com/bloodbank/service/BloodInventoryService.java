package com.bloodbank.service;

import com.bloodbank.model.BloodInventory;
import com.bloodbank.repository.BloodInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class BloodInventoryService {
    
    @Autowired
    private BloodInventoryRepository bloodInventoryRepository;
    
    public BloodInventory addBloodUnit(BloodInventory bloodInventory) {
        // Set default received date if not provided
        if (bloodInventory.getReceivedDate() == null) {
            bloodInventory.setReceivedDate(new Date());
        }
        
        // Set default expiry date (35 days from received date)
        if (bloodInventory.getExpiryDate() == null) {
            Date expiryDate = new Date(bloodInventory.getReceivedDate().getTime() + (35L * 24 * 60 * 60 * 1000));
            bloodInventory.setExpiryDate(expiryDate);
        }
        
        return bloodInventoryRepository.save(bloodInventory);
    }
    
    public List<BloodInventory> getAllBloodUnits() {
        return bloodInventoryRepository.findAll();
    }
    
    public BloodInventory getBloodUnitById(Long id) {
        return bloodInventoryRepository.findById(id).orElse(null);
    }
    
    public BloodInventory updateBloodUnit(Long id, BloodInventory bloodDetails) {
        BloodInventory blood = bloodInventoryRepository.findById(id).orElse(null);
        if (blood != null) {
            blood.setBloodGroup(bloodDetails.getBloodGroup());
            blood.setQuantityMl(bloodDetails.getQuantityMl());
            blood.setExpiryDate(bloodDetails.getExpiryDate());
            blood.setDonorId(bloodDetails.getDonorId());
            blood.setStatus(bloodDetails.getStatus());
            return bloodInventoryRepository.save(blood);
        }
        return null;
    }
    
    public boolean deleteBloodUnit(Long id) {
        if (bloodInventoryRepository.existsById(id)) {
            bloodInventoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<BloodInventory> getBloodByGroup(String bloodGroup) {
        return bloodInventoryRepository.findByBloodGroup(bloodGroup);
    }
    
    public List<BloodInventory> getAvailableBloodByGroup(String bloodGroup) {
        return bloodInventoryRepository.findByBloodGroupAndStatus(bloodGroup, "AVAILABLE");
    }
    
    public int getTotalBloodQuantityByGroup(String bloodGroup) {
        List<BloodInventory> bloodUnits = bloodInventoryRepository.findByBloodGroupAndStatus(bloodGroup, "AVAILABLE");
        int total = 0;
        for (BloodInventory unit : bloodUnits) {
            total += unit.getQuantityMl();
        }
        return total;
    }
}