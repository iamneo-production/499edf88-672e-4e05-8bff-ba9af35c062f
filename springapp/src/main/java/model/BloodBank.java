package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name="blood_bank")
public class BloodBank {
    @Id 
    @Column(name="blood_bank_ID")
    private String bloodBankID;
    @Column(name="blood_group")
    private String bloodGroup;
    @Column(name="blood_pressure")
    private String bloodPressure;
    @Column(name="pH_level")
    private String pHLevel;
    private int quantity;
    public String getBloodBankID() {
      return bloodBankID;
    }
    public void setBloodBankID(String bloodBankID) {
      this.bloodBankID = bloodBankID;
    }
    public String getBloodGroup() {
      return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
      this.bloodGroup = bloodGroup;
    }
    public String getBloodPressure() {
      return bloodPressure;
    }
    public void setBloodPressure(String bloodPressure) {
      this.bloodPressure = bloodPressure;
    }
    public String getpHLevel() {
      return pHLevel;
    }
    public void setpHLevel(String pHLevel) {
      this.pHLevel = pHLevel;
    }
    public int getQuantity() {
      return quantity;
    }
    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }

}
