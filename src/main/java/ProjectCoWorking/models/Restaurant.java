package ProjectCoWorking.models;

public class Restaurant {
   private int id;
   private String name;
   private int menuId;
   private String address;
   private int rating;

    public Restaurant() {
    }

    public Restaurant(int id, String name, int menuId, String address, int rating) {
        this.id = id;
        this.name = name;
        this.menuId = menuId;
        this.address = address;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMenuId() {
        return menuId;
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
                ", menuId='" + menuId + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                '}';
    }
}
