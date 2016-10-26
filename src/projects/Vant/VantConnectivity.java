package projects.Vant;

import jsensor.nodes.Node;
import jsensor.nodes.models.ConnectivityModel;

public class VantConnectivity extends ConnectivityModel {

	@Override
	public boolean isConnected(Node from, Node to) {
		if (from instanceof Vant && to instanceof Medidor) {
			return true;
		} else if (from instanceof Medidor && to instanceof Vant) {
			return true;
		} else
			return false;
	}

}
