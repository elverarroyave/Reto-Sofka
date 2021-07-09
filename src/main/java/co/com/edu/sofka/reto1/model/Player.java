package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Integer id;

    private String name;

    private int firstPositionPoints = 0;

    private int secondPositionPoints = 0;

    private int thirdPositionPoints = 0;

    private Driver driver;

    public Player(Integer id, String name, Driver driver) {
        this.id = id;
        this.name = name;
        this.driver = driver;
    }

    public void addFirstPoint(){
        this.firstPositionPoints++;
    }

    public void addSecondPoint(){
        this.secondPositionPoints++;
    }

    public void addThirdPoint(){
        this.thirdPositionPoints++;
    }

    public Player(){}
}
