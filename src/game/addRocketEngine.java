package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Implements action which is building of the rockey engine. 
 * 
 * @author Eesa
 *
 */
public class addRocketEngine extends Action {
    private RocketPad rocketPad;

    public addRocketEngine(RocketPad pad) {
        this.rocketPad = pad;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        rocketPad.buildEngine(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is building rocket engine ";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
