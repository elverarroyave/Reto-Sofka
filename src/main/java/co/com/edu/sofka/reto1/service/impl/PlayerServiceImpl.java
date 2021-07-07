package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Player;
import co.com.edu.sofka.reto1.service.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerServiceImpl implements PlayerService {
    @Override
    public List<Player> createPlayers() {

        Scanner in = new Scanner(System.in);

        //Ingresar la cantidad de participante
        System.out.print("Ingrese la cantidad de jugadores: ");
        int numberOfPalyers = in.nextInt();

        //Creamos lista de jugadores
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numberOfPalyers; i++) {
            System.out.print("Ingrese el nombre del jugador #" + (i+1) +": ");
            String namePlayer = in.next();
            Player player = new Player(i, namePlayer,0);
            players.add(player);
        }

        return players;
    }

    @Override
    public void showPlayers(List<Player> players) {
        for(Player player: players){
            System.out.println("Name: " + player.getName());
            System.out.println("Points: " + player.getPoints());
            System.out.println();
        }
    }
}
