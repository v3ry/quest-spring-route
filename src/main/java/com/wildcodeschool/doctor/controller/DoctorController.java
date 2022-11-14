package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {
    Doctor jodie = new Doctor(13,"Jodie");

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable("number") int num) {
        if(num == 13){
            return jodie;
        }else if(num >= 1 && num <= 12){
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Doctor " + num);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + num);
        }
       
    }
}
