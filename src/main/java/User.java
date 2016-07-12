import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nigel on 7/11/16.
 */
public class User {
    private String name;
    private List message = new ArrayList<String>();

    public User(String name) {
        this.name = name;
    }

    public List getMessage() {
        return message;
    }

    public void addMessage(String message) {
        this.message.add(message);
    }
}
