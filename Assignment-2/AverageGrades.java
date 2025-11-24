/** 
 Name: Bradley Stewart
 Class: CS 3305/Section 01
 Term: Spring 2024
 Instructor: Dr. Haddad
 Assignment: 2
 IDE Name: Microsoft Visual Studio
 **/
import java.util.*;

public class AverageGrades 
{
    //print method for menu
    public static void printMenu()
    {
        System.out.println();
        System.out.println("--------MAIN MENU-------");
        System.out.println("1. Read class size");
        System.out.println("2. Read class grades");
        System.out.println("3. Compute class average");
        System.out.println("4. Exit program");
        System.out.println();
        System.out.println("Enter option number:");
    }
    //recursive method for average
    public static double findAverage(int[] grades, int index)
    {
        //base case to stop recursive calls
        if(index == grades.length-1)
        {
            return grades[index];
        }
        //making sum variable to calculate average
        double sum = grades[index] + findAverage(grades, index + 1);
        if(index == 0)
        {
            //"base case" for returning the average since it will be the final process to finish executing
            return sum / grades.length;
        }
        else
        {
            //all recursive cases use to add the sum of numbers
            return sum;
        }        
    }
    static int[] classGrades;
    public static void main(String[] args)
    {   
        //initializing scanner/variables
        Scanner scanner = new Scanner(System.in);
        int userOption = 0;
        int classSize = 0;
        while(userOption != 4)
        {
            //getting user option
            printMenu();
            userOption = scanner.nextInt();
            scanner.nextLine();
            //checking option chosen
            if(userOption == 1)
            {
                //getting class size and checking for error
                System.out.println("Enter class size: ");
                classSize = scanner.nextInt();
                scanner.nextLine();
                if(classSize > 0)
                {
                    classGrades = new int[classSize];
                    
                }
                else
                {
                    System.out.println("Invalid class size");
                }
            }
            else if(userOption == 2)
            {
                //checking if class size has been established
                if(classSize <= 0)
                {
                    System.out.println("Invalid class size");
                }
                else
                {
                    //getting class grades
                    System.out.println("Enter class grades: ");
                    for(int i = 0; i < classSize; i++)
                    {
                        classGrades[i] = scanner.nextInt();
                    }
                }
            }
            else if(userOption == 3)
            {
                //checking if class size and grades have been established
                if(classGrades == null || classSize <= 0)
                {
                    System.out.println("Enter class size/class grades before proceeding");
                }
                else
                {
                    //dislaying outputs
                    System.out.println("You entered class size: \t" + classSize);
                    System.out.print("You entered grades: \t\t");
                    for(int i = 0; i < classSize; i++)
                    {
                        System.out.print(classGrades[i] + " ");
                    }
                    System.out.println();
                    System.out.printf("Class average: \t\t\t%.2f", findAverage(classGrades, 0));//formatting for decimals
                    System.out.println();
                }
            }
            else if(userOption == 4)
            {
                System.out.println("Closing program");
                break;
            }
            else
            {
                System.out.println("Invalid option");
            }
        }
        //closing scanner
        scanner.close();
    }   
}
