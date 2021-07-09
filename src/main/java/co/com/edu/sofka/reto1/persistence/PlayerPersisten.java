package co.com.edu.sofka.reto1.persistence;

import co.com.edu.sofka.reto1.model.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PlayerPersisten {

    private static EntityManager manager;
    //Creamos el gestor de persistencia (EM).
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public void initDB(){
        manager = emf.createEntityManager();
    }

    public void closeDB(){
        manager.close();
    }

    private void updatePointsPlayer(int id, int index) {
        manager.getTransaction().begin();
        Player e = manager.find(Player.class, id);
        switch (index){
            case 0: e.addFirstPoint();
            break;
            case 1:e.addSecondPoint();
            break;
            case 2:e.addThirdPoint();
        }
        manager.getTransaction().commit();
    }

    Player playerInDB;
    public void saveWinnersPlayers(List<Player> winnerPlayers) {
        int index = 0;
        for (Player win : winnerPlayers) {
            if(!validateExistPlayer(win.getName())){
                savePlayer(win);
            }else{
                updatePointsPlayer(playerInDB.getId(), index);
            }
            index++;
        }
    }

    private boolean validateExistPlayer(String name){
        boolean exist= false;
        for (Player player : getAllPlayers()) {
            if(player.getName().equalsIgnoreCase(name)){
                playerInDB = player;
                exist = true;
                break;
            }
        }
        return exist;
    }

    public void savePlayer(Player win){
        Player e = new Player(
                win.getName(),
                win.getFirstPositionPoints(),
                win.getSecondPositionPoints(),
                win.getThirdPositionPoints() );
        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Player> getAllPlayers(){
        List<Player> players = (List<Player>) manager.createQuery("FROM Player").getResultList();
        return players;
    }

    public void amountWinners(){
        List<Player> players = (List<Player>) manager.createQuery("FROM Player").getResultList();
        System.out.println("################Cantidad de ganadores es: " + players.size() + "###################");
    }

    public void showPlayers(List<Player> winners){
        List<Player> players = (List<Player>) manager.createQuery("FROM Player").getResultList();
        int index = 0;
        for (Player player : players) {
            for (int i = 0; i < 3; i++) {
                if(player.getName().equalsIgnoreCase(winners.get(i).getName())){
                    System.out.println((index + 1) + "° - " + player.getName());
                    System.out.println("Puntos de 1° posición -> " + player.getFirstPositionPoints());
                    System.out.println("Puntos de 2° posición -> " + player.getSecondPositionPoints());
                    System.out.println("Puntos de 3° posición -> " + player.getThirdPositionPoints());
                    index++;
                }
            }
        }
    }
}
