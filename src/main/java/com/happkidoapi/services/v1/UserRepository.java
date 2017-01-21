package com.happkidoapi.services.v1;

import com.happkidoapi.DataManager;
import com.mongodb.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {

    private static final Logger log = Logger.getLogger(UserRepository.class.getName());

    private static UserRepository INSTANCE;

    DBCollection db;

    public static UserRepository getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }

        return INSTANCE;
    }

    public UserRepository (){
        db = DataManager.getInstance().getCollectionByName("users");
    }


    public User mapUserFromdDBObject(DBObject dbObject) {

        User user = new User();

        user.setId(dbObject.get("_id").toString());

        user.setName((String) dbObject.get("firstName"));

        return user;
    }

    public List<User> findAllUsers() {

        List<User> users = new ArrayList<User>();

        try {
            DBCursor cursor = db.find();

            if (cursor != null) {

                while (cursor.hasNext()) {

                    BasicDBObject doc = (BasicDBObject) cursor.next();

                    User item = mapUserFromdDBObject(doc);

                    users.add(item);
                }

                return users;
            }

            return null;
        } catch (Exception e) {

        }

        return null;
    }

}
