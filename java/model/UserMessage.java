package model;

import java.io.Serializable;

public class UserMessage implements Serializable {
    
    private final int id;
    private String message;

    public UserMessage(int id, String message) {
        this.id = id;
        this.message = message;
    }
    
    public int getId() {
        return id;
    }
    
    public String getMessage() {
        return message;
    }
}
