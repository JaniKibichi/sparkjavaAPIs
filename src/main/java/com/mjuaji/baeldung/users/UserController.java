package com.mjuaji.baeldung.users;

import com.mjuaji.baeldung.users.UserServiceMapImpl;

import spark.Request;
import spark.Response;
import com.google.gson.Gson;


public class UserController{
    public static UserService userService = new UserServiceMapImpl();

    public UserController(){}

    //GET USER
    public static Object handleGetUser(Request req, Response res){
        return getUser(req, res);
    }
    private static Object getUser(Request req, Response res){
        res.type("application/json");
        return new Gson.toJson(
            new StandardResponse(StatusResponse.SUCCESS, new Gson()
            .toJsonTree(userService.getUsers())));
    }

    //POST USER
    public static Object handleNewUser(Request req, Response res){
        return addUser(req, res);
    }
    private static Object addUser(Request req, Response res){
        res.type("application/json");
        User user = new Gson().fromJson(req.body(), User.class);
        userService.addUser(user);
        
        return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
    }

    //GET USER BY ID
    public static Object handleUserByID(Request req, Response res){
        return getUserByID(req,res);
    }

    private static Object getUserByID(Request req, Response res){
        res.type("application/json");

        return new Gson().toJson(
            new StandardResponse(StatusResponse.SUCCESS, new Gson()
            .toJsonTree(userService.getUser(req.params(":id")))));
    }

    //EDIT USER
    public static Object handleEditUser(Request req, Response res){
        return editUser(req, res);
    }

    private static Object editUser(Request req, Response res){
        res.type("application/json");
        User toEdit = new Gson().fromJson(req.body(), User.class);
        User editedUser = userService.editUser(toEdit);
        
        if(editedUser != null){
         return new Gson().toJson(
            new StandardResponse(StatusResponse.SUCCESS, new Gson()
            .toJsonTree(editedUser)));
        }else{
         return new Gson().toJson(
            new StandardResponse(StatusResponse.ERROR, new Gson()
            .toJson("User not found or error in edit")));
        }
    }

    //DELETE USER
    public static Object handleDeleteUser(Request req, Response res){
        return deleteUser(req, res);
    }

    private static Object deleteUser(Request req, Response res){
        res.type("application/json");
        userService.deleteUser(req.params(":id"));
        return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "user deleted"));
    }

    //OPTIONS USER
    public static Object handleOptions(Request req, Response res){
        return options(req, res);
    }

    private static Object options(Request req, Response res){
        res.type("application/json");
        
        return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,(userService.userExist(req.params(":id")))? "User exists":"User does not exists"));        
    }
}