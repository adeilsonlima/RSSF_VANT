package projects.Vant;

import jsensor.nodes.messages.Message;

public class MeterMessage extends Message {
	
	private Integer value;
	private Integer senderID;
	
	public MeterMessage(Integer value, Integer senderID) {
		this.value = value;
		this.senderID =senderID;
	}

	@Override
	public Message clone() {
		return new MeterMessage(value, this.getSenderID());
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getSenderID() {
		return senderID;
	}

	public void setSenderID(Integer senderID) {
		this.senderID = senderID;
	}

}
