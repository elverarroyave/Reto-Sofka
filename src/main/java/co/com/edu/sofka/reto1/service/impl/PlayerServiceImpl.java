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
            String namePlayer = in.next().toUpperCase().trim();
            players.add(new Player(i, namePlayer, driverService.findById(i)));
        }
    }

    private int getNumberPlayers(){
        int numberOfPalyers;
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
}
