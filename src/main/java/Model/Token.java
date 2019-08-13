package Model;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.sql.Timestamp;

public class Token {
    private String tokenString;
    private Timestamp effectiveTimestamp;
    private ObjectId userId;

    public Token(String tokenString, Timestamp effectiveTimestamp, ObjectId userId) {
        this.tokenString = tokenString;
        this.effectiveTimestamp = effectiveTimestamp;
        this.userId = userId;
    }

    public String getTokenString() {
        return tokenString;
    }

    public Timestamp getEffectiveTimestamp() {
        return effectiveTimestamp;
    }

    public ObjectId getUserId() { return userId; }

    public Document TokenToBasicDB() {
        Document basicDB = new Document();
        basicDB.put("tokenstring", tokenString);
        basicDB.put("timestamp", effectiveTimestamp);
        basicDB.put("userid", userId);
        return basicDB;
    }
}
