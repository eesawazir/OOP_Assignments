package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Range;

/**
 * Implements an action that causes ninja to throw stun powder at the Player. 
 * 
 * @author Eesa 
 *
 */
public class ThrowStun extends Action implements ActionFactory {
	private Actor target;

	public ThrowStun(Actor subject) {
		this.target = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		return actor + " throws stun bag at " + target + ".";
	}
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		Range xs, ys;
		if (here.x() == there.x() || here.y() == there.y()) {
			xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
			ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);

			for (int x : xs) {
				for (int y : ys) {
					if(map.at(x, y).getGround().blocksThrownObjects())
						return null;
				}
			}
			return this;
		}
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
