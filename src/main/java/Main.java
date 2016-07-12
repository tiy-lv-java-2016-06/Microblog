import com.github.mustachejava.Mustache;
import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nigel on 7/11/16.
 */
public class Main {
    static User user;
    static List messageList = new ArrayList<Message>();
    public static void main(String[] args) {
        Spark.init();

        Spark.get("/",((request, response) -> {
            HashMap m = new HashMap();
            if (user == null){
                return new ModelAndView(m, "index.html");
            }else{
                m.put("user", user);
                return new ModelAndView(m, "messages.html");
            }
        }), new MustacheTemplateEngine());

        Spark.post("/create-user", ((request, response) -> {
                    String name = request.queryParams("userName");
                    user = new User(name);
                    response.redirect("/");
                    return "";
                })
        );

        Spark.post("/create-message", ((request, response) -> {
            String input = request.queryParams("message");
            user.addMessage(input);
            response.redirect("/");
            return "";
        })
        );

    }
}