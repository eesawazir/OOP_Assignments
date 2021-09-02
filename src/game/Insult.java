package game;

import java.util.Random;

import game.ActionFactory;
import edu.monash.fit2099.engine.*;
/**
 * Implements a behaviour that causes Goon to insult the target i.e Player.
 * 
 * @author Eesa 
 *
 */
public class Insult extends Action implements ActionFactory{

	private Actor target;

	public Insult(Actor subject) {
		this.target = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (Math.random()<=0.1) {
			return actor + " insults " + target ;
		}
		return null;
		
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
