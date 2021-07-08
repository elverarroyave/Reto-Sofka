package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Player;
import co.com.edu.sofka.reto1.model.Road;
import co.com.edu.sofka.reto1.service.LaneService;
import co.com.edu.sofka.reto1.service.RoadService;

import java.util.List;
import java.util.Scanner;

public class RoadServiceImpl implements RoadService {

    Scanner in = new Scanner(System.in);

    LaneService laneService = new LanseServiceImpl();

    Road road = new Road();

    @Override
    public void createRoad(List<Player> players) {
        System.out.print("Ingresa la distancia de la pista(Km): ");
        float distanceToRoad = in.nextFloat()*1000;//Distancia convertida a metros
        laneService.createLanes(players);

        road = new Road(
                99,
                distanceToRoad,
                laneService.getAllLanes()
        );
    }

    @Override
    public Road getRoad() {
        return road;
    }

    @Override
    public void resetRoad() {
        laneService.resetLanes();
    }

    @Override
    public void roadDetail() {
        System.out.println("Distancia de la pista: " + road.getDistance());
        System.out.println("Cantidad de carriles: " + road.getLanes().size());
    }


}
