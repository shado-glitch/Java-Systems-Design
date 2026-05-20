package system.rental.car.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import system.rental.car.model.Booking;
import system.rental.car.model.Booking.BookingStatus;
import system.rental.car.model.Customer;
import system.rental.car.model.Vehicle;

public abstract class RentalBranch{


    private String branchName;
    private Map<String ,Vehicle> vehicles;
    private ArrayList<Booking> bookings ;
    private int bookingCounter ;

    public RentalBranch(String branchname){
        this.branchName = branchname ;
        this.vehicles = new HashMap<>();
        this.bookings = new ArrayList<Booking>();  
        }


    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.model(), vehicle);
    }

    public Vehicle getVehicle(String model){
          return vehicles.get(model);
    }

    public Map<String ,Vehicle> getAllVehicles(){
        return Collections.unmodifiableMap(vehicles);
    }

    public Booking createBooking(Customer customer , String vehicle, int days){
        if(vehicles.containsKey(vehicle) && vehicles.get(vehicle).isAvailable()){
            bookingCounter ++;

            Booking booking = new Booking(bookingCounter, customer, vehicles.get(vehicle), days);
            bookings.add(booking);

            return booking;

        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public Booking processNextBooking(){
        for(Booking booking : bookings){
            if(booking.status() == BookingStatus.PENDING){
                booking.updateStatus(BookingStatus.APPROVED);
                booking.vehicle().setAvailable(false);
                
                return booking;
            }
        }

        return null ;
    
    }

    public List<Booking> bookings(){
        return List.copyOf(bookings);
    }

    public String branchName(){
        return this.branchName ;
    }
    protected abstract void processRental(Booking booking);
    
}