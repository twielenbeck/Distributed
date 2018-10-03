package us.tomwielenbeck.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Event
{
    private String name;
    private String description;
    private double price;
    private String date;
    private String image;
    private int productNumber;

    public Event(int productNumber, String name, String description, double price, String date, EventGenre genre, EventLocation location, String image) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.date = date;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public String getDate() throws ParseException {
        String datePattern = "MM/dd/yy hh:mm a";
        SimpleDateFormat df = new SimpleDateFormat(datePattern);
        df.parse(date);
        return date;
    }
    public String getImage() {
        return "images/" + image + ".jpg";
    }
    public int getProductNumber() {
        return productNumber;
    }

    @Override
    public String toString(){
        return price + name;
    }
}