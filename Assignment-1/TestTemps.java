/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 1
IDE Name: Microsoft Visual Studio
**/
import java.util.*;
public class TestTemps 
{
    public static void main(String[] args)
    {
        //creates array
        int[] tempList = new int[7];

        //initialize scanner
        Scanner scanner = new Scanner(System.in);

        //acquire all temperatures and make array
        System.out.println("Enter the temperature for Monday: ");
        tempList[0] = scanner.nextInt();
        System.out.println("Enter the temperature for Tuesday: ");
        tempList[1] = scanner.nextInt();
        System.out.println("Enter the temperature for Wednesday: ");
        tempList[2] = scanner.nextInt();
        System.out.println("Enter the temperature for Thursday: ");
        tempList[3] = scanner.nextInt();
        System.out.println("Enter the temperature for Friday: ");
        tempList[4] = scanner.nextInt();
        System.out.println("Enter the temperature for Saturday: ");
        tempList[5] = scanner.nextInt();
        System.out.println("Enter the temperature for Sunday: ");
        tempList[6] = scanner.nextInt();
        DailyTemps userTemps = new DailyTemps(tempList);

        //conduct tests
        System.out.println("\nTesting method setTemp");
        System.out.println("Enter the index of the target day: ");
        System.out.println("0 - Monday\n1 -Tuesday\n2 - Wednesday\n3 - Thursday\n4 - Friday\n5 - Saturday\n6 - Sunday");
        int userIndex = scanner.nextInt();
        System.out.println("Enter the new temperature: ");
        int newUserTemp = scanner.nextInt();
        userTemps.setTemp(userIndex, newUserTemp);
        System.out.println("\nTesting method Freezing");
        System.out.println("Number of freezing days is " + userTemps.Freezing() + " days");
        System.out.println("\nTesting method Warmest");
        System.out.println("The warmest day of the week is " + userTemps.Warmest());
        System.out.println("\nTesting method printTemps");
        userTemps.printTemps();

        //closing scanneer
        scanner.close();
    }
}
