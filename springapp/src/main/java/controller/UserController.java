package controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import dao.ILogin;
import model.Login;

import dao.IBloodBank;
import model.BloodBank;

import dao.IBloodDonor;
import model.BloodDonor;

import dao.IUser;
import model.User;

@RestController
public class UserController {

    @Autowired
    ILogin login;

    @Autowired
    IBloodBank bloodBank;

    @Autowired
    IBloodDonor bloodDonor;

    @Autowired
    IUser user;

    @GetMapping("/donor")
    public List<BloodDonor> allDonors(){
        return bloodDonor.findAll();
    }

    @GetMapping("/sample")
    public List<BloodBank> allSamples(){
        return bloodBank.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody Login lg){
        if(login.findById(lg.getEmail()).isPresent()){
            if(login.findById(lg.getEmail()).get().getPassword().equals(lg.getPassword())){
                return "true";
            }
            return "false";
        }
        return "false";
    }

    //using user table for signup
    @PostMapping("/signup")
    public String signUp(@RequestBody User u){
        if(user.findById(u.getEmail()).isPresent()){
            return "false";
       }
       else if(u.getPassword() == null){
           return "false";
       }
       else{
          user.save(u);
          return "true";
       }
    }
    
    @GetMapping("/donor/{id}")
    public BloodDonor particularDonor(@PathVariable("id") String id){//List
        if(bloodDonor.findById(id).isPresent()){
            return bloodDonor.findById(id).get();
        }
        return null;
    }

    @GetMapping("/sample/{id}")
    public BloodBank particularSample(@PathVariable("id") String bloodBankID){
        if(bloodBank.findById(bloodBankID).isPresent()){
            return bloodBank.findById(bloodBankID).get();
        }
        return null;
    }

}