package ProjectCoWorking.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="menu")
@XmlAccessorType(XmlAccessType.FIELD)
public class Menu {
   private int id;
   private String dishes;
   private double price;

    public Menu() {
    }

    public Menu(int id, String dishes, double price) {
        this.id = id;
        this.dishes = dishes;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDishes() {
        return dishes;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dishes='" + dishes + '\'' +
                ", price=" + price +
                '}';
    }
}
