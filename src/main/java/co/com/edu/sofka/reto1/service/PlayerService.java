package co.com.edu.sofka.reto1.service;

import co.com.edu.sofka.reto1.model.Player;

import java.util.List;

public interface PlayerService {
    public void createPlayers();

    public void resetPlayers();

    public List<Player> getPlayers();

    //public void showPlayers();
}
