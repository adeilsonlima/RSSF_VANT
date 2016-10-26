package projects.Vant;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;

public class Vant extends Node {
	
	private Directions direction;
	private int jumpNorth;

	@Override
	public void handleMessages(Inbox inbox) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreation() {
		setDirection(Directions.east);
		setJumpNorth(0);
		// TODO Auto-generated method stub

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

}
