package system.rental.car.model;

public class Vehicle{

    private String model;
    private double dailyRate;
    private boolean available ;


    public Vehicle(String model, double dailyRate){
        this.model = model;
        if( dailyRate < 0 ){
            throw new IllegalArgumentException();
        }else{
            this.dailyRate = dailyRate;
        }
    
        this.available = true;
    }

    public String model(){
        return this.model;
    }

    public double dailyRate(){
        return this.dailyRate;
    }

    public boolean isAvailable(){
        return this.available;
    }

    public void setAvailable(boolean status){
        this.available = status;
    }

    public void updateDailyRate(double dailyRate){
        if( dailyRate < 0 ){
            throw new IllegalArgumentException();
        }else{
            this.dailyRate = dailyRate;
        }
    }

    @Override
    public String toString(){
        return this.model + " - " +"R" + this.dailyRate + "/day" ;
    }

    public static void main(String[] args) {
            Vehicle vehicle = new Vehicle("Toyota Corolla", -450.0);
            System.out.println(vehicle.model());
            System.out.println(vehicle.dailyRate());
            System.out.println(vehicle.isAvailable());
               vehicle.setAvailable(false);
            System.out.println(vehicle.isAvailable());
            vehicle.updateDailyRate(650.0);
            System.out.println(vehicle.dailyRate());
               
    }
}