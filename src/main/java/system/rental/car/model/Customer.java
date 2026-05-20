package system.rental.car.model;

import java.util.ArrayList;
import java.util.List;

public class Customer{

    private String name;
    private String licenseNumber;
    private ArrayList<Booking> bookings;


    public Customer(String name,String licenseNumber){
        this.name = name ;
        this.licenseNumber = licenseNumber ;
        this.bookings = new ArrayList<>()  ;
            
    }

    public String name(){
        return this.name ;
    }

    public String licenseNumber(){
        return this.licenseNumber ;
    }

    public ArrayList<Booking> bookings(){
        return new ArrayList<>(bookings) ;
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    @Override

    public String toString(){
        return "Customer: " +this.name + "     Licennse Number: " + this.licenseNumber +
        "Bookings: " + this.bookings ;
    }


    public static void main(String[] args) {
        
    }






}