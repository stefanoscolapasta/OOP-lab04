package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class ComposableRobot extends BaseRobot {
	private static final int MAX_NUMBER_COMPONENTS = 4;
	
	private Component[] components;
	private int nComponents;
	
	public ComposableRobot(String name) {
		super(name);
		this.components = new Component[MAX_NUMBER_COMPONENTS];
		this.nComponents = 0;
	}
	
	public void addComponent(final Component component) {
		if(!isFull()) {
			this.nComponents++;
			this.components[this.nComponents-1] = component;
			attachComponent(component);
		}
	}
	
	private void attachComponent(Component component) {
		if(!component.isItConnected()) {
			component.connect(this);
		}	
	}
	
	public void removeComponent(final int position) {
		if(checkIfThereIsSomethingAtThatPosition(position) && this.checkPositionIsInBoundariesOfArray(position)) {
			this.components[position] = null;
			this.nComponents--;
		}
	}
	
	public void switchAllOn() {
		for(final Component comp : this.components) {
			if(comp != null && !comp.isItOn() && comp.isItConnected())
			comp.switchOn();
		}
	}
	
	public void useAll() {
		for(final Component comp : this.components) {
			if(comp != null && this.isBatteryEnough(comp.getConsumePerAction()) && comp.isItConnected()) {
				comp.use();
				this.consumeBattery(comp.getConsumePerAction());
			}	
		}
	}
	
	private boolean checkPositionIsInBoundariesOfArray(final int position) {
		return position < ComposableRobot.MAX_NUMBER_COMPONENTS;
	}
	
	private boolean checkIfThereIsSomethingAtThatPosition(final int position) {
		return this.components[position] != null;
	}
	
	private boolean isFull() {
		return this.nComponents == ComposableRobot.MAX_NUMBER_COMPONENTS;
	}
	
	
}
