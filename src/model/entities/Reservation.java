/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Vanderson
 */
public class Reservation {
    
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    
    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }
    
    public long duration ()
    {
    
    long diff = checkout.getTime() - checkin.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    
    }
    
    public void updateDates( Date checkin, Date checkout )
    {
    
    this.checkin = checkin;
    this.checkout = checkout; 
    
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout) + ", " + duration() + " nights.";
    }
    
    
    
}
