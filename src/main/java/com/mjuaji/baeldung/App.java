package com.mjuaji.baeldung;

import com.mjuaji.baeldung.users.UserController;

import static spark.Spark.*;

public class App{

    public App(){
        //set up spark java and specify public files
        int maxThreads = 99;
        int minThreads = 2;
        int timeOutMillis = 30000;
        
        port(9190);
        threadPool(maxThreads,minThreads,timeOutMillis);       
        staticFiles.location("/public");

        //routes
        get("/hello", (req, res) -> "Hello, world");        
        get("/hello/:name",(req, res)->{ 
            return "Hello, world to you "+req.params(":name")+"\n"; 
        });

        get("/users", (req, res) -> { return UserController.handleGetUser(req, res); });
        post("/users", (req, res)-> { return UserController.handleNewUser(req, res); });
        get("/users/:id", (req, res)-> { return UserController.handleUserByID(req, res); });
        put("/users/:id",(req, res)-> { return UserController.handleEditUser(req, res); });
        delete("/users/:id",(req, res)-> { return UserController.handleDeleteUser(req, res); });
    }

    public static void main(String[] args){
        new App();
    }
}