package projects.Vant;

import jsensor.nodes.Node;
import jsensor.nodes.models.DistributionModelNode;
import jsensor.utils.Position;

public class MeterDistribution extends DistributionModelNode {
	private static int nHouses = 50	;

	@Override
	public Position getPosition(Node node) {
		int id = node.getID();
		int div = id / nHouses;
		int rest = id % nHouses;
		int posX, posY;

		if (div % 2 == 0) {
			posX = rest * 15;
			posY = div * 37;
		} else {
			posX = (nHouses - rest) * 15;
			posY = div * 37+23;
		}
		return new Position(posX, posY);
	}

}
