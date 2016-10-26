package projects.Vant;

import java.util.LinkedList;

import jsensor.nodes.messages.Message;

public class VantMessage extends Message {

	private LinkedList<Long> meterIDs;
	@Override
	public Message clone() {
		// TODO Auto-generated method stub
		return null;
	}
	public LinkedList<Long> getMeterIDs() {
		return meterIDs;
	}
	public void setMeterIDs(LinkedList<Long> meterIDs) {
		this.meterIDs = meterIDs;
	}

}
