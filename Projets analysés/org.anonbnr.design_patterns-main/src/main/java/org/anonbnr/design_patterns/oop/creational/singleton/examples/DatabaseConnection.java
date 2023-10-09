package org.anonbnr.design_patterns.oop.creational.singleton.examples;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private String url;
    private String username;
    private String password;

    // private constructor
    private DatabaseConnection(){
        this.url = "jdbc:mysql://localhost:3306/mydb";
        this.username = "root";
        this.password = "password";
    }

    public static DatabaseConnection getInstance(){
        if (instance == null){
            synchronized(DatabaseConnection.class){
                if (instance == null)
                    instance = new DatabaseConnection();
            }
        }

        return instance;
    }

    public void connect(){
        // logic to establish a database connection
        System.out.println("Connected to database");
    }

    public void disconnect(){
        // logic to close a database connection
        System.out.println("Disconnected from database");
    }
}