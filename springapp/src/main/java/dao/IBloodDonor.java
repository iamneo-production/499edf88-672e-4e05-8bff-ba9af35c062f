package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.BloodDonor;

import java.util.List;

public interface IBloodDonor extends JpaRepository<BloodDonor, String> {
    
}