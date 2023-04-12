package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.UserMessage;

public class ChatController {
    // private static final String SERVER_ADDRESS = "localhost";
    private static final String SERVER_ADDRESS = "mcsmuscle-32634.portmap.io";
    private static final int SERVER_PORT = 32634;
    private int id;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private String newMessage;

    public ChatController() {
        start();
    }

    private void start() {
        try {
            System.out.println("Connecting to server...");
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server");

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            // Get User identifier;
            id = (int) inputStream.readObject();

            new Thread() {
                // Get Input and update to the UI
                // Input: Get only user message
                @Override
                public void run() {
                    try {
                        while (true) {
                            UserMessage userMessage = (UserMessage) inputStream.readObject(); // Input
                            System.out.println("Received data from server");

                            // Process the received data according to the application's requirements.
                            newMessage = userMessage.getMessage();

                            // This method will be Overridden to interact with the UI
                            messageReceivingHandle();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void messageReceivingHandle() {
    }


    public String getNewMessage() {
        return newMessage;
    }

    public void sendMessage(String message) {
        try {
            // Transfer the user message to the server
            outputStream.writeObject(new UserMessage(id, message));
            outputStream.flush();
            System.out.println("Send data to server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
