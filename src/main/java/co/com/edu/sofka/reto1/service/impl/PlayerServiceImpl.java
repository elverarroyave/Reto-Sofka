package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Player;
import co.com.edu.sofka.reto1.service.DriverService;
import co.com.edu.sofka.reto1.service.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerServiceImpl implements PlayerService {

    List<Player> players = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    DriverService driverService = new DriverServiceImpl();

    @Override
    public void createPlayers() {
        int numberOfPalyers = getNumberPlayers();
        driverService.createDrivers(numberOfPalyers);
        for (int i = 0; i < numberOfPalyers; i++) {
            System.out.print("Ingrese el nombre del jugador #" + (i+1) +": ");
            String namePlayer = in.next().toUpperCase();
            Player player = new Player(i, namePlayer, driverService.findById(i));
            players.add(player);
        }
    }

    private int getNumberPlayers(){
        int numberOfPalyers = 0;
        do {
            System.out.print("Ingrese la cantidad de jugadores(mínimo 3): ");
            numberOfPalyers = in.nextInt();
            if(numberOfPalyers<3) System.out.println("La cantidad debe ser mínimo 3.");
        }while(numberOfPalyers<3);
        return numberOfPalyers;
    }

    @Override
    public void resetPlayers() {
        driverService.resetDrivers();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    /*
    @Override
    public void showPlayers() {
        for(Player player: players){
            System.out.println("Name: " + player.getName());
            System.out.println("Recorrido: " + player.getDriver().getCar().getRecorrido());
        }
    }
     */
}
