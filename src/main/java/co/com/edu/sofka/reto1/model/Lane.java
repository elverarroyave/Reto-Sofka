package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Lane {

    private Integer id;

    private Car car;

    public Lane(Integer id, Car car) {
        this.id = id;
        this.car = car;
    }
}
