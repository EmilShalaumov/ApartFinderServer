package Model;

import org.bson.types.ObjectId;

public class User {
    private ObjectId id;
    private String username;
    private String passwordHash;

    public User(ObjectId id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public ObjectId getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
