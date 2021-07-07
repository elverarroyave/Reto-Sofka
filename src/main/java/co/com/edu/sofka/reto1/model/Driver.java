package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver {

    private Integer id;

    private Player player;

    private Car car;

    public Driver(){}

    public Driver(Integer id, Car car) {
        this.id = id;
        this.car = car;
    }
}
