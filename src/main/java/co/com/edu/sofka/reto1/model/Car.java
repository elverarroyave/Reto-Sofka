package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car{

    private Integer id;

    private int idLane;

    public Car(){}

    public Car(Integer id, int idLane) {
        this.id = id;
        this.idLane = idLane;
    }
}
