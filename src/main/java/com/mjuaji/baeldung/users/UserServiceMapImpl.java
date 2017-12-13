package com.mjuaji.baeldung.users;

import com.mjuaji.baeldung.utils.Path;

//java
import com.sun.org.apache.xpath.internal.axes.IteratorPool;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.net.UnknownHostException;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Collection;
//mongo db wrapper
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;
import com.mongodb.DuplicateKeyException;
//Datastore
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.Jongo;
//Utilities
import org.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
//spark
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class UserServiceMapImpl implements UserService{  
    private HashMap<String, User> userMap; 
    List<User> alluserlist = new ArrayList<User>();

    public UserServiceMapImpl(){ userMap = new HashMap<>(); }
    
    @Override
    public void addUser(User user){
      try{
          //Set up datastore and collections
          DB db = new MongoClient().getDB(Path.Database.LOCAL_DBNAME);            
          Jongo ds = new Jongo(db); 
          
          MongoCollection users = ds.getCollection(Path.Database.USER_COLLECTION); 
          users.insert(user);      
      } catch (UnknownHostException e) {
        // ...
      } catch (IOException e) {
        // ...
      }
    }
    
    @Override
    public Collection<User> getUsers(){
      //return userMap.values();
      try{
        //Set up datastore and collections
        DB db = new MongoClient().getDB(Path.Database.LOCAL_DBNAME);            
        Jongo ds = new Jongo(db); 

        MongoCollection users = ds.getCollection(Path.Database.USER_COLLECTION); 
        Iterable<User> allusers = users.find().as(User.class); 
        Iterator<User> alluser=allusers.iterator();

          while (alluser.hasNext()) {
            alluserlist.add(alluser.next());
          }

      } catch (UnknownHostException e) {
        // ...
      } catch (IOException e) {
        // ...
      }
      return alluserlist;
    }
    
    @Override
    public User getUser(String id){
     return userMap.get(id);
    }
    
    @Override
    public User editUser(User forEdit) throws UserException{
      try{
          if(forEdit.getId() == null)
          throw new UserException("ID cannot be blank");
        
          User toEdit=userMap.get(forEdit.getId());
        
          if(toEdit == null)
            throw new UserException("User not found");
        
          if(forEdit.getEmail() != null){
            toEdit.setEmail(forEdit.getEmail());
          }
        
          if(forEdit.getFirstName() != null){
            toEdit.setFirstName(forEdit.getFirstName());
          }
        
          if(forEdit.getLastName() != null){
            toEdit.setLastName(forEdit.getLastName());
          }
        
          if(forEdit.getId() != null){
            toEdit.setId(forEdit.getId());
          }
        
          return toEdit;
      }catch(Exception ex){
          throw new UserException(ex.getMessage());
      }
    }
    
    @Override
    public void deleteUser(String id){
     userMap.remove(id);
    }
    
    @Override
    public boolean userExist(String id){
     return userMap.containsKey(id);
    }
    
}