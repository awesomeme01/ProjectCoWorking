package ProjectCoWorking.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="hotel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel {
    private int id;
    private String name;
    private String address;
    private double price;
    private int rating;
    private boolean freeWifi;
    private boolean breakfast;
    private boolean pool;
    private boolean parking;
    private boolean bar;
    private boolean airConditioning;
    private boolean spa;
    private boolean fitness;
    private int restaurantId;

    public Hotel() {
    }

    public Hotel(int id, String name, String address, double price, int rating, boolean freeWifi, boolean breakfast, boolean pool, boolean parking, boolean bar, boolean airConditioning, boolean spa, boolean fitness, int restaurant) {
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
        this.restaurantId = restaurant;
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

    public int getRestaurant() {
        return restaurantId;
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
                ", restaurantId=" + restaurantId +
                '}';
    }
}
