package game;

import edu.monash.fit2099.engine.*;

/**
 * This implements a door which is placed on the map and it can be unlocked 
 * with a key which when used is remove from actor(player) inventory.
 * 
 * @author Eesa
 *
 */
public class Door extends Ground {
    /** The key to unlock this door. */
    private Item key;
    /** Checks if the door is locked. If it is, players cannot pass through it. */
    private boolean isLocked = true;

    public Door(Item key) {
        super('|');
        this.key = key;
    }

    public void unlock(Actor actor) {
        isLocked = false;
        displayChar = '_';

        // Expend the key
        actor.getInventory().remove(key);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return !isLocked;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();
        if (actor.getInventory().contains(key)) {
            actions.add(new UnlockDoorAction(direction, this));
        }

        return actions;
    }
}
