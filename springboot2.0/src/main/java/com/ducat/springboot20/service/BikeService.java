package com.ducat.springboot20.service;

import java.util.*;

import com.ducat.springboot20.dto.BikeDTO;
import org.springframework.stereotype.Service;

import com.ducat.springboot20.Entity.Bike;
import com.ducat.springboot20.Entity.Owner;
import com.ducat.springboot20.Repository.BikeRepository;
import com.ducat.springboot20.Repository.OwnerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BikeService {
    
    private final BikeRepository bikeRepository;
    private final OwnerRepository ownerRepository;
    
    public BikeService(BikeRepository bikeRepository, OwnerRepository ownerRepository) {
        this.bikeRepository = bikeRepository;
        this.ownerRepository = ownerRepository;
    }
    public void addBike(BikeDTO bikeDTO, int ownerId){
        //find the owner by id --> 
        Optional<Owner> box=ownerRepository.findById(ownerId);//
        if(box.isPresent()){
            Owner savedOwnerObject=box.get();
            Bike bike=getBikeFromDto(bikeDTO);
            bike.setOwner(savedOwnerObject);
            bikeRepository.save(bike);
        }
       // throw new Custome excepiton owner not found ! 
        // bike k object me owner ko fit karenge then bike object ko save kra denge 
      
    }
    public List<Bike> getBikeService(){
        log.info("Bike service called");
        return bikeRepository.findAll();
    }
    public boolean deleteBikeService(int bikeId){
        //check karenge ! ess id se bike available hai k nah ! 
        Optional<Bike> box=bikeRepository.findById(bikeId);
        if(box.isPresent()){
            bikeRepository.deleteById(bikeId);
            return true;
        }
        return false;
          //then delete kr denge ! 
        // not found ! 
    }
    public boolean updateBikeService(int bikeId,BikeDTO updatedBikeDTO){
       Optional<Bike> box=bikeRepository.findById(bikeId);
       if(box.isPresent()){
          Bike oldBikeData=box.get();
          oldBikeData.setBikeModel(updatedBikeDTO.getBikeModel());
          oldBikeData.setBikeName(updatedBikeDTO.getBikeName());
          oldBikeData.setColor(updatedBikeDTO.getColor());
          oldBikeData.setPrice(updatedBikeDTO.getPrice());
          bikeRepository.save(oldBikeData);
          return true;
       }
       log.debug("No Bike present with this id"+bikeId);
       return false;
        
    }
    public static Bike getBikeFromDto(BikeDTO bikeDTO){
        return Bike.builder()
                .bikeName(bikeDTO.getBikeName())
                .bikeModel(bikeDTO.getBikeModel())
                .color(bikeDTO.getColor())
                .price(bikeDTO.getPrice())
                .build();
        
    }
   
}
