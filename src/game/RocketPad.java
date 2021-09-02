package game;

import edu.monash.fit2099.engine.*;

/**
 * Implements a part of the ground which when the player goes to checks
 * whether the player has the rocket body and engine. If he does then, it 
 * builds the respective rocket part. 
 *
 * @author Eesa
 *
 */

public class RocketPad extends Ground{
    private Rocket rocket;
    private Item engine;
    private Item body;
    

    public RocketPad(Item engine, Item body) {
        super('R');
        this.engine = engine;
        this.body = body;
        
    }
    
    public void buildEngine(Actor actor) {
        rocket.engineBuilt = true;
        actor.getInventory().remove(engine);
    }
    
    public void buildBody(Actor actor) {
        rocket.bodyBuilt = true;
        actor.getInventory().remove(body);
    }


    public void prepare(Actor actor) {
        actor.getInventory().remove(engine);
        actor.getInventory().remove(body);
    }


    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();
        if (actor.getInventory().contains(engine)) {
            actions.add(new addRocketEngine(this));
        }
        if (actor.getInventory().contains(body)) {
            actions.add(new addRocketBody(this));
        }

        return actions;
    }
}

