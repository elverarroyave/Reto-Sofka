package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Lane {

    private Integer id;

    private int idCar;

    public Lane(Integer id, int idCar) {
        this.id = id;
        this.idCar = idCar;
    }
}
