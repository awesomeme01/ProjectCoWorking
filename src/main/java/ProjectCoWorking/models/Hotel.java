package ProjectCoWorking.models;

public class Hotel {
    private int id;
    private String name;
    private String address;
    double price;
    private int rating;
    boolean freeWifi;
    boolean breakfast;
    boolean pool;
    boolean parking;
    boolean bar;
    boolean airConditioning;
    boolean spa;
    boolean fitness;
    Restaurant restaurant;

    public Hotel() {
    }

    public Hotel(int id, String name, String address, double price, int rating, boolean freeWifi, boolean breakfast, boolean pool, boolean parking, boolean bar, boolean airConditioning, boolean spa, boolean fitness, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
        this.rating = rating;
        this.freeWifi = freeWifi;
        this.breakfast = breakfast;
        this.pool = pool;
        this.parking = parking;
        this.bar = bar;
        this.airConditioning = airConditioning;
        this.spa = spa;
        this.fitness = fitness;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public boolean isFreeWifi() {
        return freeWifi;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public boolean isPool() {
        return pool;
    }

    public boolean isParking() {
        return parking;
    }

    public boolean isBar() {
        return bar;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public boolean isSpa() {
        return spa;
    }

    public boolean isFitness() {
        return fitness;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", freeWifi=" + freeWifi +
                ", breakfast=" + breakfast +
                ", pool=" + pool +
                ", parking=" + parking +
                ", bar=" + bar +
                ", airConditioning=" + airConditioning +
                ", spa=" + spa +
                ", fitness=" + fitness +
                ", restaurant=" + restaurant +
                '}';
    }
}