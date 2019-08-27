package Database;

import Model.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.sql.Timestamp;

public class DatabaseAdapter {
    private static MongoDatabase database;
    private static boolean dbConnectionIsOpen = false;


    static boolean initializeDbConnection() {
        String connectionString = "mongodb://localhost";
        String databaseName = "testdb";
        if (dbConnectionIsOpen)
            System.out.println("DB connection is already open");
        else
            try {
                MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString));
                database = mongoClient.getDatabase(databaseName);
                dbConnectionIsOpen = true;
                System.out.println("DB connection has been successfully opened");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return dbConnectionIsOpen;
    }

    public Token signIn(String username, String password) {
        if (!dbConnectionIsOpen && !initializeDbConnection()) {
            System.out.println("Unable to connect to DB");
            return null;
        }

        MongoCollection<Document> users = database.getCollection("users");
        Document user = users.find(new Document("username", username)).first();
        if (user == null) {
            System.out.println("User with name " + username + " doesn't exist.");
            return null;
        }

        //Create token for user
        MongoCollection<Document> tokens = database.getCollection("sessiontokens");
        Token newToken = new Token(SecureTokenGenerator.nextToken(),
                                   new Timestamp(System.currentTimeMillis()),
                                   (ObjectId) user.get("_id"));
        tokens.insertOne(newToken.TokenToBasicDB());

        return newToken;
    }

    public Token validateToken(String tokenString) {
        if (!initializeDbConnection()) {
            System.out.println("Unable to connect to DB");
            return null;
        }

        MongoCollection<Document> tokens = database.getCollection("sessiontokens");
        Document token = tokens.find(new Document("tokenstring", tokenString)).first();
        if (token == null) {
            System.out.println("Token doesn't exist.");
            return null;
        }

        return new Token((String) token.get("tokenstring"), new Timestamp(token.getDate("timestamp").getTime()), (ObjectId) token.get("userid"));
    }
}
