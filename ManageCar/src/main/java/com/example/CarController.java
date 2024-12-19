package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.*;
@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Endpoint to create a car
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    // Endpoint to get all cars (with pagination)
    @GetMapping("/cars")
    public List<Car> getAllCars(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder)
    {
Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.by(sortBy)));
return carService.getAllCars(pageable);
    }
//    		
//    		@PageableDefault(size = 10) Pageable pageable) {
//        List<Car> cars = carService.getAllCars(pageable);
//        return ResponseEntity.ok(cars);
//    }

    // Endpoint to update a car
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Car updatedCar = carService.updateCar(id, carDetails);
        return ResponseEntity.ok(updatedCar);
    }

    // Endpoint to delete a car
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to search cars
    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestParam String query) {
        List<Car> cars = carService.searchCars(query);
        return ResponseEntity.ok(cars);
    }
}