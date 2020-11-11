package it.unibo.oop.lab04.robot.composable;

public class ComponentBorderNavigator extends Component {
	private static double BORDER_NAVIGATOR_CONSUME = 1.2;
	
	public ComponentBorderNavigator() {
		super();
	}
	
	public double getConsumePerAction() {
		return ComponentBorderNavigator.BORDER_NAVIGATOR_CONSUME;
	}
	
	public void use() {
		if(isItOn() && this.isItConnected()) {
			this.moveTowardsXBoundaryThenYBoundary();
		}
	}
	
	private void moveTowardsXBoundaryThenYBoundary() {				
			while(this.getRobot().moveUp());	

	}
}
