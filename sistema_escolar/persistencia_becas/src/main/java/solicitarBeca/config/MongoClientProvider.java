/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solicitarBeca.config;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Cortez, Manuel;
 */
public enum MongoClientProvider {
    INSTANCE;
    private MongoClient client;
    private String dbName;
    private String uri;

    public synchronized void init() {
        if (client == null) {
            try {
                InputStream input = getClass()
                        .getClassLoader()
                        .getResourceAsStream("mongo.properties");
                Properties props = new Properties();
                props.load(input);
                this.uri = props.getProperty("mongo.uri");
                this.dbName = props.getProperty("mongo.dbname");
                client = MongoClients.create(MongoConfig.buildSettings(this.uri));
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    client.close();
                }));
            } catch (Exception ignored) {
                throw new RuntimeException("Error cargando configuracion Mongo");
            }
        }
    }

    public MongoClient client() {
        if (client == null)
            throw new IllegalStateException("MongoClientProvider no inicializado. Llama a init() antes.");
        return client;
    }

    public MongoDatabase database() {
        return client().getDatabase(this.dbName);
    }

    public <T> MongoCollection<T> getCollection(String collectionName, Class<T> clazz) {
        if (client == null)
            throw new IllegalStateException("MongoClientProvider no inicializado. Llama a init() antes.");

        MongoDatabase db = client.getDatabase(this.dbName);
        return db.getCollection(collectionName, clazz);
    }
}
