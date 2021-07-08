package co.com.edu.sofka.reto1.service;

import co.com.edu.sofka.reto1.model.Player;
import co.com.edu.sofka.reto1.model.Road;

import java.util.List;

public interface RoadService {
    void createRoad(List<Player> players);

    Road getRoad();

    void resetRoad();

    void roadDetail();
}
