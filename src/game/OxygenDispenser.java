package game;

import edu.monash.fit2099.engine.*;

public class OxygenDispenser extends Ground {
	private Item tank;
	
    public OxygenDispenser() {
        super('D');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {

    	return new Actions(new ProduceOxygenTank(direction, this));      
    }
}
