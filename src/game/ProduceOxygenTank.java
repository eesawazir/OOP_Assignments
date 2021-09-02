package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class ProduceOxygenTank extends Action{
	private String direction;
	private Location tankLocation;
    private OxygenDispenser dispenser;
	
    public ProduceOxygenTank(String direction, OxygenDispenser dispenser) {
        this.direction = direction;
        this.dispenser = dispenser;
    }

	@Override
	public String execute(Actor actor, GameMap map) {
		map.add(new Floor(), tankLocation);
		return "Oxygen tank produced";

	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " starts oxygen production " + direction;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
