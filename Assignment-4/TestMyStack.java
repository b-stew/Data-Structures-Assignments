/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 4
IDE Name: Microsoft Visual Studio
**/

import java.util.*;

public class TestMyStack
{
    //prints menu
    public static void print_menu()
    {
        System.out.println("--------MAIN MENU-------");
        System.out.println("1 - Push element");
        System.out.println("2 - Pop element");
        System.out.println("3 - Get top element");
        System.out.println("4 - Get stack size");
        System.out.println("5 - Is empty stack?");
        System.out.println("6 - Print stack");
        System.out.println("7 - Exit program");
        System.out.println("Enter option number:");
        return;
    }
    public static void printStack(Stack<Integer> stack)
    {
        //checks for stack being empty
        if(stack.isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        //creates temporary stack
        Stack<Integer> tempStack = new Stack<Integer>();
        //loops through stack and prints values
        while(!stack.isEmpty())
        {
            int tempInteger = stack.pop();
            System.out.println(tempInteger + " ");
            //adds items to temporary stack in order to preserve stack
            tempStack.push(Integer.valueOf(tempInteger));
        }
        //loops through temporary stack to restore original stack
        while(!tempStack.isEmpty())
        {
            stack.push(Integer.valueOf(tempStack.pop()));
        }
    }
    public static void main(String[] args)
    {
        //initialize variables, stack, and scanner
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int userOption = 0;
        
        while(userOption != 7)
        {
            print_menu();
            //getting user input
            userOption = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch(userOption)
            {
                //case for pushing value
                case 1:
                    //getting user input
                    System.out.println("Enter value: ");
                    int userInteger = scanner.nextInt();
                    scanner.nextLine();
                    //pushing user input to stack
                    stack.push(Integer.valueOf(userInteger));
                    break;
                //case for popping value
                case 2:
                    Integer poppedValue = stack.pop();
                    //checks if popped value is returned
                    if(poppedValue != null)
                    {
                        System.out.println("Popped value: " + stack.pop());
                    }
                    //case if stack is empty
                    else
                    {
                        System.out.println("Stack empty");
                    }
                    break;
                //case for top element
                case 3:
                    System.out.println("Top element: " + stack.top());
                    break;
                //case for returning stack size
                case 4:
                    System.out.println("Stack size: " + stack.size());
                    break;
                //case for if stack is empty
                case 5:
                    if(stack.isEmpty())
                    {
                        System.out.println("Stack is empty");
                    }
                    else
                    {
                        System.out.println("Stack is not empty");
                    }
                    break;
                //case for printing stack
                case 6:
                    printStack(stack);
                    break;  
                //case for exiting program
                case 7:
                    System.out.println("Exiting program");
                    break;
                //case for invalid options
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        scanner.close();
    }
}
