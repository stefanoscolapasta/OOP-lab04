package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
	private static final double GRABBING_CONSUMPTION = 1.2;
	private static final double DROPPING_CONSUMPTION = 1.2;
	private final String name;
	private boolean grabbing;
	
	public BasicArm(String name) {
		this.name = name;
		this.grabbing = false;
	}
	
	public boolean isGrabbing() {
		return this.grabbing;
	}
	
	public boolean pickUp() {
		if(!isGrabbing()) {
			this.grabbing = true;
			return this.grabbing;
		}
		return this.grabbing; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean dropDown() {
		if(isGrabbing()) {
			this.grabbing = false;
			return this.grabbing;
		}
		return this.grabbing; 
	}
	
	public double getConsuptionForPickUp() {
		return BasicArm.GRABBING_CONSUMPTION;
	}
	
	public double getConsuptionForDropDown() {
		return BasicArm.DROPPING_CONSUMPTION;
	}
}
