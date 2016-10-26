package projects.Vant;

import jsensor.nodes.Node;
import jsensor.nodes.models.DistributionModelNode;
import jsensor.utils.Position;

public class VantDistribution extends DistributionModelNode {

	@Override
	public Position getPosition(Node node) {
		return new Position(0, 0);
	}

}
