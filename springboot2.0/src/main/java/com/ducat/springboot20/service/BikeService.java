package com.ducat.springboot20.service;

import java.util.*;

import com.ducat.springboot20.dto.BikeDTO;
import org.springframework.stereotype.Service;

import com.ducat.springboot20.Entity.Bike;
import com.ducat.springboot20.Entity.Owner;
import com.ducat.springboot20.Exception.DataNotFoundException;
import com.ducat.springboot20.Repository.BikeRepository;
import com.ducat.springboot20.Repository.OwnerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BikeService {
    
    private final BikeRepository bikeRepository;
    private final OwnerRepository ownerRepository;

    public BikeDTO getBikeByName(String bikeName){
       Optional<Bike> box= bikeRepository.findByBikeName(bikeName); 
       if(box.isPresent()){
            Bike savedBikeInDb=box.get();
             return getDtoFromBike(savedBikeInDb);
       }      
       throw new DataNotFoundException("No Data found with "+bikeName+" given bike name");
    }
    public BikeService(BikeRepository bikeRepository, OwnerRepository ownerRepository) {
        this.bikeRepository = bikeRepository;
        this.ownerRepository = ownerRepository;
    }
    public void addBike(BikeDTO bikeDTO, int ownerId){
        //find the owner by id --> 
        Optional<Owner> box=ownerRepository.findById(ownerId);//
        if(box.isPresent()){
            //saved ownerData
            Owner savedOwnerObject=box.get();
            Bike bike=getBikeFromDto(bikeDTO);
            bike.setOwner(savedOwnerObject);

            bikeRepository.save(bike);
        }      
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

        Bike obj=new Bike();
        if(     bikeDTO.getBikeModel()!=null 
            || bikeDTO.getBikeModel().isEmpty() 
            || bikeDTO.getBikeModel().trim()!=""){
                obj.setBikeModel(bikeDTO.getBikeModel());
            }
            
        obj.setBikeName(bikeDTO.getBikeName());
        obj.setPrice(bikeDTO.getPrice());
        obj.setColor(bikeDTO.getColor());
        return obj;
        
        
    }
    public static BikeDTO getDtoFromBike(Bike bike){
        BikeDTO emptyObj=new BikeDTO();
        emptyObj.setBikeModel(bike.getBikeModel());
        emptyObj.setBikeName(bike.getBikeName());
        emptyObj.setColor(bike.getColor());
        emptyObj.setPrice(bike.getPrice());
        return emptyObj;
    }
}
