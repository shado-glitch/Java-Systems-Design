package system.rental.car.model;


public class Booking{

    public enum BookingStatus{
        PENDING, APPROVED , IN 
    }

    private int bookingId;
    private Customer customer;
    private Vehicle vehicle;
    private int days ;
    private BookingStatus status;

    public Booking(int bookingId, Customer customer,Vehicle vehicle,int days){
        this.bookingId = bookingId;
        this.customer = customer ;
        this.vehicle = vehicle;
        this.days = days;
        this.status = BookingStatus.PENDING;


    }

    public int bookingId(){
        return this.bookingId;
    }

    public Customer customer(){
        return this.customer;
    }

    public Vehicle vehicle(){
        return this.vehicle;
    }

    public int days(){
        return this.days ;   
    }

    public BookingStatus status(){
        return this.status;
    }

    public double totalCost(){
        return vehicle.dailyRate() * this.days;
       }

    public void updateStatus(BookingStatus status){
        this.status = status ;
    }

    @Override
    public String toString(){
        return "BookingId: " + this.bookingId() + "\n" +
         "Customer: " + this.customer() +"\n" +
         "Vehicle: " + this.vehicle() +"    Days: " + this.days() ;
         

    }




}