package co.com.edu.sofka.reto1.service;

import co.com.edu.sofka.reto1.model.Car;

public interface CarService {
    void createCars(int quantity);

    void resetCars();

    Car findCarById(int id);
}
