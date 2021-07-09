package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Car;
import co.com.edu.sofka.reto1.model.Lane;
import co.com.edu.sofka.reto1.service.GameService;
import co.com.edu.sofka.reto1.service.PlayerService;
import co.com.edu.sofka.reto1.service.PodiumService;
import co.com.edu.sofka.reto1.service.RoadService;
import co.com.edu.sofka.reto1.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Elver Arroyave
 * @Version: 1.0
 */
public class GameServiceImpl implements GameService {

    PlayerService playerService = new PlayerServiceImpl();
    RoadService roadService = new RoadServiceImpl();
    PodiumService podiumService = new PodiumServiceImpl();

    List<Player> windPlayers = new ArrayList<>();
    int numGame = 0;

    Scanner in = new Scanner(System.in);

    /**
     * Metodo principal donde correrá el juego
     */
    @Override
    public void createGame() {
        recopileDataGame();
        do {
            gameIndex(numGame++);
            play();
            resetGame();
            System.out.println("Correr de nuevo? si/no");
        }while(in.next().equalsIgnoreCase("si"));
    }

    /**
     * Metodo para resetar los valores necesarios del juego, para dar inico a una nueva carrera.
     */
    void resetGame(){
        playerService.resetPlayers();
        windPlayers.clear();
    }

    /**
     *Metodo para iniciar una carrera
     */
    void play(){
        roadService.createRoad(playerService.getPlayers()); //Crear pista
        List<Lane> lanes = roadService.getRoad().getLanes();
        loop(lanes);
        podiumService.createPodium(windPlayers);
    }

    /**
     * Metodo donde iteraremos los autos en cada carrera
     * @param lanes: Lista de carriles y autos de carrera en ejecución
     */
    private void loop(List<Lane> lanes){
        boolean play = true;
        do{
            Lane laneToPlay = lanes.get(randomCarToPlay(lanes.size()));
            moveCar(laneToPlay.getCar());
            play = !validate(lanes, laneToPlay);
            System.out.println("---------------------------------------------------------------------");
        }while(play);
    }

    private boolean validate(List<Lane> lanes, Lane lane){
        if(lane.getCar().getRecorrido()>=roadService.getRoad().getDistance()){
            if(windPlayers.size()<3) windPlayers.add(playerService.getPlayers().get(lane.getId()));
            lanes.remove(lane);
            showWind(lane.getCar());
        }
        return (lanes.size() == 0);
    }

    /**
     * Lanzar dado
     * @return valor del dado lanzado.
     */
    private int die(){
        //String value = in.next(); // input para crear una pausa del juego simulando el lanzamiento de un dado
        int die = (int)(Math.random()*6) + 1;
        System.out.println("El dado jugó: " + die);
        return die;
    }

    /**
     * Metodo que mueve el carro de posicion en la pista.
     * @param car: carro que se movera.
     */
    private void moveCar(Car car){
        Player player = playerService.getPlayers().get(car.getId());
        System.out.println("Es turno del carro #" + car.getId()
                + "(conductor: " + player.getName() + ")"
                + ", posición actual: " + car.getRecorrido() + " mts");
        System.out.println("Lanzar dado: (Presione cualquier letra y luego de enter)");
        car.moveForward(die()*100);
        showMove(car);
    }

    /**
     * Metodo para informar los movimientos de cada carro durante el juego
     * @param car: Carro que realiza el movimiento
     */
    void showMove(Car car){
        System.out.println("El carro #" + car.getId()
                + " alcanza: " + car.getRecorrido()
                + " mts/" +roadService.getRoad().getDistance() + " mts");
    }

    /**
     * Metodo para mostrar cuando un carro alcanza la meta
     * @param car: Carro que alcanza la meta
     */
    private void showWind(Car car){
        Player player = playerService.getPlayers().get(car.getId());
        System.out.println("El carro #" + car.getId()
                + "(conductor: " + player.getName() + ")"
                + " ha llegado a la meta!"
                + "--------------------------> Has Llegado!");
    }

    /**
     * Metodo para seleccionar aleatoriamente dentro de la ejecucion de la carrera
     * @param value: Rango del numero aleatorio, que corresponde al tamaño de la lista de autos aun en carrera
     * @return int: indice del auto que se moverá
     */
    private int randomCarToPlay(int value){
        return (int)(Math.random()*(value));
    }

    /**
     * Identificador del juego en cada nueva carrera
     * @param i: identificador del juego
     */
    private void gameIndex(int i){
        System.out.println("**********************************************");
        System.out.println("************=======Game#"+(i+1)+"=======**************");
        System.out.println("**********************************************");

    }

    /**
     * Recopilacion de datos del juego
     */
    private void recopileDataGame(){
        System.out.println("**********************************************");
        System.out.println("******Welcome to game of car by console!******");
        System.out.println("***********************************************");
        playerService.createPlayers(); //Creamos lista de jugadores
    }
}
