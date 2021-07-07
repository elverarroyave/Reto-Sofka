package co.com.edu.sofka.reto1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Road {

    private Integer id;

    private float distance;

    private List<Lane> lanes;

    public Road(){}

    public Road(Integer id, float distance, List<Lane> lanes) {
        this.id = id;
        this.distance = distance;
        this.lanes = lanes;
    }
}
