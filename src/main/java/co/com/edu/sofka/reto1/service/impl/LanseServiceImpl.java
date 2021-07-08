package co.com.edu.sofka.reto1.service.impl;

import co.com.edu.sofka.reto1.model.Lane;
import co.com.edu.sofka.reto1.service.LaneService;
import co.com.edu.sofka.reto1.model.Player;

import java.util.ArrayList;
import java.util.List;

public class LanseServiceImpl implements LaneService {
    List<Lane> lanes = new ArrayList<>();

    @Override
    public void createLanes(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            Lane lane = new Lane(
                    i,
                    players.get(i).getDriver().getCar()
            );
            lanes.add(lane);
        }
    }

    @Override
    public void resetLanes() {
        lanes.clear();
    }

    @Override
    public List<Lane> getAllLanes() {
        return lanes;
    }
}
