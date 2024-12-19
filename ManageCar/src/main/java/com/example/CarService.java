package com.example;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Create a car
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    // Read all cars
    public List<Car> getAllCars(Pageable pageable) {
        return carRepository.findAll(pageable).getContent();
    }

    // Update a car
    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setName(carDetails.getName());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        car.setPrice(carDetails.getPrice());
        car.setColor(carDetails.getColor());
        car.setFuelType(carDetails.getFuelType());
        return carRepository.save(car);
    }

    // Delete a car
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    // Search cars by various fields
    public List<Car> searchCars(String query) {
        return carRepository.findByNameContainingIgnoreCase(query);  // You can extend this to support other fields
    }
}


