

package com.oracle.javamagazine.html5jsf.pojo;

import java.util.Date;

/**
 *
 * @author Juneau
 */
public class Chat {
    private Date chatDate;
    private String username;
    private String message;

    /**
     * @return the chatDate
     */
    public Date getChatDate() {
        return chatDate;
    }

    /**
     * @param chatDate the chatDate to set
     */
    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
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

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
