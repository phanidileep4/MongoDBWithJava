package com.mongodb.util;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoClientUtil {

    private static MongoClient mongoClient;

    private MongoClientUtil(){}

    public static synchronized MongoClient getMongoClient() {
        if (mongoClient == null) {
            ConnectionString connectionString = new ConnectionString("mongodb+srv://user:user@foodlistings.w9gu1.mongodb.net/" +
                    "?retryWrites=true&w=majority&appName=foodlistings");
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .serverApi(ServerApi.builder()
                            .version(ServerApiVersion.V1)
                            .build())
                    .build();
            mongoClient= MongoClients.create(mongoClientSettings);
        }
        return mongoClient;
    }

    public static void close(){
        if(mongoClient!=null)
            mongoClient.close();
    }
}
