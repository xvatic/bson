package sample;

import com.sun.tools.classfile.ConstantPool;
import org.bson.Document;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Service {
    private static List<Games> types = new ArrayList<Games>();
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

    public List<Games> getAdditional(Games obj){
        DSTools ser = new DSTools();
        return ser.getAdditional(obj);
    }

    public boolean deleteAdditional(Games obj,int id){
        DSTools ser = new DSTools();
        obj.setId(id);
        return ser.deleteGame(obj);
    }

    public void changeAdditional(Games obj, int id, String name, Object parameter) throws IllegalAccessException {
        DSTools ser = new DSTools();
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
        ser.setAdditional(obj);

    }



    public void addNewClass(Games obj, String name, Object parameter) throws IllegalAccessException {
        DSTools ser = new DSTools();
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
        ser.setAdditional(obj);

    }



}
