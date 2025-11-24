/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 4
IDE Name: Microsoft Visual Studio
**/
import java.util.*;

public class CheckPalindrome 
{
    //prints menu
    public static void print_menu()
    {
        System.out.println("-----------------MAIN MENU----------------");
        System.out.println("1 - Read input string");
        System.out.println("2 - Check palindrome and display output");
        System.out.println("3 - Exit program");
        System.out.print("Enter option number: ");
    }
    public static void main(String[] args)
    {
        //initialize variables, stack, and scanner
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
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
                //reading case
                case 1:
                    System.out.println("Enter a string: ");
                    userString = scanner.nextLine().strip();
                    break;
                //checking case
                case 2:
                    //checks for stack being empty
                    if(userString.isEmpty())
                    {
                        System.out.println("Enter a string first");
                    }
                    else
                    {
                        //initialize strings
                        String formattedString = userString.toLowerCase();
                        String reversedString = "";
                        //push all characters to stack
                        for(char c : formattedString.toCharArray())
                        {
                            stack.push(c);
                        }
                        //loop through stack to reverse string
                        while(!stack.isEmpty())
                        {
                            reversedString += stack.pop();
                        }
                        //case for if palindrome
                        if(formattedString.equals(reversedString))
                        {
                            System.out.println("Entered string: " + userString);
                            System.out.println("Judgement: Palindrome");
                        }
                        //case for not palindrome
                        else
                        {
                            System.out.println("Entered string: " + userString);
                            System.out.println("Judgement: Not Palindrome");
                        }
                    }
                    break;
                //exiting case
                case 3:
                    System.out.println("Exiting program");
                    break;
                //invalid option case
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        //closing scanner
        scanner.close();
    }
}
