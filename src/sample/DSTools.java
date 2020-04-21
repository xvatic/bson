package sample;

import org.bson.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSTools {
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

                    if (doc.get("Shape").equals("Square")) {
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

            doc.append("Game", "Shooter");
            doc.append("Name", shooter.getName());
            doc.append("id", shooter.getId());

            //Shows that serialization really works
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

}
