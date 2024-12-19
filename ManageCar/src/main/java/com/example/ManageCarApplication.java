package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManageCarApplication  implements CommandLineRunner {
//	 @Autowired
//	    private CarRepository carRepository;
	
	private final CarService carService;

    @Autowired
    public ManageCarApplication(CarService carService) {
        this.carService = carService;
    }
	 
	public static void main(String[] args) {
		
		SpringApplication.run(ManageCarApplication.class, args);
		
		
		
		
		
		
	}
	  public void run(String... args) throws Exception {
	        // Initialize car details
	        Car car = new Car();
	        car.setName("Skoda ");
	        car.setModel("Model 3");
	        car.setYear(2025);
	        car.setPrice(49999);
	        car.setColor("Green");
	        car.setFuelType("Electric");

	        // Save car to the database
	        carService.createCar(car);

	        System.out.println("Car details have been saved to the database:");
	        System.out.println("Car Name: " + car.getName());
	        System.out.println("Car Model: " + car.getModel());
	        System.out.println("Car Year: " + car.getYear());
	        System.out.println("Car Price: " + car.getPrice());
	        System.out.println("Car Color: " + car.getColor());
	        System.out.println("Fuel Type: " + car.getFuelType());
	        
	        
	        
	     
	    
	    
	        long carIdToUpdate = 126;
	        Car updatedCarDetails = new Car();
	        updatedCarDetails.setName("Updated Tesla Model 3");
	        updatedCarDetails.setModel("2024");
	        updatedCarDetails.setYear(2024);
	        updatedCarDetails.setPrice(54999);
	        updatedCarDetails.setColor("White");
	        updatedCarDetails.setFuelType("Electric");

	      
	        Car updatedCar = carService.updateCar(carIdToUpdate, updatedCarDetails);
	        
	        // Print out the updated car details
	        System.out.println("Updated Car: ");
	        System.out.println("Car ID: " + updatedCar.getId());
	        System.out.println("Car Name: " + updatedCar.getName());
	        System.out.println("Car Model: " + updatedCar.getModel());
	        System.out.println("Car Year: " + updatedCar.getYear());
	        System.out.println("Car Price: " + updatedCar.getPrice());
	        System.out.println("Car Color: " + updatedCar.getColor());
	        System.out.println("Fuel Type: " + updatedCar.getFuelType());
	        
	        
	        long carIdToDelete = 127;  
	        try {
	            // Perform the deletion of the car
	            carService.deleteCar(carIdToDelete);
	            System.out.println("Car with ID " + carIdToDelete + " deleted successfully.");
	        } catch (RuntimeException e) {
	            System.out.println("Car with ID " + carIdToDelete + " not found.");
	        }
	    }
}

	
	
	


