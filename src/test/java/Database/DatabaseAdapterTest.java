package Database;

import Model.Token;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseAdapterTest {
    @Test
    public void testDbConnection() {
        boolean result = DatabaseAdapter.initializeDbConnection();
        System.out.println(result);
        Assert.assertTrue(result);
    }

    @Test
    public void testSignIn() {
        DatabaseAdapter db = new DatabaseAdapter();
        Token token = db.signIn("emil", "1234");
        /*if (token != null) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }*/
    }

}