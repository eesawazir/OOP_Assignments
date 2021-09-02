package game;

import edu.monash.fit2099.demo.KickAction;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Implements a Researcher who holds the rocket engine.
 *  It is weaker and does less damage than Grunt.
 *  When knocked out, it drops the engine
 * 
 * @author Eesa 
 *
 */
public class Miniboss extends Actor {
	private Random rand = new Random();
	// Miniboss has 25 hitpoints and is represented with a M
	public Miniboss(String name, Actor player) {
		super(name, 'M', 3, 25);
	}


	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(2, "punches");
	}
	
	
	public List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return actions.get(rand.nextInt(actions.size()));
	}


}

