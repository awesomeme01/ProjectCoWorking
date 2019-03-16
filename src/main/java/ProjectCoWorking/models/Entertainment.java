package ProjectCoWorking.models;

public class Entertainment {
    int id;
    String name;
    double price;
    String address;
    int ageRestrictions;

    public Entertainment() {
    }

    public Entertainment(int id, String name, double price, String address, int ageRestrictions) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
        this.ageRestrictions = ageRestrictions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public int getAgeRestriction() {
        return ageRestrictions;
    }

    @Override
    public String toString() {
        return "Entertainment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", ageRestrictions=" + ageRestrictions +
                '}';
    }
}
