package utils;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC {
	public static void main(String[] args) {
		try {
		//连接到mongodb服务
		MongoClient mongoClient = new MongoClient("localhost",27017);
		//连接到数据库
		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
		
		System.out.println("Connect to database successfully!");
		/*//创建集合
		mongoDatabase.createCollection("test2");
		
		System.out.println("创建集合成功");*/
		//获取集合
		MongoCollection<Document> collection = mongoDatabase.getCollection("test2");

		System.out.println("集合test选择成功");
		//插入文档
		/**
		 * 1.创建文档org.bson.Document
		 * 2.创建文档集合List<Document>
		 * 3.将文档集合插入数据库集合中
		 */
		/*Document document = new Document("title","MongoDB")
				.append("description", "database")
				.append("likes", 100)
				.append("by", "Iris");
		List<Document> documents = new ArrayList<>();
		documents.add(document);
		collection.insertMany(documents);
		
		System.out.println("文档插入成功");*/
		/**
		 * 检索所有文档
		 * 1.获取迭代器FindIterable<Document>
		 * 2.获取游标MongoCursor<Document>
		 * 3.通过游标遍历检索出文档合集
		 */
		/*FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoDursor = findIterable.iterator();
		
		while(mongoDursor.hasNext()) {
			System.out.println(mongoDursor.next());
			
		}*/
		//更新文档
		/*collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes",200)));*/
		
		//删除文档
		/*collection.deleteMany(Filters.eq("likes",200));*/
		}catch(Exception e) {
			System.out.println(e.getClass().getName() + ":" + e.getMessage());
		}
		
	}

}
