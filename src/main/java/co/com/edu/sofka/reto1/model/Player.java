package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Integer id;

    private String name;

    private int points;

    private Driver driver;

    public Player(Integer id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public Player(){}
}
