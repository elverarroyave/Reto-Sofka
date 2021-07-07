package co.com.edu.sofka.reto1.service;

import co.com.edu.sofka.reto1.model.Driver;
import co.com.edu.sofka.reto1.model.Player;

import java.util.List;

public interface DriverService {
    void createDrivers(int quantity);

    Driver findById(int id);
}
