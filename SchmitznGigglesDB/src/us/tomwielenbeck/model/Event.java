package us.tomwielenbeck.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Event
{
    private int productNumber;
    private String name;
    private String description;
    private double price;
    private String date;
    private String genre;
    private String location;
    private String image;
    
    public Event(int productNumber, String name, String description, double price, String date, String genre, String location, String image)
    {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.date = date;
        this.genre = genre;
        this.location = location;
        this.image = image;
    }
    
    public int getProductNumber()
    {
        return productNumber;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public double getPrice()
    {
        return price;
    }
    public String getDate() throws ParseException
    {
        String datePattern = "MM/dd/yy hh:mm a";
        SimpleDateFormat df = new SimpleDateFormat(datePattern);
        df.parse(date);
        return date;
    }
    public String getGenre()
    {
        return genre;
    }
    public String getLocation()
    {
        return location;
    }
    public String getImage()
    {
        return "images/" + image + ".jpg";
    }
    @Override
    public String toString()
    {
        return price + name;
    }
}