package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="blood_donor")
public class BloodDonor {
  @Id
  private String id;
  @Column(name="donor_email")
  private String donorEmail;
  @Column(name="blood_group")
  private String bloodGroup;
  @Column(name="pH_level")
  private String pHLevel;
  @Column(name="blood_pressure")
  private String bloodPressure;
  private Boolean active;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDonorEmail() {
    return donorEmail;
  }

  public void setDonorEmail(String donorEmail) {
    this.donorEmail = donorEmail;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getpHLevel() {
    return pHLevel;
  }

  public void setpHLevel(String pHLevel) {
    this.pHLevel = pHLevel;
  }

  public String getBloodPressure() {
    return bloodPressure;
  }

  public void setBloodPressure(String bloodPressure) {
    this.bloodPressure = bloodPressure;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}
