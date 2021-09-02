package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * An action that causes the door to unlock.
 * 
 * @author Eesa
 *
 */
public class UnlockDoorAction extends Action {
    private String direction;
    private Door door;

    public UnlockDoorAction(String direction, Door door) {
        this.direction = direction;
        this.door = door;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        door.unlock(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " unlock door to the " + direction;
    }

    @Override
    public String hotKey() {
        return "";
    }
}
