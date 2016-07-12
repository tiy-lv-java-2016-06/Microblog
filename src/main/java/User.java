import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nigel on 7/11/16.
 */
public class User {
    private String name;
    private List<Message> messageList = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List getMessageList() {
        return messageList;
    }

    public void addMessage(Message message) {
        this.messageList.add(message);
    }

    public void addMessage (String message){
        Message input = new Message(message);
        this.messageList.add(input);
    }
}
