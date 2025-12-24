package com.bloodbank.controller;

import com.bloodbank.model.BloodInventory;
import com.bloodbank.service.BloodInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin
public class BloodInventoryController {
    
    @Autowired
    private BloodInventoryService bloodInventoryService;
    
    @PostMapping("/blood/add")
    public ResponseEntity<BloodInventory> addBloodUnit(@RequestBody BloodInventory bloodInventory) {
        BloodInventory savedUnit = bloodInventoryService.addBloodUnit(bloodInventory);
        return ResponseEntity.ok(savedUnit);
    }
    
    @GetMapping("/blood/all")
    public ResponseEntity<List<BloodInventory>> getAllBloodUnits() {
        List<BloodInventory> bloodUnits = bloodInventoryService.getAllBloodUnits();
        return ResponseEntity.ok(bloodUnits);
    }
    
    @GetMapping("/blood/{id}")
    public ResponseEntity<BloodInventory> getBloodUnitById(@PathVariable Long id) {
        BloodInventory bloodUnit = bloodInventoryService.getBloodUnitById(id);
        if (bloodUnit != null) {
            return ResponseEntity.ok(bloodUnit);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/blood/update/{id}")
    public ResponseEntity<BloodInventory> updateBloodUnit(@PathVariable Long id, 
                                                          @RequestBody BloodInventory bloodInventory) {
        BloodInventory updatedUnit = bloodInventoryService.updateBloodUnit(id, bloodInventory);
        if (updatedUnit != null) {
            return ResponseEntity.ok(updatedUnit);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/blood/delete/{id}")
    public ResponseEntity<?> deleteBloodUnit(@PathVariable Long id) {
        boolean deleted = bloodInventoryService.deleteBloodUnit(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/blood/group/{bloodGroup}")
    public ResponseEntity<List<BloodInventory>> getBloodByGroup(@PathVariable String bloodGroup) {
        List<BloodInventory> bloodUnits = bloodInventoryService.getBloodByGroup(bloodGroup);
        return ResponseEntity.ok(bloodUnits);
    }
    
    @GetMapping("/blood/available/{bloodGroup}")
    public ResponseEntity<List<BloodInventory>> getAvailableBloodByGroup(@PathVariable String bloodGroup) {
        List<BloodInventory> bloodUnits = bloodInventoryService.getAvailableBloodByGroup(bloodGroup);
        return ResponseEntity.ok(bloodUnits);
    }
    
    @GetMapping("/blood/quantity/{bloodGroup}")
    public ResponseEntity<?> getTotalBloodQuantity(@PathVariable String bloodGroup) {
        int totalQuantity = bloodInventoryService.getTotalBloodQuantityByGroup(bloodGroup);
        Map<String, Object> response = new HashMap<>();
        response.put("bloodGroup", bloodGroup);
        response.put("totalQuantityMl", totalQuantity);
        return ResponseEntity.ok(response);
    }
}