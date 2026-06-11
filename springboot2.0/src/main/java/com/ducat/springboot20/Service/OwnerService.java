package com.ducat.springboot20.Service;

import org.springframework.stereotype.Service;

import com.ducat.springboot20.Entity.Owner;
import com.ducat.springboot20.Repository.OwnerRepository;

@Service
public class OwnerService {
    private  final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository){
         this.ownerRepository=ownerRepository;
    }
    public Owner saveOwner(Owner ownerData){
        return ownerRepository.save(ownerData);
    }
}
