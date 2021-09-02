package game;

import java.util.Random;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class FillWaterPistol extends Action {

	private String direction;
	private Location poolLocation;
	private Random rand = new Random();
	
	public FillWaterPistol(String direction, Location poolLocation) {
		this.direction = direction;
		this.poolLocation = poolLocation;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		map.add(new Floor(), poolLocation);
		return "Water pistol filled";
		
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " fills water pistol " + direction;
	}

	@Override
	public String hotKey() {
		return "";
	}
}