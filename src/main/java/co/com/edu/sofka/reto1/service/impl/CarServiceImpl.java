package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Car;
import co.com.edu.sofka.reto1.service.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    List<Car> cars = new ArrayList<>();

    @Override
    public void createCars(int quantity) {
        for (int i = 0; i < quantity; i++) {
            Car car = new Car(i);
            cars.add(car);
        }
    }

    @Override
    public Car findCarById(int id) {
        return cars.get(id);
    }
}
