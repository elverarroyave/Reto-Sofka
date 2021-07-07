package co.com.edu.sofka.reto1.service;

import co.com.edu.sofka.reto1.model.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> createPlayers();

    public void showPlayers(List<Player> players);
}
