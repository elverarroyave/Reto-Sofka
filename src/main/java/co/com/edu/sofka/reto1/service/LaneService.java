package co.com.edu.sofka.reto1.domain;

import co.com.edu.sofka.reto1.model.Lane;
import co.com.edu.sofka.reto1.model.Player;

import java.util.List;

public interface LaneService {
    public void createLanes(List<Player> players);

    List<Lane> getAllLanes();
}
