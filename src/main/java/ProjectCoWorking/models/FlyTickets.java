package ProjectCoWorking.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="flyTickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlyTickets {
   private int id;
   private double price;
   private String categories;
   private String time;

    public FlyTickets() {
    }

    public FlyTickets(int id, double price, String categories, String time) {
        this.id = id;
        this.price = price;
        this.categories = categories;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getCategories() {
        return categories;
    }

    public String getTime() {
        return time;
    }


    @Override
    public String toString() {
        return "FlyTickets{" +
                "id=" + id +
                ", price=" + price +
                ", categories='" + categories + '\'' +
                ", time='" + time + '\'';
    }
}
