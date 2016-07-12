import java.util.ArrayList;

/**
 * Created by vasantia on 7/11/16.
 */
public class User {

    private String name;
    ArrayList<Message> myMessages = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Message> getMyMessages() {
        return myMessages;
    }
}
