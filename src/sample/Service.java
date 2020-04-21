package sample;

import org.bson.Document;

import java.util.List;

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

    public List<Shooter> getShooter(){
        DSTools ser = new DSTools();
        return ser.getShooters();
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

    public boolean changeShooter(Shooter shooter){
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (shooter.getId() < 0 || shooter.getName() == null) {
            return false;
        }

        if (idCheck.uniqueId(shooter)) {
            return false;
        }
        delete(shooter);
        return ser.setShooters(shooter);
    }



    public List<Racing> getRacing() {
        DSTools ser = new DSTools();
        return ser.getRacings();
    }


    public boolean setRacing(Racing racing) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (racing.getId() < 0 || racing.getName() == null || racing.getCarsAmount() <= 0) {
            return false;
        }

        if (!idCheck.uniqueId(racing)) {
            return false;
        }

        return ser.setRacing(racing);
    }


    public boolean changeRacing(Racing racing) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (racing.getId() < 0 || racing.getName() == null || racing.getCarsAmount() <= 0) {
            return false;
        }

        if (idCheck.uniqueId(racing)) {
            return false;
        }
        delete(racing);
        return ser.setRacing(racing);
    }

    public List<Indie> getIndie() {
        DSTools ser = new DSTools();
        return ser.getIndies();
    }


    public boolean setIndie(Indie indie) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (indie.getId() < 0 || indie.getName() == null || indie.getLevel() == null) {
            return false;
        }

        if (!idCheck.uniqueId(indie)) {
            return false;
        }

        return ser.setIndies(indie);
    }


    public boolean changeIndie(Indie indie) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (indie.getId() < 0 || indie.getName() == null || indie.getLevel() == null) {
            return false;
        }

        if (idCheck.uniqueId(indie)) {
            return false;
        }
        delete(indie);
        return ser.setIndies(indie);
    }

    public List<Stealth> getStealth() {
        DSTools ser = new DSTools();
        return ser.getStealthes();
    }


    public boolean setStealth(Stealth stealth) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (stealth.getId() < 0 || stealth.getName() == null || stealth.getHero() == null) {
            return false;
        }

        if (!idCheck.uniqueId(stealth)) {
            return false;
        }

        return ser.setStealthes(stealth);
    }


    public boolean changeStealth(Stealth stealth) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (stealth.getId() < 0 || stealth.getName() == null || stealth.getHero() == null) {
            return false;
        }

        if (idCheck.uniqueId(stealth)) {
            return false;
        }
        delete(stealth);
        return ser.setStealthes(stealth);
    }

    public List<Fighting> getFighting() {
        DSTools ser = new DSTools();
        return ser.getFightings();
    }


    public boolean setFighting(Fighting fighting) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (fighting.getId() < 0 || fighting.getName() == null || fighting.getPrizePool() <= 0) {
            return false;
        }

        if (!idCheck.uniqueId(fighting)) {
            return false;
        }

        return ser.setFightings(fighting);
    }


    public boolean changeFighting(Fighting fighting) {
        DSTools ser = new DSTools();
        IdCheck idCheck = new IdCheck();

        if (fighting.getId() < 0 || fighting.getName() == null || fighting.getPrizePool() <= 0) {
            return false;
        }

        if (!idCheck.uniqueId(fighting)) {
            return false;
        }

        return ser.setFightings(fighting);
    }


}
