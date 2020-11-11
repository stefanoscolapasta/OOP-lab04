package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class ComponentBatteriaAtomica extends Component {
	private static double ATOMIC_BATTERY_CONSUME = 1.3;
	
	public ComponentBatteriaAtomica() {
		super();	
	}
	
	public double getConsumePerAction() {
		return ComponentBatteriaAtomica.ATOMIC_BATTERY_CONSUME;
	}

	
	public void use() {
		if(this.isItOn() && this.isItConnected() && this.isBatteryLevelLessThanHalf()) {	
			this.getRobot().recharge();
			System.out.println("RICARICATO AL " + this.getRobot().getBatteryLevel());
		}	
	}
	
	private boolean isBatteryLevelLessThanHalf() {
		return this.getRobot().getBatteryLevel() < (BaseRobot.BATTERY_FULL/2);
	}

}
