package com.bloodbank.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "donors")
public class Donor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "donor_name", nullable = false)
    private String donorName;
    
    @Column(nullable = false)
    private String bloodGroup;
    
    private int age;
    
    private String gender;
    
    @Column(unique = true)
    private String email;
    
    private String phone;
    
    private String address;
    
    @Column(name = "last_donation_date")
    @Temporal(TemporalType.DATE)
    private Date lastDonationDate;
    
    @Column(name = "is_available")
    private boolean isAvailable = true;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    // Constructors
    public Donor() {}
    
    public Donor(String donorName, String bloodGroup, int age, String email) {
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.email = email;
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getDonorName() { return donorName; }
    public void setDonorName(String donorName) { this.donorName = donorName; }
    
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public Date getLastDonationDate() { return lastDonationDate; }
    public void setLastDonationDate(Date lastDonationDate) { this.lastDonationDate = lastDonationDate; }
    
    public boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }
    
    
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}