/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author Vanderson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
     
        Scanner sc = new Scanner(System.in);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("check-in date (dd/mm/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.println("check-ouy date (dd/mm/yyyy): ");
        Date checkout = sdf.parse(sc.next());
        
        if(!checkout.after(checkin))
        {
        
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        
        }
        else
        {
        
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);
            
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("check-in date (dd/mm/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.println("check-ouy date (dd/mm/yyyy): ");
            checkout = sdf.parse(sc.next());
            
            Date now = new Date();
            
            if(checkin.before(now) || checkout.before(now))
            {
            
                System.out.println("Error in reservation: reservation dates for update must be future dates");
            
            } 
            else if(!checkout.after(checkin))
            {
            
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            
            }
            else
            {
            
             reservation.updateDates(checkin, checkout);
             System.out.println("Reservation: " + reservation);
            
            }

        
        }
    
    
    }
    
}
