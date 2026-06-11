package com.ducat.springboot20.Service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public void addBike(Bike bike,int owner_id){
        //find the owner by id --> 
        Optional<Owner> box=ownerRepository.findById(owner_id);//
        if(box.isPresent()){
            Owner saveOwnerObject=box.get();
            bike.setOwner(saveOwnerObject);
            bikeRepository.save(bike);
        }
       // throw new Custome excepiton owner not found ! 
        // bike k object me owner ko fit karenge then bike object ko save kra denge 
      
    }
    public List<Bike> getBikeService(){
        System.out.println("Bike Service called");
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
    public boolean updateBikeService(int bike_Id,Bike updatedBikeData){
       Optional<Bike> box=bikeRepository.findById(bike_Id);
       if(box.isPresent()){
          Bike oldBikeData=box.get();
          oldBikeData.setBikeModel(updatedBikeData.getBikeModel());
          bikeRepository.save(oldBikeData);
          return true;
       }
       log.debug("No Bike present with this id"+bike_Id);
       return false;
        
    }
   
}
