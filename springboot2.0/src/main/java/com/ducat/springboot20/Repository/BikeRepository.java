package com.ducat.springboot20.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducat.springboot20.Entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Integer> {
    public Bike findByBikeName(String name);
}
