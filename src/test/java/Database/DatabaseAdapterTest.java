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

    @Test
    public void validateToken() {
        DatabaseAdapter db = new DatabaseAdapter();
        Token token = db.validateToken("0mfRdaAZv19gtTBQSxQ64wmIKWeLhmCbbjeuS7uJgcynpQMekJAm2vI0psE9KCRx5IXYVRq6gEpCl43iFVwfZ27wvMpJfRvztsLdWQffEsQ5Cp5B56DR0t8g0BmfRzHMtgT3tbyr6U5BkOoGSUUkHoeWiLrlCWriFoc7FIjqhkXPUiCzg2luIACBSq2j3Fdu7kUwcSLuupbpWcB7Y8vPoKmOCiEZEc2CxUsd1QGwA4r75Ip4bEuhvhLIuo6VXESO");
        System.out.println(token.getEffectiveTimestamp());
    }
}