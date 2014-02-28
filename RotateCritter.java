// Specification:	critter which rotates all adjacent actors
// - moves normally
// - turns when there is an object in the way
// 
// 
// Needed variables/design:
// - main change is in the processActors method
// - no other changes
// - need to know the location of each actor
// - adjacent actors are the only ones that are rotated
// - rotates actors prior to moving (during processing)
import info.gridworld.actor.Actor; 
import info.gridworld.actor.Critter; 
import info.gridworld.actor.Flower; 
import info.gridworld.grid.Location; 
import info.gridworld.grid.Grid; 
import java.util.ArrayList;

public class RotateCritter extends Critter {
	
	public void processActors(ArrayList<Actor> actors) {
		int size = actors.size();
		Grid grid = getGrid();
		Actor a;
		int direction = 0;
		Location loc;
		Location initLoc;
		if (size < 2) {
			// super.act();
			return;
		}

		loc = getLocation().getAdjacentLocation(direction);
		a = this.getGrid().get(loc);

		while (a == null) {
			direction += 45;
			loc = getLocation().getAdjacentLocation(direction);
			a = this.getGrid().get(loc);
		}

		initLoc = getLocation().getAdjacentLocation(direction);
		loc = initLoc;

		Actor actorAtLoc = this.getGrid().get(loc);
		a = actorAtLoc;

		if (a != null) {
			a.removeSelfFromGrid();
		}

		for (int c = direction; c < 360; c+=45) {
			loc = getLocation().getAdjacentLocation(direction);
			Actor b = this.getGrid().get(loc);
			if (b != null) {
				b.removeSelfFromGrid();
				a.putSelfInGrid(grid, loc);
				a = b;
			}
		}
		if (a != null) {
			a.putSelfInGrid(grid, initLoc);
		}

		return;
	}

}