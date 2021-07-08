package co.com.edu.sofka.reto1.service;

import co.com.edu.sofka.reto1.model.Driver;

public interface DriverService {
    void createDrivers(int quantity);

    void resetDrivers();

    Driver findById(int id);
}
