package com.mjuaji.baeldung.utils;

public class Path{
    
        public Path(){}
    
        public static class Web{
            //home
            public static String HOME="/";
    
            //login
            public static String GET_LOGIN_PAGE="/login";
            public static String DO_LOGIN="/login";
            public static String DO_AUTH="/auth";
            public static String LOGOUT="/logout";
    
            //routes for CRUD on auction
            public static String ALL_AUCTIONS = "/auctions/";
            public static String DELETE_AUCTION = "/auction/:id"; //uses delete http method
            public static String UPDATE_AUCTION = "/auction/:id"; //uses put http method; data is contained in req body
            public static String NEW_AUCTION = "/auction/";   
            
            //routes for CRUD on items
            public static String ALL_ITEMS = "/items/";
            public static String DELETE_ITEM = "/item/:id";
            public static String UPDATE_ITEM = "/item/:id";
            public static String NEW_ITEM = "/item/"; 
    
            //routes for CRUD on notifications
            public static String ALL_NOTIFICATIONS = "/notifications/";
            public static String DELETE_NOTIFICATIONS = "/notification/:id";
            public static String UPDATE_NOTIFICATIONS = "/notification/:id";
            public static String NEW_NOTIFICATIONS = "/notification/";
    
            //routes for CRUD on users
            public static String ALL_USERS = "/users/";
            public static String DELETE_USER = "/user/:id";
            public static String UPDATE_USER = "/user/:id";
            public static String NEW_USER = "/user/";
    
            //routes for CRUD on bids
            public static String ALL_BIDS = "/bids/";
            public static String DELETE_BID = "/bid/:id";
            public static String UPDATE_BID = "/bid/:id";
            public static String NEW_BID = "/bid/";
    
            //managing users
            public static String GET_SIGN_UP = "/signup";
            public static String DO_SIGN_UP = "/signup";
            public static String UPDATE_PWD = "/s/user/:id";
    
            // route for ussd
            public static String GET_USSD_SESSION ="/ussd";
            public static String NEW_USSD_SESSION ="/ussd";
    
            // route for reports
            public static String ALL_REPORTS ="/reports";
            public static String NEW_REPORT ="/report";
            
            //routes for MPESA
            public static String ALL_MPESA ="/checkouts";
            public static String NEW_MPESA ="/checkout";     
            
            //routes for vendors
            public static String ALL_VENDORS ="/vendors";
            public static String NEW_VENDOR ="/vendor";         
    
            //utilities
            public static String ATTR_USER_ID = "userId";
            public static String ATTR_USER_NAME = "username";
            public static String ATTR_EMAIL = "username";
    
            public static String OK_PATTERN="[^a-zA-Z0-9:\",{}@_.\\- ]";
            public static int SESSION_TIMEOUT= 60*30; //30 minutes
            public static String JSON_TYPE = "application/json";
            public static String AUTH_STATUS="AUTH_STATUS";
    
        }
        public static class Templates{
            public static String INDEX = "index.hbs";
            public static String DASHBOARD = "main.hbs";
            public static String LOGIN = "signin.hbs";
            public static String SIGN_UP = "signup.hbs";
        }
        public static class Database{
            public static String HOST= "127.0.0.1";
            public static int PORT = 27017;
    
            public static String LOCAL_DBNAME= "pesabid";
            public static String USER_COLLECTION= "users";
            public static String BID_COLLECTION= "bids";   
            public static String AUCTION_COLLECTION= "auctions"; 
            public static String ITEM_COLLECTION= "items"; 
            public static String VENDOR_COLLECTION= "vendors";
            public static String SESSION_COLLECTION= "sessions";    
            public static String CHANCES_COLLECTION= "chances";   
            public static String CONSENT_COLLECTION= "consents";      
            public static String CHOSEN_COLLECTION= "chosens";
            public static String CHECKOUT_COLLECTION= "checkouts";   
            public static String WONORLOST_COLLECTION= "wonorlosts";        
        }
        public static class Reply{
            public static int OK=200;
            public static String OK_MSG="Hurray! Request Successful";
            public static int RESOURCE_NOT_FOUND=601;
            public static String RESOURCE_NOT_FOUND_MSG="Sorry! The resource was not found";
        }
    
        public static class Africastalking{
            public static String USERNAME="jani";
            public static String APIKEY="apikey";
        }
    
        public static class Email{
            public static String APIKEY ="sparkpost-apikey";
        }
            
    }