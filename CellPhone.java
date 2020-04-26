// -----------------------------------------------------
// Assignment 4
// Question: Part 2 (LinkedList)
// Written by: Eli Samuel (40122277) and David Roper (40131739)
// -----------------------------------------------------

/**
* Names
* @author Eli Samuel 40122277
* @author David Roper 40131739
* Comp249
* Assignment 4
* Due Date: April 19th 2020
*/

/*
* This is a CellPhone class with 4 variables long serialNum, String brand, integer year and double price. it has
* parameterized and copy constructors, getters/setter, a deep copy clone method as well as a equals method
*/

import java.util.Scanner;

public class CellPhone {

    private long serialNum;
    private String brand;
    private int year;
    private double price;

    /**
    * @param serialNum a long
    * @param brand string
    * @param price double
    * @param year int
    */
    public CellPhone(long serialNum, String brand, double price, int year){
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    /**
    * @param c a cellphone
    * @param serialNum a long
    */
    public CellPhone(CellPhone c, long serialNum){
        this.serialNum = serialNum;
        this.brand = c.brand;
        this.year = c.year;
        this.price = c.price;
    }

    /**
    * @return serialNum a long
    */
    public long getSerialNum() {
        return serialNum;
    }

    /**
    * @param serialNum a long
    */
    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    /**
    * @return brand a string
    */
    public String getBrand() {
        return brand;
    }

    /**
    * @param brand String
    */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
    * @return year and integer
    */
    public int getYear() {
        return year;
    }

    /**
    * @param year an int
    */
    public void setYear(int year) {
        this.year = year;
    }

    /**
    * @return price a double
    */
    public double getPrice() {
        return price;
    }

    /**
    * @param price a double
    */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
    * clone method
    * @return a Cellphone
    */
    public CellPhone clone(){
        System.out.print("Enter new serial number: ");
        return new CellPhone(this, new Scanner(System.in).nextLong());
    }

    /**
    * toString method
    * @return String
    */
    public String toString(){
        return "["+ serialNum + ": "+ brand + " " + price + ", " + year + "]";
    }

    /**
    * equal method
    *  @return a boolean
    */
    public boolean equals(Object o){
        if (o == null) return false;
        else if (o.getClass() != this.getClass()) return false;
        else {
            CellPhone c = (CellPhone) o;

            return(this.brand.equals(c.brand) && this.year == c.year && this.price == c.price);
        }
    }
}
