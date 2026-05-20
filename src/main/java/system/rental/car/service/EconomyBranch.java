package system.rental.car.service;

import system.rental.car.model.Booking;

public class EconomyBranch extends RentalBranch{

    public EconomyBranch(String branchname){
        super(branchname);
    }

    public void processRental(Booking booking){
        System.out.println("[" + this.branchName() +"]" );
        System.out.println("Processing economy rental for [" + booking.customer().name()+ "]");
        System.out.println("[" + booking.vehicle().model() + "]" );
    }

}