
package com.oracle.javamagazine.html5jsf.jsf;

import com.oracle.javamagazine.html5jsf.entity.ParkReservation;
import com.oracle.javamagazine.html5jsf.session.ParkReservationFacade;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Juneau
 */
@Named
@RequestScoped
public class ParkReservationController {
    
    @EJB
    ParkReservationFacade ejbFacade;
    
    private ParkReservation reservation;
    private String message;
    private List<ParkReservation> reservationList;
    
    private Map<String, Object> numberAttributes;

    /**
     * Creates a new instance of ParkReservationController
     */
    public ParkReservationController() {
    }

    /**
     * @return the reservation
     */
    public ParkReservation getReservation() {
        if(reservation == null){
            reservation = new ParkReservation();
        }
        return reservation;
    }

    /**
     * @param reservation the reservation to set
     */
    public void setReservation(ParkReservation reservation) {
        this.reservation = reservation;
    }
 
    /**
     * Load reservation list and navigate to currentReservations view
     * 
     * @return 
     */
    public String loadReservations() {
        this.reservationList = ejbFacade.findAll();
        return "currentReservations.xhtml";
    }
    
    /**
     * Create a new reservation
     *
     * @return 
     */
    public String createReservation(){
        if(reservation == null && reservation.getLastName()!= null){
            setMessage("No Reservation made, please try again");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    message, message));
        } else {
            System.out.println(reservation.getFirstName());
            reservation.setId(BigDecimal.valueOf(getReservationCount()).add(BigDecimal.ONE));
            reservation.setEnterDate(new Date());
            ejbFacade.create(reservation);
            setMessage("Successful Reservation Creation");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    message, message));
            reservation = null;
        }
        return null;
    }
    
    public int getReservationCount(){
        return ejbFacade.findAll().size();
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

    /**
     * @return the reservationList
     */
    public List<ParkReservation> getReservationList() {
        return reservationList;
    }

    /**
     * @param reservationList the reservationList to set
     */
    public void setReservationList(List<ParkReservation> reservationList) {
        this.reservationList = reservationList;
    }

    /**
     * @return the numberAttributes
     */
    public Map<String, Object> getNumberAttributes() {
        if(this.numberAttributes == null){
            numberAttributes = new HashMap<>();
            numberAttributes.put("type", "number");
            numberAttributes.put("min", "1");
            numberAttributes.put("max", "30");
        }
        return numberAttributes;
    }

    /**
     * @param numberAttributes the numberAttributes to set
     */
    public void setNumberAttributes(Map<String, Object> numberAttributes) {
        this.numberAttributes = numberAttributes;
    }
}
