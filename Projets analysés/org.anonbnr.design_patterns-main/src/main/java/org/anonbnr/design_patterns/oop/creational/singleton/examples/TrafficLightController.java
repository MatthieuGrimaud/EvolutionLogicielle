package org.anonbnr.design_patterns.oop.creational.singleton.examples;

public class TrafficLightController{
    private static TrafficLightController instance;
    private boolean isGreen = true;

    // private constructor
    private TrafficLightController() {

    }

    // public static method to get the instance of the singleton class
    public static synchronized TrafficLightController getInstance(){
        if (instance == null)
            instance = new TrafficLightController();

        return instance;
    }

    // method to switch the traffic light from green to red or vice versa
    public void switchLight(){
        if (isGreen){
            isGreen = false;
            System.out.println("Traffic light is now red");
        }

        else {
            isGreen = true;
            System.out.println("Traffic light is now green");
        }
    }

    // method to get the current status of the traffic light
    public String getStatus(){
        return isGreen ? "green" : "red";
    }
}