package it.unibo.oop.lab04.robot.test;

import it.unibo.oop.lab04.robot.composable.ComponentBatteriaAtomica;
import it.unibo.oop.lab04.robot.composable.ComponentBorderNavigator;
import it.unibo.oop.lab04.robot.composable.ComposableRobot;

/**
 * Utility class for testing composable robots
 * 
 */
public final class TestComposableRobot {

    //private static final int CYCLES = 200;

    private TestComposableRobot() {
    }

    public static void main(final String[] args) {

    	final ComposableRobot robbi = new ComposableRobot("Robbi");
    	ComponentBatteriaAtomica batteriaAtom = new ComponentBatteriaAtomica();
    	ComponentBorderNavigator borderNav = new ComponentBorderNavigator();
    	robbi.addComponent(borderNav);
    	robbi.addComponent(batteriaAtom);
    	
    	
    	robbi.switchAllOn();
    	robbi.useAll();

        /*
         * Write your own test.
         * 
         * You will need a robot with an atomic battery, two arms, and a
         * navigator system. Turn on the battery only when the level is below
         * 50%.
         */

    }
}
