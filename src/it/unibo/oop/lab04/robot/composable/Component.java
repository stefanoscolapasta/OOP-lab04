package it.unibo.oop.lab04.robot.composable;

public abstract class Component {
	private boolean isOn;
	private boolean isConnected;
	private ComposableRobot robot;
	
	public Component() {
		this.isOn = false;
		this.isConnected = false;
	}
	
	public void switchOn() {
		if(!this.isItOn() && this.isItConnected()) {
			this.isOn = true;
		}
	}

	public void switchOff() {
		if(this.isItOn() && this.isItConnected()) {
			this.isOn = false;
		}
	}
	
	public void connect(ComposableRobot robot) {
		if(!this.isItConnected()) {
			this.isConnected = true;
			this.robot = robot;
		}
	}

	public void disConnect() {
		if(this.isItConnected()) {
			this.robot = null;
			this.isConnected = false;
		}
	}
	
	protected ComposableRobot getRobot() {
		return this.robot;
	}
	
	public boolean isItOn() {
		return this.isOn == true;
	}
	
	public boolean isItConnected() {
		return this.isConnected == true;
	}
	
	public abstract void use();
	public abstract double getConsumePerAction();
}
