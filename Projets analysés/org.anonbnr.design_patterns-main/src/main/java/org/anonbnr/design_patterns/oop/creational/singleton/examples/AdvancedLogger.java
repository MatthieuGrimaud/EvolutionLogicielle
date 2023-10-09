package org.anonbnr.design_patterns.oop.creational.singleton.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdvancedLogger implements Serializable {
    // Define a serialVersionUID to handle serialization correctly
    private static final long serialVersionUID = 1;

    // Define a volatile instance field for thread safety
    private static volatile AdvancedLogger instance;

    private List<String> logs;

    // Make the constructor private to prevent external instantiation
    private AdvancedLogger(){
        logs = new ArrayList<String>();
    }

    // Implement double-checked locking for thread safety
    public static AdvancedLogger getInstance(){
        if (instance == null){
            synchronized (AdvancedLogger.class){
                if (instance == null)
                    instance = new AdvancedLogger();
            }
        }

        return instance;
    }

    public void log(String message){
        logs.add(message);
    }

    public void printLogs(){
        for (String log: logs)
            System.out.println(log);
    }

    // Define the readResolve method to ensure only one instance is used after deserialization
    public Object readResolve(){
        return getInstance();
    }
}