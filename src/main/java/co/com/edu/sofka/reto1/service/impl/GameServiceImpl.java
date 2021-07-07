package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Player;
import co.com.edu.sofka.reto1.service.GameService;
import co.com.edu.sofka.reto1.service.PlayerService;

import java.util.List;
import java.util.Scanner;

public class GameServiceImpl implements GameService {

    PlayerService playerService = new PlayerServiceImpl();

    @Override
    public void createGame() {

        welcome();
        System.out.println("==============================================");
        //Creamos lista de jugadores
        List<Player> players = playerService.createPlayers();
        System.out.println("==============================================");
        //Mostrar Jugadores y puntos
        playerService.showPlayers(players);
        System.out.println("==============================================");
    }

    private void welcome(){
        System.out.println("**********************************************");
        System.out.println("******Welcome to game of car by console!******");
        System.out.println("**********************************************");
    }
}
