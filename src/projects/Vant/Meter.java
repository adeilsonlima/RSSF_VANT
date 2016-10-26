package projects.Vant;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;
import jsensor.utils.Configuration;

public class Meter extends Node {
	private Integer measuredValue;
	private MeterTimer mt;

	@Override
	public void handleMessages(Inbox inbox) {
		Message m = inbox.getNextMessage();

		if (m instanceof VantMessage) {
			//Se o medidor esta na lista do vant
			if (((VantMessage) m).getMeterIDs().contains(this.ID)) {
				int x1 = ((VantMessage) m).getVant().getPosition().getPosX();
				int x2 = this.getPosition().getPosX();
				int y1 = ((VantMessage) m).getVant().getPosition().getPosY();
				int y2 = this.getPosition().getPosY();
				double distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
				
				measuredValue = this.getRandom().nextInt();
				mt.setMeasuredValue(measuredValue);
				mt.setVant(((VantMessage) m).getVant());

				// agenda transmissao de acordo com o slot ao qual pertence
				if (distance <= (Configuration.nodeRadios[1]) / 3) {
					mt.startRelative(1 + 0.5 * this.getRandom().nextDouble(), this);
				} else if (distance <= (2 / 3) * (Configuration.nodeRadios[1])) {
					mt.startRelative(0.5 + 0.5 * this.getRandom().nextDouble(), this);
				} else {
					mt.startRelative(0.5 * this.getRandom().nextDouble(), this);
				}
			}

		}

	}

	@Override
	public void onCreation() {
		mt = new MeterTimer();

	}

	public Integer getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(Integer measuredValue) {
		this.measuredValue = measuredValue;
	}

}
