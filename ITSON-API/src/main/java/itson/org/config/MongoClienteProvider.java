package itson.org.config;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public enum MongoClienteProvider {
    INSTANCE;

    private final MongoClient client;
    private final String dbName = "itson";

    MongoClienteProvider() {
        String uri = "";
        client = MongoClients.create(uri);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try { client.close(); } catch (Exception ignored) {}
        }));
    }

    public MongoClient client() {
        return client;
    }

    public MongoDatabase database() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        return client.getDatabase(dbName).withCodecRegistry(pojoCodecRegistry);
    }

    public <T> MongoCollection<T> getCollection(String name, Class<T> type) {
        return database().getCollection(name, type);
    }
}