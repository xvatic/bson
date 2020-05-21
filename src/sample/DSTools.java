package sample;

import org.bson.Document;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSTools extends {
    public void writeBinaryForm(Document doc) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("file.ser"));
        stream.writeObject(doc);
        stream.writeObject(doc);
    }


    public List<Document> getAll(){
        List<Document> games = new ArrayList<>();
        Scanner sc = null;
        try {
            File file = new File("games");
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine().trim();
                if (!line.isEmpty()){
                    Document doc = Document.parse(line);
                    games.add(doc);
                }
            }
        }catch (Exception e){
            return null;
        }finally {
            if(sc != null){
                sc.close();
            }
        }
        return games;
    }
    public List<Games> getGames(){
        List<Games> games = new ArrayList<>();
        Scanner sc = null;
        try{
            File file = new File("games");
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    Document doc = Document.parse(line);
                    Games game = new Games((int) doc.get("id"));
                    games.add(game);

                }
            }

        }catch (Exception e){
            return null;
        }finally {
            if (sc != null){
                sc.close();
            }
        }
        return games;
    }
    public boolean deleteGame(Games game){
        List<Games> games = getGames();
        int preSize = games.size();

        Games deletedGame = null;

        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getId() == game.getId()) {
                deletedGame = games.get(i);
                games.remove(i);
                break;
            }
        }

        if (preSize == games.size()) {
            return false;
        }

        List<Document> docs = getAll();

        for (int i = 0; i < docs.size(); i++) {
            if ((int) docs.get(i).get("id") == deletedGame.getId()) {
                docs.remove(i);
                break;
            }
        }

        try (FileWriter writer = new FileWriter("games", false)) {
            for (Document value : docs) {
                writer.write("\n" + value.toJson());
            }
            writer.flush();
        } catch (IOException ex) {
            return false;
        }

        return true;

    }
    public Document getLatestAddedGame() {
        Document game1;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream("file.ser"));

            game1 = (Document) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                return null;
            }
        }

        return game1;
    }
    public List<Shooter> getShooters() {
        List<Shooter> shooters = new ArrayList<>();

        File file = new File("games");
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (!line.isEmpty()) {
                    Document doc = Document.parse(line);

                    if (doc.get("Games").equals("Shooter")) {
                        Shooter shooter = new Shooter((int) doc.get("id"), (String) doc.get("name"));
                        shooters.add(shooter);
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return shooters;
    }


    public boolean setShooters(Shooter shooter) {
        try(FileWriter writer = new FileWriter("games", true)) {
            Document doc = new Document();

            doc.append("Games", "Shooter");
            doc.append("name", shooter.getName());
            doc.append("id", shooter.getId());

            writeBinaryForm(doc);
            doc = getLatestAddedGame();

            writer.write("\n" + doc.toJson());

            writeBinaryForm(doc);

            writer.flush();
        } catch(IOException ex){
            return false;
        }

        return true;
    }
    public List<Racing> getRacings() {
        List<Racing> racings = new ArrayList<>();

        File file = new File("games");
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (!line.isEmpty()) {
                    Document doc = Document.parse(line);

                    if (doc.get("Games").equals("Racing")) {
                        Racing racing = new Racing((int) doc.get("id"), (String) doc.get("name"),
                                (int) doc.get("carsAmount"));
                        racings.add(racing);
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return racings;
    }


    public boolean setRacing(Racing racing) {
        try(FileWriter writer = new FileWriter("games", true)) {
            Document doc = new Document();

            doc.append("Games", "Racing");
            doc.append("name", racing.getName());
            doc.append("carsAmount", racing.getCarsAmount());
            doc.append("id", racing.getId());


            writeBinaryForm(doc);
            doc = getLatestAddedGame();

            writer.write("\n" + doc.toJson());

            writeBinaryForm(doc);

            writer.flush();
        } catch(IOException ex){
            return false;
        }
        return true;
    }

    public List<Indie> getIndies() {
        List<Indie> indies = new ArrayList<>();

        File file = new File("games");
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (!line.isEmpty()) {
                    Document doc = Document.parse(line);

                    if (doc.get("Games").equals("Indie")) {
                        Indie indie = new Indie((int) doc.get("id"), (String) doc.get("name"),
                                (String) doc.get("level"));
                        indies.add(indie);
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return indies;
    }


    public boolean setIndies(Indie indie) {
        try(FileWriter writer = new FileWriter("games", true)) {
            Document doc = new Document();

            doc.append("Games", "Indie");
            doc.append("name", indie.getName());
            doc.append("level", indie.getLevel());
            doc.append("id", indie.getId());


            writeBinaryForm(doc);
            doc = getLatestAddedGame();

            writer.write("\n" + doc.toJson());

            writeBinaryForm(doc);

            writer.flush();
        } catch(IOException ex){
            return false;
        }
        return true;
    }

    public List<Stealth> getStealthes() {
        List<Stealth> stealthes = new ArrayList<>();

        File file = new File("games");
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (!line.isEmpty()) {
                    Document doc = Document.parse(line);

                    if (doc.get("Games").equals("Stealth")) {
                        Stealth stealth = new Stealth((int) doc.get("id"), (String) doc.get("name"),
                                (String) doc.get("hero"));
                        stealthes.add(stealth);
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return stealthes;
    }


    public boolean setStealthes(Stealth stealth) {
        try(FileWriter writer = new FileWriter("games", true)) {
            Document doc = new Document();

            doc.append("Games", "Stealth");
            doc.append("name", stealth.getName());
            doc.append("hero", stealth.getHero());
            doc.append("id", stealth.getId());


            writeBinaryForm(doc);
            doc = getLatestAddedGame();

            writer.write("\n" + doc.toJson());

            writeBinaryForm(doc);

            writer.flush();
        } catch(IOException ex){
            return false;
        }
        return true;
    }
    public List<Fighting> getFightings() {
        List<Fighting> fightings = new ArrayList<>();

        File file = new File("games");
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (!line.isEmpty()) {
                    Document doc = Document.parse(line);

                    if (doc.get("Games").equals("Fighting")) {
                        Fighting fighting = new Fighting((int) doc.get("id"), (String) doc.get("name"),
                                (int) doc.get("prizePool"));
                        fightings.add(fighting);
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return fightings;
    }


    public boolean setFightings(Fighting fighting) {
        try(FileWriter writer = new FileWriter("games", true)) {
            Document doc = new Document();

            doc.append("Games", "Fighting");
            doc.append("name", fighting.getName());
            doc.append("prizePool", fighting.getPrizePool());
            doc.append("id", fighting.getId());


            writeBinaryForm(doc);
            doc = getLatestAddedGame();

            writer.write("\n" + doc.toJson());

            writeBinaryForm(doc);

            writer.flush();
        } catch(IOException ex){
            return false;
        }
        return true;
    }



    public List<Games> getAdditional(Games obj) {
        Class addClass = obj.getClass();
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Games> additional = new ArrayList<>();


        File file = new File("games");
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (!line.isEmpty()) {
                    Document doc = Document.parse(line);

                    if (doc.get("Games").equals(addClass.getName())) {
                        Object addObj = addClass.newInstance();

                        /*Fighting fighting = new Fighting((int) doc.get("id"), (String) doc.get("name"),
                                (int) doc.get("prizePool"));*/
                       ((Games) addObj).setId((int) doc.get("id"));
                       int i = 1;
                       for(Field field: fields) {
                           java.lang.annotation.Annotation annotation = field.getAnnotation(Deprecated.class);
                           if (annotation == null) {
                               continue;
                           }

                           field.setAccessible(true);
                           if (i == 1) {
                               field.set(addObj, (Object) doc.get(("name")));
                               i += 1;
                               field.setAccessible(false);
                               continue;
                           }
                           field.set(addObj, (Object) doc.get("additional"));


                           field.setAccessible(false);

                       }

                        additional.add((Games) addObj);
                    }

                }
            }
        } catch (Exception e) {
            return null;
        }

        return additional;
    }

    public boolean setAdditional(Games obj) {
        Object addVal1 = null;
        Object addVal2 = null;
        try(FileWriter writer = new FileWriter("games", true)) {
            Document doc = new Document();
            Field[] fields = obj.getClass().getDeclaredFields();
            int i=1;
            for(Field field: fields){
                java.lang.annotation.Annotation annotation = field.getAnnotation(Deprecated.class);
                if (annotation == null){
                    continue;
                }

                field.setAccessible(true);
                if (i==1) {
                    addVal1 = field.get(obj);
                    i += 1;
                    field.setAccessible(false);
                    continue;
                }
                addVal2 = field.get(obj);

                field.setAccessible(false);

            }


            doc.append("Games", obj.getClass().getName());
            doc.append("name", addVal1);
            doc.append("additional", addVal2);
            doc.append("id", obj.getId());


            writeBinaryForm(doc);
            doc = getLatestAddedGame();

            writer.write("\n" + doc.toJson());

            writeBinaryForm(doc);

            writer.flush();
        } catch(IOException | IllegalAccessException ex){
            return false;
        }
        return true;
    }


}
