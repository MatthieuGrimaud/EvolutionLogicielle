package org.anonbnr.design_patterns.oop.creational.builder.robots;

/**
 * a SophisticatedRobotBuilder concrete class that plays the role 
 * of a ConcreteBuilder in the Builder design pattern.
 * It extends the RobotBuilder abstract class to create 
 * sophisticated robots.
 * @author anonbnr
 */
public class SophisticatedRobotBuilder extends RobotBuilder {

	/**
	 * Builds a sophisticated Robot's head
	 */
	
	public void buildHead() {
		this.robot.setHead("Sophisticated Robot head");
	}

	/**
	 * Builds a sophisticated Robot's torso
	 */
	
	public void buildTorso() {
		this.robot.setTorso("Sophisticated Robot torso");
	}

	/**
	 * Builds a sophisticated Robot's arms
	 */
	
	public void buildArms() {
		this.robot.setArms("Sophisticated Robot arms");
	}

	/**
	 * Builds a sophisticated Robot's legs
	 */
	
	public void buildLegs() {
		this.robot.setLegs("Sophisticated Robot legs");
	}
}