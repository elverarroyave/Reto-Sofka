package co.com.edu.sofka.reto1.domain;

import co.com.edu.sofka.reto1.model.Car;

public interface CarService {
    void createCars(int quantity);

    Car findCarById(int id);
}
