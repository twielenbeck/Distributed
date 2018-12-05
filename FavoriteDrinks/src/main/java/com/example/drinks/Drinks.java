package com.example.drinks;

public class Drinks {
    private String name;
    private String brand;
    private int enjoymentFactor;

    public Drinks(String name, String brand, int enjoymentFactor)
    {
        this.name = name;
        this.brand = brand;
        this.enjoymentFactor = enjoymentFactor;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public int getEnjoymentFactor()
    {
        return enjoymentFactor;
    }

    public void setEnjoymentFactor(int enjoymentFactor)
    {
        this.enjoymentFactor = enjoymentFactor;
    }
}
