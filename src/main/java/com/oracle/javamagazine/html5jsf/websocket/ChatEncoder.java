/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.javamagazine.html5jsf.websocket;

import com.oracle.javamagazine.html5jsf.jsf.ChatController;
import com.oracle.javamagazine.html5jsf.pojo.Chat;
import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Juneau
 */
public class ChatEncoder
        implements Encoder.Text<Chat> {

    @Inject
    ChatController chatController;

    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(final Chat chatMessage)
            throws EncodeException {
        System.out.println("Received in encoder");
        return chatMessage.getUsername() + "("
                + chatMessage.getChatDate() + "): "
                + chatMessage.getMessage();
    }
}
