import java.util.ArrayList;
import java.util.List;

/**
 * Created by EddyJ on 7/11/16.
 */
public class User {
    protected String name;
    private List<String> Message = new ArrayList<>();


    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addMessage(String message) {
        this.Message.add(message);
    }

    public List<String> getMessage() {
        return Message;
    }
}
