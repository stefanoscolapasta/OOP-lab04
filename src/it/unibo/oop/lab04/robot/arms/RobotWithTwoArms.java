package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
	private static final int ARM_NUMBER = 2;
	private static final int EXTRA_CONSUME = 2;
	private int nCarriedItems;
	private int nOccupiedArmsCounter;
	private BasicArm[] arms;
	
	public RobotWithTwoArms(final String name) {
		super(name);
		this.nCarriedItems = 0;
		this.nOccupiedArmsCounter = 0;
		this.arms = new BasicArm[RobotWithTwoArms.ARM_NUMBER];
		this.populateArms(name);
	}
	
	private void populateArms(String name) {	
		for(int i = 0; i < RobotWithTwoArms.ARM_NUMBER; i++) {
			this.arms[i] = new BasicArm(name);
		}
	}
	
	public boolean pickUp() {
		if(!this.armsAreFull() && isBatteryEnough(this.arms[nOccupiedArmsCounter].getConsuptionForPickUp())) {
			this.consumeBattery(this.arms[nOccupiedArmsCounter].getConsuptionForPickUp());
			this.arms[nOccupiedArmsCounter].pickUp();
			this.increaseOccupiedArmsCounter();
			this.increaseCarriedItems();
			return !this.armsAreFull();
		}
		return this.armsAreFull();
	}

	public boolean dropDown() {
		if(!armsAreEmpty() && isBatteryEnough(this.arms[nOccupiedArmsCounter].getConsuptionForDropDown())) {
			this.consumeBattery(this.arms[nOccupiedArmsCounter].getConsuptionForDropDown());
			this.arms[nOccupiedArmsCounter].dropDown();
			this.lowerOccupiedArmsCounter();
			this.lowerCarriedItems();
			return !this.armsAreEmpty();
		}
		return armsAreEmpty();
	}
	
	private boolean armsAreFull() {
		return nCarriedItems == this.arms.length;
	}
	
	private boolean armsAreEmpty() {
		return nCarriedItems == 0;
	}
	
	private void increaseCarriedItems() {
		this.nCarriedItems++;
	}
	
	private void lowerCarriedItems() {
		this.nCarriedItems--;
	}
	
	private void increaseOccupiedArmsCounter() {
		if(this.canIncreaseArmCounter()) {
			this.nOccupiedArmsCounter++;
		}
	}
	
	private boolean canIncreaseArmCounter() {
		return(this.nOccupiedArmsCounter < this.arms.length - 1);
	}
	
	private void lowerOccupiedArmsCounter() {
		if(this.canLowerArmCounter()) {
			this.nOccupiedArmsCounter--;
		}
	}
	
	private boolean canLowerArmCounter() {
		return(this.nOccupiedArmsCounter > 0);
	}
	
	public int getCarriedItemsCount() {
		return this.nCarriedItems;
	}
	
	protected double getBatteryRequirementForMovement() {
        return BaseRobot.MOVEMENT_DELTA_CONSUMPTION + this.getCarriedItemsCount() * RobotWithTwoArms.EXTRA_CONSUME;
    }

}
