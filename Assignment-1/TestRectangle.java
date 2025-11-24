/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 1
IDE Name: Microsoft Visual Studio
**/
import java.util.*;
public class TestRectangle
{
    public static void main(String[] args)
    {
        //initialize scanner
        Scanner scanner = new Scanner(System.in);

        //create rectangle objects
        Rectangle myRectangle = new Rectangle();
        System.out.println("Enter the width for your rectangle: ");
        double userWidth = scanner.nextDouble();
        System.out.println("Enter the height for your rectangle: ");
        double userHeight = scanner.nextDouble();
        Rectangle yourRectangle = new Rectangle(userWidth, userHeight);

        //testing methods
        System.out.println("Testing getWidth() method on object yourRectangle: " + yourRectangle.getWidth());
        System.out.println("Testing getHeight() method on object yourRectangle: " + yourRectangle.getHeight());
        System.out.println("Testing getArea() method on object yourRectangle: " + yourRectangle.getArea());
        System.out.println("Testing getPerimeter() method on object yourRectangle: " + yourRectangle.getPerimeter());

        //outputs/conduct tests
        System.out.println("\nTest data:");
        System.out.println("myRectangle:");
        System.out.println("------------");
        System.out.println("Width:\t\t" + myRectangle.getWidth());
        System.out.println("Height:\t\t" + myRectangle.getHeight());
        System.out.println("Area:\t\t" + myRectangle.getArea());
        System.out.println("Perimeter:\t" + myRectangle.getPerimeter());
        System.out.println();
        myRectangle.printRectangle("myRectangle");
        System.out.println();
        System.out.println("yourRectangle:");
        System.out.println("--------------");
        System.out.println("Width:\t\t" + yourRectangle.getWidth());
        System.out.println("Height:\t\t" + yourRectangle.getHeight());
        System.out.println("Area:\t\t" + yourRectangle.getArea());
        System.out.println("Perimeter:\t" + yourRectangle.getPerimeter());
        System.out.println();
        yourRectangle.printRectangle("yourRectangle");

        //close scanner
        scanner.close();
    }
}
