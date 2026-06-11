package com.ducat.springboot20.Controller;

 import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;

import com.ducat.springboot20.Entity.Bike;
import com.ducat.springboot20.Service.BikeService;
import java.util.*;

@RestController
public class BikeController {
    private BikeService service;

    public BikeController(BikeService bikeService){
        this.service=bikeService;
    }
    @PostMapping("/add-bike/owner-id/{owner_id}")
    public void addBikeController(@RequestBody Bike bike,@PathVariable int owner_id){
        System.out.println("Data receive in springbooot "+bike);
        service.addBike(bike,owner_id);
    }

    @DeleteMapping("/del-bike/{bikeId}")
    public String deleteBikeController(@PathVariable int bikeId){
        if(service.deleteBikeService(bikeId)){
            return "Deleted Succesfull ";
        }else{
            return "Not found ";
        }
    }

    @GetMapping("/get-bike")
    public List<Bike> getBikeController(){
        System.out.println("Bike controller called ! ");
        return service.getBikeService();
    }
    @PutMapping("/update-bike/{id}")
    public Boolean updateBikeController(@PathVariable int id,@RequestBody Bike updateBikeData){
        return service.updateBikeService(id, updateBikeData);
    }
}
