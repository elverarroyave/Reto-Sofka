package co.com.edu.sofka.reto1.domain;

import co.com.edu.sofka.reto1.model.Driver;

public interface DriverService {
    void createDrivers(int quantity);

    Driver findById(int id);
}
