package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.*;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Car name is required")
    @Value("${car.name}")
    private String name;
    
    
    @NotNull(message = "Model is required")
    @Value("${car.model}")
    private String model;
    
    @Min(value = 1886, message = "Year must be at least 1886")
    @Max(value = 2024, message = "Year cannot be greater than the current year")
    @Value("${car.year}")
    private int year;
    
    
    
    @Min(value = 0, message = "Price must be positive")
    @Value("${car.price}")
    private double price;
    
    @Value("${car.color}")
    private String color;
    
    @Value("${car.fuelType}")
    private String fuelType;
//    public Car(Long id, @NotNull(message = "Car name is required") String name,
//			@NotNull(message = "Model is required") String model,
//			@Min(value = 1886, message = "Year must be at least 1886") @Max(value = 2024, message = "Year cannot be greater than the current year") int year,
//			@Min(value = 0, message = "Price must be positive") double price, String color, String fuelType) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.model = model;
//		this.year = year;
//		this.price = price;
//		this.color = color;
//		this.fuelType = fuelType;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	
 
    


    // Getters and setters
}
