package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Implements action which is building of the rocket body. 
 * 
 * @author Eesa
 *
 */
public class addRocketBody extends Action {
    private RocketPad rocketPad;

    public addRocketBody(RocketPad pad) {
        this.rocketPad = pad;
    }

	@Override
    public String execute(Actor actor, GameMap map) {
        rocketPad.buildBody(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is building rocket body ";
    }

    @Override
    public String hotKey() {
        return "";
    }
}