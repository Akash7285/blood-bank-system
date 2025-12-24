package com.bloodbank.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blood_inventory")
public class BloodInventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;
    
    @Column(name = "quantity_ml", nullable = false)
    private int quantityMl;
    
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    
    @Column(name = "donor_id")
    private Long donorId;
    
    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    
    private String status; // AVAILABLE, USED, EXPIRED
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    // Constructors
    public BloodInventory() {}
    
    public BloodInventory(String bloodGroup, int quantityMl, Long donorId) {
        this.bloodGroup = bloodGroup;
        this.quantityMl = quantityMl;
        this.donorId = donorId;
        this.receivedDate = new Date();
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        if (status == null) {
            status = "AVAILABLE";
        }
        if (receivedDate == null) {
            receivedDate = new Date();
        }
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    
    public int getQuantityMl() { return quantityMl; }
    public void setQuantityMl(int quantityMl) { this.quantityMl = quantityMl; }
    
    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
    
    public Long getDonorId() { return donorId; }
    public void setDonorId(Long donorId) { this.donorId = donorId; }
    
    public Date getReceivedDate() { return receivedDate; }
    public void setReceivedDate(Date receivedDate) { this.receivedDate = receivedDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}