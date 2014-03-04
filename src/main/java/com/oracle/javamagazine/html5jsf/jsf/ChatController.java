
package com.oracle.javamagazine.html5jsf.jsf;

import com.oracle.javamagazine.html5jsf.pojo.Chat;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Juneau
 */
@Named
@SessionScoped
public class ChatController implements Serializable {
    
    private String username;
    private String chatOutput;
    private boolean sessionOpen;
    Chat current;
    
    public Chat getCurrent(){
        if(current == null){
            current = new Chat();
        }
        return current;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String sendMessage(){
        
        return null;
    }
    
    public void startSession(){
        getCurrent();
        setSessionOpen(true);
        
        setChatOutput("Chat Session Started...");
        System.out.println("Starting Session");
    }

    public void closeSession(){
        current = null;
        setSessionOpen(false);
    }
    /**
     * @return the chatOutput
     */
    public String getChatOutput() {
        return chatOutput;
    }

    /**
     * @param chatOutput the chatOutput to set
     */
    public void setChatOutput(String chatOutput) {
        this.chatOutput = chatOutput;
    }

    /**
     * @return the sessionOpen
     */
    public boolean isSessionOpen() {
        return sessionOpen;
    }

    /**
     * @param sessionOpen the sessionOpen to set
     */
    public void setSessionOpen(boolean sessionOpen) {
        this.sessionOpen = sessionOpen;
    }
   
    
}
