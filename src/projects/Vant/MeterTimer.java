package projects.Vant;

import jsensor.nodes.events.TimerEvent;

public class MeterTimer extends TimerEvent {
	private Integer measuredValue;
	private Vant vant;

	public MeterTimer() {
	}

	@Override
	public void fire() {
		MeterMessage msg = new MeterMessage(measuredValue, this.node.getID());
		this.node.unicast(msg, vant);

	}

	public Integer getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(Integer measuredValue) {
		this.measuredValue = measuredValue;
	}

	public Vant getVant() {
		return vant;
	}

	public void setVant(Vant vant) {
		this.vant = vant;
	}

}
