package sample;

import java.util.List;

public class IdCheck {
    public boolean uniqueId(Game game) {
        SerializingTools sert = new SerializingTools();
        List<Game> games = sert.getGames();

        for (Game value : games) {
            if (value.getId() == game.getId()) {
                return false;
            }
        }

        return true;
    }

}
