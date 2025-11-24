/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 4
IDE Name: Microsoft Visual Studio
**/
import java.util.*;

public class ReverseString 
{
    //prints menu
    public static void print_menu()
    {
        System.out.println("-----------------MAIN MENU---------------");
        System.out.println("1 - Read input string of words");
        System.out.println("2 - Reverse string and display outputs");
        System.out.println("3 - Exit program");
    }
    public static void main(String[] args)
    {
        //initialize variables, stack, and scanner
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        String userString = "";
        int userOption = 0;
        while(userOption != 3)
        {
            print_menu();
            //getting user input
            userOption = scanner.nextInt();
            scanner.nextLine();
            switch(userOption)
            {
                //case for user input
                case 1:
                    System.out.println("Enter string: ");
                    userString = scanner.nextLine().strip();
                    break;
                //case for reversing and displaying
                case 2:
                    if(userString.isEmpty())
                    {
                        System.out.println("You need to enter a string first");
                        break;
                    }
                    //initialze array of words in user string
                    String[] words = userString.split(" ");
                    String reversedString = "";
                    //add all words to stack
                    for(String word : words)
                    {
                        stack.push(word);
                    }
                    //loop to reverse string
                    while(!stack.isEmpty())
                    {
                        reversedString += stack.pop() + " ";
                    }
                    //outputs
                    System.out.println("Entered string:\t\t" + userString);
                    System.out.println("Reversed string:\t" + reversedString);
                    break;
                //case to exit program
                case 3:
                    System.out.println("Exiting program");
                    break;
                //case for invalid options
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        //closing scanner
        scanner.close();
    }
}
