/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.config;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author katia
 */
public class MongoConfig {
    private static MongoClient client;
    private static MongoDatabase database;

    private static void init() {
        if (client == null) {
            client = MongoClients.create("mongodb://localhost:27017");
            database = client.getDatabase("gobierno_db");
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
