package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Driver;
import co.com.edu.sofka.reto1.service.CarService;
import co.com.edu.sofka.reto1.service.DriverService;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {

    List<Driver> drivers = new ArrayList<>();

    CarService carService = new CarServiceImpl();

    @Override
    public void createDrivers(int quantity) {
        carService.createCars(quantity);
        for (int i = 0; i < quantity; i++) {
            Driver driver = new Driver(
                    i,
                    carService.findCarById(i)
            );
            drivers.add(driver);
        }
    }

    @Override
    public Driver findById(int id) {
        return drivers.get(id);
    }


}
