package co.com.edu.sofka.reto1.domain.impl;

import co.com.edu.sofka.reto1.model.Player;
import co.com.edu.sofka.reto1.domain.DriverService;
import co.com.edu.sofka.reto1.domain.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerServiceImpl implements PlayerService {

    List<Player> players = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    DriverService driverService = new DriverServiceImpl();

    @Override
    public void createPlayers() {
        System.out.print("Ingrese la cantidad de jugadores: ");
        int numberOfPalyers = in.nextInt();
        driverService.createDrivers(numberOfPalyers);
        for (int i = 0; i < numberOfPalyers; i++) {
            System.out.print("Ingrese el nombre del jugador #" + (i+1) +": ");
            String namePlayer = in.next().toUpperCase();
            Player player = new Player(i, namePlayer,0, driverService.findById(i));
            players.add(player);
        }
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void showPlayers() {
        for(Player player: players){
            System.out.println("Name: " + player.getName());
            System.out.println("Points: " + player.getPoints());
            System.out.println("Recorrido: " + player.getDriver().getCar().getRecorrido());
        }
    }
}
