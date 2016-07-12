import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

/**
 * Created by vasantia on 7/11/16.
 */
public class Main {

    static User user;

    public static void main(String[] args) {
        Spark.init();

        Spark.get("/", (request, response) -> {
            HashMap m = new HashMap();

            if (user != null) {
                m.put("user", user);
            }
            return new ModelAndView(m, "messages.html");
        }, new MustacheTemplateEngine());

        Spark.get("/create-user", ((request, response) -> {
            HashMap m = new HashMap();
            return new ModelAndView(m, "index.html");
        }), new MustacheTemplateEngine());

        Spark.post("/create-user", (request, response) -> {
            String name = request.queryParams("submitName");
            user = new User(name);
            response.redirect("/");
            return "";
        });

        Spark.get("/create-message", ((request, response) -> {
            HashMap m = new HashMap();
            return new ModelAndView(m, "messages.html");
        }), new MustacheTemplateEngine());

        Spark.post("/create-message", ((request, response) -> {

            String submitMessage = request.queryParams("submitMessage");
            Message message = new Message(submitMessage);
            user.myMessages.add(message);

            response.redirect("/");
            return "";
        }));
    }
}
