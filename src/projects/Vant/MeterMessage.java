package projects.Vant;

import jsensor.nodes.messages.Message;

public class MeterMessage extends Message {
	
	private int value;

	@Override
	public Message clone() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
