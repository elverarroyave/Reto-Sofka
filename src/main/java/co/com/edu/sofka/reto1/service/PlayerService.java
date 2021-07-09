package co.com.edu.sofka.reto1.service;

import co.com.edu.sofka.reto1.model.Player;

import java.util.List;

public interface PlayerService {
    void createPlayers();

    void resetPlayers();

    List<Player> getPlayers();
}
