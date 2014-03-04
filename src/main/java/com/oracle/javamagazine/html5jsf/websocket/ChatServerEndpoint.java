package com.oracle.javamagazine.html5jsf.websocket;

import com.oracle.javamagazine.html5jsf.pojo.Chat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Juneau
 */
@ServerEndpoint(value = "/chat",
        encoders = ChatEncoder.class,
        decoders = ChatDecoder.class)
public class ChatServerEndpoint {
    static ArrayList<Session> sessions =
            new ArrayList<>();
    private final Logger log =
            Logger.getLogger(getClass().getName());

    /**
     * Message receiver method
     *
     * @param message
     * @return
     */
    @OnMessage
    public void messageReceiver(Chat message) {
        System.out.println("Received message:" +
                message.getMessage());

        try {
            for (Session s : sessions) {
                if (s.isOpen()) {
                    s.getBasicRemote().sendObject(message);
                }
            }
        } catch (IOException | EncodeException e) {
            log.log(Level.WARNING, "onMessage failed", e);
        }

    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen: " + session.getId());
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println(session.getId());
        sessions.remove(session);
    }
}

