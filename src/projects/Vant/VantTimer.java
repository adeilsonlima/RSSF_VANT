package projects.Vant;

import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

import jsensor.nodes.Node;
import jsensor.nodes.events.TimerEvent;

public class VantTimer extends TimerEvent {
	private SortedSet<Node> neighbourList;
	private SortedSet<Integer> neighbourListIDs;
	private LinkedList<Integer> measuredMeters;

	public VantTimer() {
		neighbourListIDs = new TreeSet<>();
	}

	@Override
	public void fire() {
		neighbourList = this.node.getNeighbours().getNodesList();
		for (Node node : neighbourList) {
			neighbourListIDs.add(node.getID());
		}

		for (int i = 0; i < measuredMeters.size(); ++i) {
			if (neighbourListIDs.contains(measuredMeters.get(i))) {
				neighbourListIDs.remove(measuredMeters.get(i));
			}
		}
		VantMessage vmsg = new VantMessage(neighbourListIDs, (Vant) this.node);
		this.node.multicast(vmsg);

	}

	public LinkedList<Integer> getMeasuredMeters() {
		return measuredMeters;
	}

	public void setMeasuredMeters(LinkedList<Integer> measuredMeters) {
		this.measuredMeters = measuredMeters;
	}

}
