package com.happkidoapi;

import com.mongodb.*;
import org.apache.log4j.Logger;

import java.util.List;

public class DataManager {

	private static final Logger log = Logger.getLogger(DataManager.class.getName());


	private static DB happkidoDB;

	private static DataManager INSTANCE;

	public static DataManager getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new DataManager();
		}

		return INSTANCE;
	}

	private DataManager() {

		try {

			String username = System.getenv("dbusername");
			String password = System.getenv("dbpassword");

			String textUri = "mongodb://" + username + ":" + password + "@ds019839.mlab.com:19839/heroku_5w4g85wf";

			MongoClientURI uri = new MongoClientURI(textUri);

			MongoClient mongoClient = new MongoClient(uri);

			happkidoDB = mongoClient.getDB(uri.getDatabase());


		} catch (Exception e) {
			log.error("db connection error e=", e);
		}

	}

	public DBCollection getCollectionByName(String collectionName){

		boolean users = happkidoDB.collectionExists(collectionName);

		if(users){
			DBCollection usersDb = happkidoDB.getCollection(collectionName);
			System.out.println("------------ xxxxxxxxxxx " + usersDb);
			return usersDb;
		} else {
			System.out.println("Collection does not exist " + collectionName);
		}

		return null;
	}

	public DB getDB (){
		return happkidoDB;
	}


}