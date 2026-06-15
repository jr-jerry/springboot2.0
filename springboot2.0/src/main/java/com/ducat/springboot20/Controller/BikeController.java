package com.ducat.springboot20.Controller;

 import com.ducat.springboot20.dto.BikeDTO;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;

import com.ducat.springboot20.Entity.Bike;
import com.ducat.springboot20.service.BikeService;
import java.util.*;
@Slf4j
@RestController
public class BikeController {
    private final BikeService service;

    public BikeController(BikeService bikeService){
        this.service=bikeService;
    }
    @PostMapping("/add-bike/owner-id/{ownerId}")
    public void addBikeController(@RequestBody BikeDTO bikeDTO, @PathVariable int ownerId){
        service.addBike(bikeDTO,ownerId);
    }
//    @PostMapping("/add-bike/owner-id/{ownerId}")
//    public void addBikeController(@RequestBody Bike bike,@PathVariable int owerId){
//        service.addBike(bike,ownerId);
//    }

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
        log.info("Bike controller called ! ");
        return service.getBikeService();
    }
    @PutMapping("/update-bike/{id}")
    public Boolean updateBikeController(@PathVariable int id,@RequestBody BikeDTO updateBikeData){
        return service.updateBikeService(id, updateBikeData);
    }
}
