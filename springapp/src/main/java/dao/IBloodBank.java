package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.BloodBank;

import java.util.List;

public interface IBloodBank extends JpaRepository<BloodBank, String> {
 
}