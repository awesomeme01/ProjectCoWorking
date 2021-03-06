package ProjectCoWorking.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="course")
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
   private int id;
   private String name;
   private int rating;
   private String address;
   private double price;
//   private String time;

    public Course() {
    }

    public Course(int id, String name, int rating, String address, double price) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.price = price;
//        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

//    public String getTime() {
//        return time;
//    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                ", price=" + price +
//                ", time='" + time + '\'' +
                '}';
    }
}
