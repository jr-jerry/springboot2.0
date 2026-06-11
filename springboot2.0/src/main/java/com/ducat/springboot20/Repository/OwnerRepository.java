package com.ducat.springboot20.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducat.springboot20.Entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {

    
}  