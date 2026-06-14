package com.ducat.springboot20.service;

import com.ducat.springboot20.dto.OwnerDTO;
import org.springframework.stereotype.Service;

import com.ducat.springboot20.Entity.Owner;
import com.ducat.springboot20.Repository.OwnerRepository;

@Service
public class OwnerService {
    private  final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository){
         this.ownerRepository=ownerRepository;
    }
    public Owner saveOwner(OwnerDTO ownerData){
        Owner ownerToSaved=getOwnerFromDto(ownerData);
        return ownerRepository.save(ownerToSaved);
    }
    public static Owner getOwnerFromDto(OwnerDTO ownerDto){
        return Owner.builder()
                .OwnerName(ownerDto.getOwnerName())
                .age(ownerDto.getOwnerAge())
                .build();

    }
}
