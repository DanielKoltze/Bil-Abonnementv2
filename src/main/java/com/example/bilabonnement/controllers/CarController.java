package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.User;
import com.example.bilabonnement.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class CarController {

    private CarService carService;

    public CarController (CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/create-car")
    public String createCar(){
        return "create-car";
    }


    @PostMapping("landingpage")
    public String searchCars(@RequestParam("search") String search, @RequestParam("sortCriteria") String sortCriteria,
                             Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("showCars", carService.showAllCarsBySearch(search,sortCriteria));
        return "landing-page";
    }

    @GetMapping("/landingpage")
    public String showAllCars(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("showCars", carService.showAllCars());
        //TODO Skal ændres når rigtige template er klar
        return "landing-page";
    }

    @PostMapping(value = "create-car")
    public String addCar(@RequestParam("registrationNumber") String registrationNumber,
                         @RequestParam("chassisNumber") String chassisNumber,
                         @RequestParam("make") String make,
                         @RequestParam("model") String model,
                         @RequestParam("color") String color,
                         @RequestParam("equipmentLevel") String equipmentLevel,
                         @RequestParam("registrationFee") double registrationFee,
                         @RequestParam("carEmission") double emission,
                         @RequestParam(name="link") String link,
                         HttpSession session,Model model2){

        Car car = new Car();
        car.setRegistrationNumber(registrationNumber);
        car.setChassisNumber(chassisNumber);
        car.setMake(make);
        car.setModel(model);
        car.setColor(color);
        car.setEquipmentLevel(equipmentLevel);
        car.setRegistrationFee(registrationFee);
        car.setEmission(emission);
        car.setUrl(link);
        User user = (User) session.getAttribute("user");
        model2.addAttribute("user",user);
        carService.addCar(car);
        return "redirect:/landingpage";
    }


    @GetMapping("/change-status/{chassisNumber}/{regNumber}")
    public String changeStatus(@PathVariable("regNumber") String regNumber, @PathVariable("chassisNumber") String chassisNumber){
        carService.updateStatus(regNumber);
        return "redirect:/show-damagereport/"+ chassisNumber + "/" + regNumber;
    }

}
