/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 6
IDE Name: Microsoft Visual Studio
**/

import java.util.*;

public class RemoveDuplicates 
{
    public static void print_menu()//menu
    {
        System.out.println();
        System.out.println("-----------------MAIN MENU---------------");
        System.out.println("1. Read input string");
        System.out.println("2. Remove duplicates and display outputs");
        System.out.println("3. Exit program");
        System.out.println();
    }
    public static void main(String[] args)
    {
        //initialize objects and variables
        Scanner scanner = new Scanner(System.in);
        BST<String> tree = new BST<String>();
        int userOption = 0;
        String[] splitString = null;
        String originalString = "";
        while(userOption != 3)
        {
            print_menu();
            //getting user option
            System.out.println("Enter option number: ");
            userOption = scanner.nextInt();
            scanner.nextLine();
            switch(userOption)
            {
                case 1://read input
                    System.out.println("Enter the string: ");
                    originalString = scanner.nextLine().strip();
                    splitString = originalString.split(" ");
                case 2://remove and display
                    if(splitString == null)//empty case
                    {
                        System.out.println("Enter string first. ");
                    }
                    else
                    {
                        for(String str : splitString)//printing loop
                        {
                            tree.insert(str);
                        }
                    }
                    System.out.println("Original Text: ");
                    System.out.println(originalString);
                    System.out.println();
                    System.out.println("Processed Text: ");
                    tree.inorder();
                case 3://exit case
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        scanner.close();
    }
}
