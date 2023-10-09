package org.anonbnr.design_patterns.oop.creational.singleton.examples;

public class Logger {
    private static Logger instance;

    private Logger(){
        // private constructor to prevent instantiation from outside the class
    }

    public static Logger getInstance(){
        if (instance == null)
            instance = new Logger();
        
        return instance;
    }

    public void log(String message){
        // log the message
    }
}