package sample;

import java.util.List;

public class AutoIncrement {

    public int autoIncrement() {
        SerializingTools ser = new SerializingTools();
        List<Game> games = ser.getGames();

        int max = 0;

        if (getUnUsedId(games) >= 0) {
            return getUnUsedId(games);
        }

        for (Game game : games) {
            if (game.getId() > max) {
                max = game.getId();
            }
        }

        return ++max;
    }

    private int getUnUsedId(List<Game> games) {
        int unUsedId = 0;

        boolean flag = true;

        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getId() != i) {
                unUsedId = i;

                for (int j = i + 1; j < games.size(); j++) {
                    if (unUsedId == games.get(j).getId()) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    break;
                }

                flag = true;
            }
        }

        int count = 0;
        for (Game game : games) {
            if (game.getId() == unUsedId) {
                count++;
            }
        }

        if (count == 0) {
            return unUsedId;
        } else {
            return -1;
        }
    }
}

