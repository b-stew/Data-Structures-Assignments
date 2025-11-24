/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 2
IDE Name: Microsoft Visual Studio
**/
import java.util.*;

public class Vowels
{
    //printing method for menu
    public static void printMenu()
    {
        System.out.println();
        System.out.println("---------MAIN MENU---------");
        System.out.println("1. Read input string");
        System.out.println("2. Compute number of vowels");
        System.out.println("3. Exit program");
        System.out.println("Enter option number:");
    }
    //counting vowels method
    public static int countVowels(String currString)
    {
        //check if sting is empty
        //also is base case
        if(currString.length() < 1)
        {
            return 0;
        }
        //checks if it is a vowel
        else if(currString.charAt(currString.length() - 1) == 'a' || currString.charAt(currString.length() - 1) == 'e' || currString.charAt(currString.length() - 1) == 'i' || currString.charAt(currString.length() - 1) == 'o' || currString.charAt(currString.length() - 1) == 'u')
        {
            return 1 + countVowels(currString.substring(0, currString.length() - 1));
        }
        //if not still calls recursive method
        else
        {
            return countVowels(currString.substring(0,currString.length()-1));
        }
    }
    public static void main(String[] args)
    {
        //initialize scanner/variables
        Scanner scanner = new Scanner(System.in);
        int userOption = 0;
        String userString = "";
        while(userOption != 3)
        {
            printMenu();
            userOption = scanner.nextInt();
            scanner.nextLine();
            //checking option user chose
            if(userOption == 1)
            {
                //accepts user string
                System.out.println("Enter input string:");
                userString = scanner.nextLine().strip();
            }
            else if(userOption == 2)
            {
                //calls recursive method to count vowel characters
                System.out.println("You entered string:\t" + userString);
                System.out.println("Numebr of vowels:\t" + countVowels(userString));
            }
            else if(userOption == 3)
            {
                break;
            }
            else
            {
                System.out.println("Invalid user option");
            }
        }
        //closing scanner
        scanner.close();
    }
}