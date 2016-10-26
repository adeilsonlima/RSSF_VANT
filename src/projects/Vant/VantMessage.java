package projects.Vant;

import java.util.SortedSet;

import jsensor.nodes.messages.Message;

public class VantMessage extends Message {

	private SortedSet<Integer> meterIDs;
	private Vant vant;

	public VantMessage(SortedSet<Integer> neighbourListIDs, Vant vant) {
		this.meterIDs = neighbourListIDs;
		this.vant = vant;
	}

	@Override
	public Message clone() {
		return new VantMessage(meterIDs, vant);
	}

	public SortedSet<Integer> getMeterIDs() {
		return meterIDs;
	}

	public void setMeterIDs(SortedSet<Integer> meterIDs) {
		this.meterIDs = meterIDs;
	}

	public Vant getVant() {
		return vant;
	}

	public void setVant(Vant vant) {
		this.vant = vant;
	}

}
