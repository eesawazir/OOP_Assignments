package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Implements an actor that interacts with the rocket plan and body.  
 * 
 * @author Eesa
 *
 */
public class Q extends Actor {
	Item plan;
	Item body;
	
	public Q(String name, Actor player) {
		super(name, 'Q', 5, 50);
		addBehaviour(new Talk(player,plan,body));
	}
	
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
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

