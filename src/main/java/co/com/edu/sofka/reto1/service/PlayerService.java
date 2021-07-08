package co.com.edu.sofka.reto1.domain;

import co.com.edu.sofka.reto1.model.Player;

import java.util.List;

public interface PlayerService {
    public void createPlayers();

    public List<Player> getPlayers();

    public void showPlayers();
}
