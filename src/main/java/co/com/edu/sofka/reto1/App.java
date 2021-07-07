package co.com.edu.sofka.reto1;

import co.com.edu.sofka.reto1.model.Game;
import co.com.edu.sofka.reto1.model.Player;
import co.com.edu.sofka.reto1.service.GameService;
import co.com.edu.sofka.reto1.service.PlayerService;
import co.com.edu.sofka.reto1.service.impl.GameServiceImpl;
import co.com.edu.sofka.reto1.service.impl.PlayerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        init();
    }

    private static void init(){
        GameService gameService = new GameServiceImpl();
        gameService.createGame();
    }
}
