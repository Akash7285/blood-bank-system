package com.bloodbank.repository;

import com.bloodbank.model.BloodInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BloodInventoryRepository extends JpaRepository<BloodInventory, Long> {
    List<BloodInventory> findByBloodGroup(String bloodGroup);
    List<BloodInventory> findByStatus(String status);
    List<BloodInventory> findByBloodGroupAndStatus(String bloodGroup, String status);
}