package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Game {

    private Integer id;

    private Podium podium;

    private List<Player> players;

    private Road road;

    public Game(){}

    public Game(int id, List<Player> players, Road road ){
        this.id = id;
        this.players = players;
        this.road = road;
    }
}
