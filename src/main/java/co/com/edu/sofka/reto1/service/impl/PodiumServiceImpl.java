package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Game;
import co.com.edu.sofka.reto1.model.Player;
import co.com.edu.sofka.reto1.model.Podium;
import co.com.edu.sofka.reto1.service.PodiumService;

import java.util.ArrayList;
import java.util.List;

public class PodiumServiceImpl implements PodiumService {

    List<Podium> podiumList = new ArrayList<>();

    @Override
    public void createPodium(List<Player> windPlayers) {
        Podium  podium= new Podium(
                podiumList.size(),
                windPlayers.get(0),
                windPlayers.get(1),
                windPlayers.get(2)
        );
        podiumList.add(podium);
        addPoints(windPlayers);
    }

    private void addPoints(List<Player> windPlayers){
        //Añadir puntos a los ganadores
        windPlayers.get(0).addFirstPoint();
        windPlayers.get(1).addSecondPoint();
        windPlayers.get(2).addThirdPoint();
    }

    public void showPodium(List<Player> windPlayers){
        int index = 0;
        for (Player player : windPlayers) {
            System.out.println((index + 1) + "° - " + player.getName());
            System.out.println("Puntos de 1° posición -> " + player.getFirstPositionPoints());
            System.out.println("Puntos de 2° posición -> " + player.getSecondPositionPoints());
            System.out.println("Puntos de 3° posición -> " + player.getThirdPositionPoints());
            index++;
        }
    }
}
