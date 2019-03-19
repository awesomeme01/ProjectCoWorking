package ProjectCoWorking.models;

public class Restaurant {
   private int id;
   private String name;
   private Menu menu;
   private String address;
   private int rating;

    public Restaurant() {
    }

    public Restaurant(int id, String name, Menu menu, String address, int rating) {
        this.id = id;
        this.name = name;
        this.menu = menu;
        this.address = address;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getAddress() {
        return address;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menu='" + menu + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                '}';
    }
}
