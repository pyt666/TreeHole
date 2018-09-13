package utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC {
	public static void main(String[] args) {
		//连接到mongodb服务
		MongoClient mongoClient = new MongoClient("localhost",27017);
		//连接到数据库
		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
		Object o = mongoDatabase.getCollection("test");
		System.out.println(o.toString());
		System.out.println("Connect to database successfully!");
	}

}
