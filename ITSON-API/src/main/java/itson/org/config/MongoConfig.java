package itson.org.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {

    private static MongoClient client;
    private static MongoDatabase database;

    private static void init() {
        if (client == null) {
            client = MongoClients.create("mongodb+srv://pruebaUsuario:teOdioAlgoritmosItson@clustertest.r3o81yp.mongodb.net/?appName=ClusterTest");
            database = client.getDatabase("itson");
        }
    }

    public static MongoDatabase getDatabase() {
        if (database == null) {
            init();
        }
        return database;
    }

    public static MongoClient getClient() {
        if (client == null) {
            init();
        }
        return client;
    }
}
