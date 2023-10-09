package org.anonbnr.design_patterns.oop.creational.builder.robots;

/**
 * A Robot class that plays the role of a ConcreteProduct 
 * in the product family version of the Builder design pattern.
 * It implements the IRobot interface to create concrete robots.
 * @author anonbnr
 */
public class Robot implements IRobot {
	/* ATTRIBUTES */
	/**
	 * The Robot's head
	 */
	private String head;
	
	/**
	 * The Robot's torso
	 */
	private String torso;
	
	/**
	 * The Robot's arms
	 */
	private String arms;
	
	/**
	 * The Robot's legs
	 */
	private String legs;

	/* METHODS */
	/**
	 * Gets this Robot's head
	 * @return this Robot's head
	 */
	public String getHead() {return this.head;}
	
	
	public void setHead(String head) {this.head = head;}
	
	/**
	 * Gets this Robot's torso
	 * @return this Robot's torso
	 */
	public String getTorso() {return this.torso;}

	
	public void setTorso(String torso) {this.torso = torso;}

	/**
	 * Gets this Robot's arms
	 * @return this Robot's arms
	 */
	public String getArms() {return this.arms;}
	
	
	public void setArms(String arms) {
		this.arms = arms;
	}

	/**
	 * Gets this Robot's legs
	 * @return this Robot's legs
	 */
	public String getLegs() {return this.legs;}
	
	
	public void setLegs(String legs) {
		this.legs = legs;
	}
	
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("Head: " + head + "\n");
		buf.append("Torso: " + torso + "\n");
		buf.append("Arms: " + arms + "\n");
		buf.append("Legs: " + legs);
		
		return buf.toString();
	}
}
