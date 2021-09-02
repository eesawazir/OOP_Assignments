package game;

import java.util.Arrays;
import java.util.List;

//import edu.monash.fit2099.demo.DemoSkills;
import edu.monash.fit2099.engine.*;
public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(),new WaterPool());
		GameMap gameMap;
		GameMap moon;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#........#....#....",
				"....#####....##.###....",
				"...................oo..",
				"...................oo..",
				"...ooo.................",
				"..ooooo................",
				"...ooo.................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		List<String> moonMap = Arrays.asList(
                ".......................",
                ".......................",
                ".......................",
                ".......................",
                ".......................",
                ".......................",
                ".......................",
                ".......................",
                ".......................",
                ".......................");
        moon = new GameMap(groundFactory, moonMap);
        world.addMap(moon);
        
        Item rocket = Item.newFurniture("Rocket", '^');
        rocket.getAllowableActions().add(new MoveActorAction(moon.at(1, 2), "to the Moon!"));
        gameMap.addItem(rocket, 1, 1);
		
        Item moonRocket = Item.newFurniture("Rocket", '^');
        moonRocket.getAllowableActions().add(new MoveActorAction(gameMap.at(1, 2), "back to earth"));
        moon.addItem(moonRocket, 1, 3);
        
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		
		// Key created to unlock door
		Item key = new Item("Pu-Key", 'K');
		
		// Grunt created 
		//Grunt grunt = new Grunt("Mongo", player);
		//gameMap.addActor(grunt, 0, 0);
		//grunt.addItemToInventory(key);
		
		// Grunt created 
		Grunt grunt2 = new Grunt("Norbert", player);
		grunt2.addItemToInventory(key);
		gameMap.addActor(grunt2,  10, 10);
		
		//Moon Grunt created 
		Grunt moonGrunt = new Grunt("Morbert", player);
		moon.addActor(moonGrunt,  5, 7);
		
		// Goon created 
		Goon goon = new Goon("Noris", player);
		goon.addItemToInventory(key);
		gameMap.addActor(goon,  5,5 );
		
		// Ninja created 
		Ninja ninja=new Ninja("Moris", player);
		gameMap.addActor(ninja,  8,7 );
		
		// Engine created
		Item engine = new Item("Rocket Engine", 'E');
		
		// Miniboss created 
		Miniboss doc = new Miniboss("Doctor Maybe", player);
		doc.addItemToInventory(engine);
		gameMap.addActor(doc, 6, 3);
		
		// Q created 
		Q q = new Q("Q", player);
		gameMap.addActor(q, 9, 8);
        
		// Rocket plan created 
		Item rocketPlan = new Item("Rocket plan", 'P');
        
		// Engine body created and added to q inventory
		Item body = new Item("Engine body", 'B');
        q.addItemToInventory(body);
        
        // place rocket plan on the map
        gameMap.addItem(rocketPlan, 15, 3);
        
        // Door created and put together with wall
        Door door = new Door(key);
        gameMap.add(door, gameMap.at(8, 3));
        
        // Door created and put together with wall
        Door door2 = new Door(key);
        gameMap.add(door2, gameMap.at(15, 4));
        
        // Rocket pad created 
        //RocketPad rocketpad = new RocketPad(engine,body);
        //gameMap.add(rocketpad, gameMap.at(10, 8));
        
        Item spaceSuit = new Item("space suit", '$');
        gameMap.addItem(spaceSuit, 0, 1);
		
        Item waterPistol = new WeaponItem("water gun", '>', 20, "pew");
        moon.addItem(waterPistol, 8, 2);
        
        // Yugo Maxx created 
 		YugoMaxx fboss = new YugoMaxx("Yugo Maxx", player);
 		moon.addActor(fboss, 5, 12);
 		fboss.addItemToInventory(key);
 		
 		world.run();
	}
}
