/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.config;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author katia
 */
public enum MongoClienteProvider {
    INSTANCE;

    private final MongoClient client;
    private final String dbName = "gobierno";

    MongoClienteProvider() {
        String uri = "mongodb+srv://pruebaUsuario:teOdioAlgoritmosItson@clustertest.r3o81yp.mongodb.net/?retryWrites=true&w=majority";
        client = MongoClients.create(uri);
    }

    public MongoDatabase database() {
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );

        return client.getDatabase(dbName).withCodecRegistry(codecRegistry);
    }

    public <T> MongoCollection<T> getCollection(String name, Class<T> type) {
        return database().getCollection(name, type);
    }
}
