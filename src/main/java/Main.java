import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by EddyJ on 7/11/16.
 */
public class Main {

    static User user;

    public static void main(String[] args) {
        Spark.init();


        Spark.get("/", (request, response) -> {
            HashMap m = new HashMap();
            if (user == null) {
                return new ModelAndView(m, "index.html");
            } else {
                m.put("name", user);
                return new ModelAndView(m, "messages.html");
            }

        }, new MustacheTemplateEngine());

        Spark.get("/create-user", ((request, response) -> {
            HashMap m = new HashMap();
            return new ModelAndView(m, "messages.html");
        }), new MustacheTemplateEngine());

        Spark.post("/create-user", (request, response) -> {
            String name = request.queryParams("loginName");
            user = new User(name);
            response.redirect("/");
            return "";
        });

        Spark.post("/create-message", (request, response) -> {
            HashMap m = new HashMap();
            String name = request.queryParams("message");
            user.addMessage(name);
            m.put("message", name);
            response.redirect("/");
            return "";

        });

    }
}
