/**
 * 
 */
package com.bridgelabz;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy Date
 * 
 */
public class QueryInsert {
	public static void main(String[] args) throws UnknownHostException {
		DB db = (new MongoClient("localhost", 27017)).getDB("insert");
		DBCollection dbCollection = db.getCollection("channel");
		BasicDBObject basic = new BasicDBObject();
		DBCursor cursor=dbCollection.find(basic);
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
}
