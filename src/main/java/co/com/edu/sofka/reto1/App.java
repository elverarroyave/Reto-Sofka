package co.com.edu.sofka.reto1;

import co.com.edu.sofka.reto1.service.GameService;
import co.com.edu.sofka.reto1.service.impl.GameServiceImpl;

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
