package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;
/**
 * Implements an enemy called Goon. It is similar to Grunt but it has an 
 * additional behaviour where it can insult the Actor player.
 * 
 * @author Eesa 
 *
 */
public class Goon extends Actor {
	
	public Goon(String name, Actor player) {
		super(name, 'G', 5, 50);
		addBehaviour(new FollowBehaviour(player));
		addBehaviour(new Insult(player)); // New behaviour Insult added to enemy Goon
	}
	
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "beats");
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		return super.playTurn(actions,  map,  display);
	}
	
}
