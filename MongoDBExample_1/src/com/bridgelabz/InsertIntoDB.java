/**
 * 
 */
package com.bridgelabz;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy Date
 * 
 */
public class InsertIntoDB {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		DB db = (new MongoClient("localhost", 27017)).getDB("insert");
		DBCollection dbCollection = db.getCollection("channel");
		BasicDBObject basic = new BasicDBObject();
		basic.put("name", "Aruna");
		basic.put("pwd", "28aug2018");
		dbCollection.insert(basic);
	}

}
