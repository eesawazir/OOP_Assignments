package game;

import java.util.Random;

import game.ActionFactory;
import edu.monash.fit2099.engine.*;

/**
 * Implements a behaviour which causes an actor to communicate/talk with/to 
 * another actor. 
 * 
 * @author Eesa
 *
 */
public class Talk extends Action implements ActionFactory{

	private Actor target;
	private Item plan;
	private Item body;

	public Talk(Actor subject, Item plan, Item body) {
		this.target = subject;
		this.body=body;
		this.plan=plan;

	}
//lg
	@Override
	public String execute(Actor actor, GameMap map) {
		Actions actions = new Actions();
        if (actor.getInventory().contains(plan)) { // Check whether actor(Player) has rocket plans
        	actor.getInventory().remove(plan); // Remove plans from inventory(Q) if true
        	actor.removeItemFromInventory(body); // Remove rocket body from actor(Q)
        	
        }
        return actor + " plans were taken from " + target ;
		
	}
		
	
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
}
