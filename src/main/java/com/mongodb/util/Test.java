package com.mongodb.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientUtil.getMongoClient();
        try {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> log.info(db.toJson()));
        }catch (Exception e){
            log.info("Exception is {}", String.valueOf(e));
        }finally {
            mongoClient.close();
        }
    }
}
