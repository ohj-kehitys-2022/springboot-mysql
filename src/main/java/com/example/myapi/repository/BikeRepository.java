package com.example.myapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapi.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{

}
