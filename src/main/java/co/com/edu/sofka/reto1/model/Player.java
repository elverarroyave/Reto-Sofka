package co.com.edu.sofka.reto1.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "JUGADOR")
public class Player implements Serializable {

    private static  final long serialVersionUID = 99L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_JUGADOR")
    private Integer id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "PUNTOS_POSICION_UNO")
    private int firstPositionPoints = 0;

    @Column(name = "PUNTOS_POSICION_DOS")
    private int secondPositionPoints = 0;

    @Column(name = "PUNTOS_POSICION_TRES")
    private int thirdPositionPoints = 0;

    @Transient //Ignora este parametro en la persistencia
    private Driver driver;

    public Player(){}

    public Player(Integer id, String name, Driver driver) {
        this.id = id;
        this.name = name;
        this.driver = driver;
    }

    public Player(String name, int firstPositionPoints, int secondPositionPoints, int thirdPositionPoints) {
        this.name = name;
        this.firstPositionPoints = firstPositionPoints;
        this.secondPositionPoints = secondPositionPoints;
        this.thirdPositionPoints = thirdPositionPoints;
    }

    public void addFirstPoint(){
        this.firstPositionPoints++;
    }

    public void addSecondPoint(){
        this.secondPositionPoints++;
    }

    public void addThirdPoint(){
        this.thirdPositionPoints++;
    }
}
