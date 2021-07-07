package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car{

    private Integer id;


    private float recorrido;

    public Car(){}

    public Car(Integer id) {
        this.id = id;
        this.recorrido = 0;
    }

    public float moveForward(float move){
        this.recorrido +=  move;
        return this.recorrido;
    }

    
}
