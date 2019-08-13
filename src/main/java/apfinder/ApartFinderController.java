package apfinder;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Model.*;
import Database.*;

import java.sql.Timestamp;

@RestController
public class ApartFinderController {
    DatabaseAdapter db = new DatabaseAdapter();

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @RequestMapping("/auth/login")
    public Response login(@RequestParam(value = "username", defaultValue = "User") String username,
                        @RequestParam(value = "password", defaultValue = "Passwd") String password) {
        Token sessionToken = db.signIn(username, password);
        if (sessionToken == null) {
            return new Response("fail", null);
        }
        return new Response("success", sessionToken);
        //return new User(username, password);
    }

}
