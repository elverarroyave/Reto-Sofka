package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Car;
import co.com.edu.sofka.reto1.model.Lane;
import co.com.edu.sofka.reto1.service.GameService;
import co.com.edu.sofka.reto1.service.PlayerService;
import co.com.edu.sofka.reto1.service.RoadService;
import co.com.edu.sofka.reto1.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameServiceImpl implements GameService {

    PlayerService playerService = new PlayerServiceImpl();
    RoadService roadService = new RoadServiceImpl();

    List<Player> windPlayers = new ArrayList<>();
    int numGame = 0;

    Scanner in = new Scanner(System.in);

    @Override
    public void createGame() {
        boolean playAgain = false;
        do {
            welcome(numGame++);
            recopileDataGame();
            play();
            showWiners();

            System.out.println("Jugar de nuevo? si/no");
            String result = in.next();
            playAgain = result.equalsIgnoreCase("si");

            if(playAgain) resetGame();

        }while(playAgain);
    }

    void resetGame(){
        playerService.resetPlayers();
        roadService.resetRoad();
        windPlayers.clear();
    }

    void play(){
        List<Lane> lanes = roadService.getRoad().getLanes();
        loop(lanes);
    }

    private void loop(List<Lane> lanes){
        boolean play = true;
        int indexSelectCar = 0;
        do{
            indexSelectCar = randomCarToPlay(lanes.size());
            Lane carGame = lanes.get(indexSelectCar);
            moveCar(carGame.getCar());
            showMove(carGame.getCar());
            if(carGame.getCar().getRecorrido()>=roadService.getRoad().getDistance()){
                windPlayers.add(playerService.getPlayers().get(carGame.getId()));
                lanes.remove(indexSelectCar);
                showWind(carGame.getCar());
                if(lanes.size() == 0){
                    play = false;
                }
            }
            System.out.println("---------------------------------------------------------------------");
        }while(play);
    }

    void showMove(Car car){
        System.out.println("El carro #" + car.getId()
                + " alcanza: " + car.getRecorrido()
                + " mts/" +roadService.getRoad().getDistance() + " mts");
    }

    private void showWind(Car car){
        Player player = playerService.getPlayers().get(car.getId());
        System.out.println("El carro #" + car.getId()
                + "(conductor: " + player.getName() + ")"
                + " ha llegado a la meta!"
                + "--------------------------> Has Llegado!");
    }

    private void showWiners(){
        int index = 0;
        for (Player player : windPlayers) {
            System.out.println((index+1) + "° - " + player.getName());
            index++;
            if(index==3) break;
        }
    }

    private int die(){
        String value = in.next();
        int die = (int)(Math.random()*6) + 1;
        System.out.println("El dado jugó: " + die);
        return die;
    }

    private void moveCar(Car car){
        Player player = playerService.getPlayers().get(car.getId());
        System.out.println("Es turno del carro #" + car.getId()
                + "(conductor: " + player.getName() + ")"
                + ", posición actual: " + car.getRecorrido() + " mts");
        System.out.println("Lanzar dado: (Presione cualquier letra y luego de enter)");
        car.moveForward(die()*100);
    }

    private int randomCarToPlay(int quantity){
        return (int)(Math.random()*(quantity));
    }

    private void welcome(int i){
        System.out.println("**********************************************");
        System.out.println("******Welcome to game of car by console!******");
        System.out.println("************=======Game#"+(i+1)+"=======**************");
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
