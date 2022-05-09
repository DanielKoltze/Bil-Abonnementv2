package com.example.bilabonnement.controllers;


import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.rmi.dgc.Lease;

@Controller
public class LeaseController {

    private CarService carService;

    public LeaseController (CarService carService) {
        this.carService = carService;
    }


    //TODO skal måske modtage kundeId som parameter
    @GetMapping("/create-lease/{id}")
    public String createLease(@PathVariable("id") String registrationNumber, Model model) {
        Car car = carService.getCarById(registrationNumber);
        model.addAttribute("car", car);



        return "create-lease";
    }


}
