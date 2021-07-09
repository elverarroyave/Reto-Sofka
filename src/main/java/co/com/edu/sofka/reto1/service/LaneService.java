package co.com.edu.sofka.reto1.service;

import co.com.edu.sofka.reto1.model.Lane;
import co.com.edu.sofka.reto1.model.Player;

import java.util.List;

public interface LaneService {
    void createLanes(List<Player> players);

    void resetLanes();

    List<Lane> getAllLanes();
}
