package controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import dao.IBloodBank;
import model.BloodBank;

import dao.IBloodDonor;
import model.BloodDonor;

@RestController
public class AdminController {

    @Autowired
    IBloodBank bloodBank;

    @Autowired
    IBloodDonor bloodDonor;

     @PostMapping("/admin/addSample")
     public String addSample(@RequestBody BloodBank bb){
        bloodBank.save(bb);
        return "Sample added"; 
     }
    
     @DeleteMapping("/admin/sample/{id}")
     public String deleteSample(@PathVariable("id") String id){
         if(bloodBank.findById(id).isPresent()){
             bloodBank.deleteById(id);
             return "Sample deleted";
         }
         return "Sample with ID: "+id+" is not there";
     }

     @PutMapping("/admin/sample/{id}")
     public String updateSample(@RequestBody BloodBank bb, @PathVariable("id") String bloodBankID){
         if(bloodBank.findById(bloodBankID).isPresent()){
             bloodBank.findById(bloodBankID).map(bloodBank1->{
                 bloodBank1.setBloodGroup(bb.getBloodGroup());
                 bloodBank1.setBloodPressure(bb.getBloodPressure());
                 bloodBank1.setpHLevel(bb.getpHLevel());
                 bloodBank1.setQuantity(bb.getQuantity());
                 return bloodBank.save(bloodBank1);
             });
             return "Sample Updated";
         }
         return "Sample with ID: "+bloodBankID+" is not there";
     }

     @PutMapping("/admin/donor/{id}")
     public String updateDonor(@RequestBody BloodDonor bd, @PathVariable String id){
         if(bloodDonor.findById(id).isPresent()){
             bloodDonor.findById(id).map(bloodDonor1->{
                 bloodDonor1.setDonorEmail(bd.getDonorEmail());
                 bloodDonor1.setBloodGroup(bd.getBloodGroup());
                 bloodDonor1.setBloodPressure(bd.getBloodPressure());
                 bloodDonor1.setpHLevel(bd.getpHLevel());
                 bloodDonor1.setActive(bd.getActive());
                 return bloodDonor.save(bloodDonor1);
             });
             return "Donor Updated";
         }
         return "Donor with ID: "+id+" is not there";
     }

     @DeleteMapping("/admin/donor/{id}")
     public String deleteDonor(@PathVariable("id") String id){
        if(bloodDonor.findById(id).isPresent()){
             bloodDonor.deleteById(id);
             return "Donor deleted";
         }
         return "Donor with ID: "+id+" is not there";
     }
    
}
