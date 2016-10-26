package projects.Vant;

import jsensor.nodes.Node;
import jsensor.nodes.models.MobilityModel;
import jsensor.runtime.Jsensor;
import jsensor.utils.Configuration;
import jsensor.utils.Position;

public class VantMobility extends MobilityModel {
	public static int jump = 10;

	@Override
	public MobilityModel clone() {
		return new VantMobility();
	}

	@Override
	public Position getNextPosition(Node node) {
		Vant vant = (Vant) node;
		Position currentPosition = vant.getPosition();
		Position newPosition = currentPosition;

		switch (vant.getDirection()) {
		case east:
			if ((currentPosition.getPosX() + jump) <= Jsensor.getDimX()) {
				newPosition.setPosX(currentPosition.getPosX() + jump);
			} else if ((currentPosition.getPosY() + jump) < Jsensor.getDimY()) {
				vant.setDirection(Directions.north);
				vant.setJumpNorth(vant.getJumpNorth() + jump);
				newPosition.setPosY(currentPosition.getPosY() + jump);
			} else {
				newPosition.setPosX(0);
				newPosition.setPosY(0);
				vant.setDirection(Directions.east);
				vant.setJumpNorth(0);
			}
			break;
		case west:
			if ((currentPosition.getPosX() - jump) >= 0) {
				newPosition.setPosX(currentPosition.getPosX() - jump);
			} else if ((currentPosition.getPosY() + jump) < Jsensor.getDimY()) {
				vant.setDirection(Directions.north);
				vant.setJumpNorth(vant.getJumpNorth() + jump);
				newPosition.setPosY(currentPosition.getPosY() + jump);
			} else {
				newPosition.setPosX(0);
				newPosition.setPosY(0);
				vant.setDirection(Directions.east);
				vant.setJumpNorth(0);
			}
			break;
		case north:
			if (vant.getJumpNorth() <= 2 * Configuration.communicationRadios[1]) {
				if (currentPosition.getPosY() + jump < Jsensor.getDimY()) {
					vant.setJumpNorth(vant.getJumpNorth() + jump);
					newPosition.setPosY(currentPosition.getPosY() + jump);
				} else {
					newPosition.setPosX(0);
					newPosition.setPosY(0);
					vant.setDirection(Directions.east);
					vant.setJumpNorth(0);
				}
			} else if ((currentPosition.getPosX() + jump) < Jsensor.getDimX()) {
				newPosition.setPosX(currentPosition.getPosX() + jump);
				vant.setDirection(Directions.east);
				vant.setJumpNorth(0);
			} else {
				newPosition.setPosX(currentPosition.getPosX() - jump);
				vant.setDirection(Directions.west);
				vant.setJumpNorth(0);
			}
			break;
		default:
			break;
		}

		return newPosition;
	}

}
