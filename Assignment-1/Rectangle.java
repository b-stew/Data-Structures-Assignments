/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 1
IDE Name: Microsoft Visual Studio
**/
public class Rectangle
{
    //initialize variables
    private double width;
    private double height;
    
    //constructors
    Rectangle()
    {
        this.width = 1.00;
        this.height = 1.00;
    }
    Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    //getter methods
    public double getWidth()
    {
        return this.width;
    }
    public double getHeight()
    {
        return this.height;
    }
    public double getArea()
    {
        return this.width * this.height;
    }
    public double getPerimeter()
    {
        return this.width * 2 + this.height * 2;
    }

    //print method
    public void printRectangle(String currRectangle)
    {
        System.out.println("Rectangle " + currRectangle + " is " + this.getWidth() + " units wide and " + this.getHeight() + " units high.");
    }
}