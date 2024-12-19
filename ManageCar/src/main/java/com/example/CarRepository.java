package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByNameContainingIgnoreCase(String name);
    List<Car> findByModelContainingIgnoreCase(String model);
    List<Car> findByYear(int year);
    List<Car> findByColorContainingIgnoreCase(String color);
    List<Car> findByFuelTypeContainingIgnoreCase(String fuelType);
}