package sample;

import org.bson.Document;

public class Service {
    public Document getLatestAddedShape(){
        DSTools ser = new DSTools();
        return ser.getLatestAddedGame();
    }


    public boolean delete(Games game) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (idCheck.uniqueId(game)) {
            return false;
        }

        return ser.deleteGame(game);
    }
    public boolean setShooter(Shooter shooter) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (shooter.getId() < 0 || shooter.getName() == null) {
            return false;
        }

        if (!idCheck.uniqueId(shooter)) {
            return false;
        }

        return ser.setShooters(shooter);
    }

}
