package sample;

import java.util.List;

public class IdCheck {
    public boolean uniqueId(Games game) {
        DSTools sert = new DSTools();
        List<Games> games = sert.getGames();

        for (Games value : games) {
            if (value.getId() == game.getId()) {
                return false;
            }
        }

        return true;
    }

}
