package projects.Vant;

import java.util.HashMap;
import java.util.LinkedList;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;
import jsensor.utils.Configuration;

public class Vant extends Node {

	private Directions direction;
	private int jumpNorth;
	private LinkedList<Integer> measuredMeters;
	private HashMap<Integer, Integer> measuredValues;
	private VantTimer vTime;

	@Override
	public void handleMessages(Inbox inbox) {
		while (inbox.hasMoreMessages()) {
			Message m = inbox.getNextMessage();

			if (m instanceof MeterMessage) {
				measuredValues.put(((MeterMessage) m).getSenderID(), ((MeterMessage) m).getValue());
				measuredMeters.add(((MeterMessage) m).getSenderID());
			}
			if (!inbox.hasMoreMessages()) {
				vTime.setMeasuredMeters(measuredMeters);
				vTime.startRelative(0.1, this);
			}
		}

	}

	@Override
	public void onCreation() {
		measuredMeters = new LinkedList<>();
		measuredValues = new HashMap<>();
		setDirection(Directions.east);
		setJumpNorth(0);

		VantMobility vm = new VantMobility();
		vm.start(this, 1, Configuration.numberOfRounds, 1.5);

		vTime = new VantTimer();
		vTime.setMeasuredMeters(measuredMeters);
		vTime.startRelative(1, this);

	}

	public Directions getDirection() {
		return direction;
	}

	public void setDirection(Directions direction) {
		this.direction = direction;
	}

	public int getJumpNorth() {
		return jumpNorth;
	}

	public void setJumpNorth(int jumpNorth) {
		this.jumpNorth = jumpNorth;
	}

	public LinkedList<Integer> getMeterIDs() {
		return measuredMeters;
	}

	public void setMeterIDs(LinkedList<Integer> meterIDs) {
		this.measuredMeters = meterIDs;
	}

	public HashMap<Integer, Integer> getMeasuredValues() {
		return measuredValues;
	}

	public void setMeasuredValues(HashMap<Integer, Integer> measuredValues) {
		this.measuredValues = measuredValues;
	}

}
