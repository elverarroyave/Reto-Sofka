package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.service.GameService;
import co.com.edu.sofka.reto1.service.PlayerService;
import co.com.edu.sofka.reto1.service.RoadService;
import co.com.edu.sofka.reto1.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    PlayerService playerService = new PlayerServiceImpl();
    RoadService roadService = new RoadServiceImpl();

    List<Player> windPlayers = new ArrayList<>();

    @Override
    public void createGame() {
        welcome();
        recopileDataGame();
        play();
        showWiners();
    }

    void play(){
        List<Player> players = playerService.getPlayers();
        boolean play = true;
        int numbersOfCars = 0;
        int indexSelectCar = 0;
        do{
            numbersOfCars = players.size();
            indexSelectCar = randomCarToPlay(numbersOfCars);
            Player playerGame = players.get(indexSelectCar);
            playerGame.getDriver().getCar().moveForward(moveCar());
            if(playerGame.getDriver().getCar().getRecorrido()>=roadService.getRoad().getDistance()){
                windPlayers.add(playerGame);
                players.remove(indexSelectCar);
                if(windPlayers.size() == 3){
                    play = false;
                }
            }
        }while(play);
    }

    private void showWiners(){
        int index = 0;
        for (Player player : windPlayers) {
            System.out.println((index+1) + "° - " + player.getName());
            index++;
        }
    }

    private int die(){
        return (int)(Math.random()*7);
    }

    private float moveCar(){
        return die()*100;
    }

    private int randomCarToPlay(int quantity){
        return (int)(Math.random()*(quantity));
    }


    private void welcome(){
        System.out.println("**********************************************");
        System.out.println("******Welcome to game of car by console!******");
        System.out.println("**********************************************");
    }

    private void recopileDataGame(){
        System.out.println("==============================================");
        playerService.createPlayers(); //Creamos lista de jugadores
        System.out.println("==============================================");
        playerService.showPlayers(); //Mostrar Jugadores y puntos
        System.out.println("==============================================");
        roadService.createRoad(playerService.getPlayers()); //Crear pista
        System.out.println("==============================================");
        roadService.roadDetail();
        System.out.println("==============================================");
    }
}
