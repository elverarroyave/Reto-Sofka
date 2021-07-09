package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Podium {

    private Integer id;

    private Player firstPosition;

    private Player secondPosition;

    private Player thirdPosition;

    public Podium() {}

    public Podium(Integer id, Player firstPosition, Player secondPosition, Player thirdPosition) {
        this.id = id;
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
    }
}