package sample;

import org.bson.Document;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ObjectEditingService {
    private static List<Game> types = new ArrayList<Game>();
    public Document getLatestAddedShape(){
        SerializingTools ser = new SerializingTools();
        return ser.getLatestAddedGame();
    }


    public boolean delete(Game game) {
        SerializingTools ser = new SerializingTools();
        IdCheck idCheck = new IdCheck();

        if (idCheck.uniqueId(game)) {
            return false;
        }

        return ser.deleteGame(game);
    }

    public List<Shooter> getShooter(){
        SerializingTools ser = new SerializingTools();
        return ser.getShooters();
    }

    public boolean setShooter(Shooter shooter) {
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
        return ser.getRacings();
    }


    public boolean setRacing(Racing racing) {
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
        return ser.getIndies();
    }


    public boolean setIndie(Indie indie) {
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
        return ser.getStealthes();
    }


    public boolean setStealth(Stealth stealth) {
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
        return ser.getFightings();
    }


    public boolean setFighting(Fighting fighting) {
        SerializingTools ser = new SerializingTools();
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
        SerializingTools ser = new SerializingTools();
        IdCheck idCheck = new IdCheck();

        if (fighting.getId() < 0 || fighting.getName() == null || fighting.getPrizePool() <= 0) {
            return false;
        }

        if (!idCheck.uniqueId(fighting)) {
            return false;
        }

        return ser.setFightings(fighting);
    }

    public List<Game> getAdditional(Game obj, AdditionalProcessing fun) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        SerializingTools ser = new SerializingTools();
        return ser.getAdditional(obj, fun);
    }

    public boolean deleteAdditional(Game obj, int id){
        SerializingTools ser = new SerializingTools();
        obj.setId(id);
        return ser.deleteGame(obj);
    }

    public void changeAdditional(Game obj, int id, String name, Object parameter, AdditionalProcessing fun) throws IllegalAccessException {
        SerializingTools ser = new SerializingTools();
        Collections.addAll(types, obj);
        deleteAdditional(obj, id);
        obj.setId(id);
        Field[] fields = obj.getClass().getDeclaredFields();
        int i=1;
        for(Field field: fields){
            java.lang.annotation.Annotation annotation = field.getAnnotation(Deprecated.class);


            if (annotation == null){
                continue;
            }

            field.setAccessible(true);
            field.getType();
            if (i==1){
                field.set(obj, name);
                i+=1;
                field.setAccessible(false);
                continue;
            }
            field.set(obj, parameter);
            field.setAccessible(false);

        }
        ser.setAdditional(obj, fun);

    }


    public void addNewClass(Game obj, String name, Object parameter, AdditionalProcessing fun) throws IllegalAccessException {
        SerializingTools ser = new SerializingTools();
        Collections.addAll(types, obj);
        Field[] fields = obj.getClass().getDeclaredFields();
        int i=1;
        for(Field field: fields){
            java.lang.annotation.Annotation annotation = field.getAnnotation(Deprecated.class);


            if (annotation == null){
                continue;
            }

            field.setAccessible(true);
            field.getType();
            if (i==1){
                field.set(obj, name);
                i+=1;
                field.setAccessible(false);
                continue;
            }
            field.set(obj, parameter);
            field.setAccessible(false);

        }
        ser.setAdditional(obj, fun);

    }

}
