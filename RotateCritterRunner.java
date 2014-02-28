import info.gridworld.actor.Actor; 
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock; 
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower; 

import java.awt.Color;


public class RotateCritterRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        RotateCritter broladin = new RotateCritter();
        Actor actor = new Actor();
        Actor actor2 = new Actor();

        actor.setColor(Color.RED);
        broladin.setColor(Color.BLACK);
        world.add(new Location(5, 5), broladin);
        world.add(new Location(4, 5), actor);
        world.add(new Location(4, 6), actor2);
        // world.add(new Location(6, 6), new Actor(Color.BLACK));
        world.add(new Location(5, 4), new Flower(Color.BLUE));
        world.show();
    }
}