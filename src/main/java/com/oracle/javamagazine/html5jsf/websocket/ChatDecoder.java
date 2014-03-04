/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.javamagazine.html5jsf.websocket;

import com.oracle.javamagazine.html5jsf.pojo.Chat;
import java.io.StringReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Juneau
 */
public class ChatDecoder 
   implements Decoder.Text<Chat> {
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public Chat decode(final String textMessage)
            throws DecodeException {
        Chat chatMessage = new Chat();
        JsonObject obj = Json.createReader(
                new StringReader(textMessage))
                .readObject();
        chatMessage.setMessage(obj.getString("message"));
        chatMessage.setUsername(obj.getString("username"));
        chatMessage.setChatDate(new Date());
        System.out.println("decoder...");
        return chatMessage;
    }

    @Override
    public boolean willDecode(final String s) {
        return true;
    }
}
