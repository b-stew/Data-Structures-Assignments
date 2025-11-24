/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 7
IDE Name: Microsoft Visual Studio
**/

import java.util.*;

public class TestPQH
{
    public static void print_menu()
    {
        System.out.println();
        System.out.println("----------------MAIN MENU---------------");
        System.out.println("0. Enter Queue Type (integer or string)");
        System.out.println("1. Enqueue Element");
        System.out.println("2. Dequeue Element");
        System.out.println("3. Check is_Full");
        System.out.println("4. Check is_Empty");
        System.out.println("5. Print PQueue Size");
        System.out.println("6. Display Front Element");
        System.out.println("7. Print PQueue Elements");
        System.out.println("8. Exit program");
        System.out.println();
    }
    public static void main(String[] args)
    {
        //initialize objects and variables
        Scanner scanner = new Scanner(System.in);
        PQ_heap<Integer> priorityIntegerQueue = new PQ_heap<Integer>();
        PQ_heap<String> priorityStringQueue = new PQ_heap<String>();
        String queueType = "";
        String userStringElement = "";
        int userIntElement = 0;
        int userOption = -1;
        while(!(queueType.equals("integer")||queueType.equals("string")))
        {
            System.out.println("Enter Queue Type (integer or string)");
            queueType = scanner.nextLine().strip().toLowerCase();
        }
        while(userOption != 8)
        {
            print_menu();
            System.out.println("Enter an option: ");
            userOption = scanner.nextInt();
            scanner.nextLine();
            switch(userOption)
            {
                case 0://change type
                    System.out.println("Enter Queue Type (integer or string)");
                    queueType = scanner.nextLine().strip().toLowerCase();
                    break;
                case 1://enqueue
                    System.out.println("Enter the element you want to add: ");
                    if(queueType.equals("integer"))
                    {
                        userIntElement = scanner.nextInt();
                        scanner.nextLine();
                        priorityIntegerQueue.enqueue(userIntElement);
                    }
                    else
                    {
                        userStringElement = scanner.nextLine().strip();
                        priorityStringQueue.enqueue(userStringElement);
                    }
                    break;
                case 2://dequeue
                    if(queueType.equals("integer"))
                    {
                        if(priorityIntegerQueue.is_empty())//empty case
                        {
                            System.out.println("Queue is empty.");
                        }
                        else
                        {
                            System.out.println("Dequeued Value: " + priorityIntegerQueue.dequeue());
                        }
                    }
                    else
                    {
                        if(priorityStringQueue.is_empty())//empty case
                        {
                            System.out.println("Queue is empty.");
                        }
                        else
                        {
                            System.out.println("Dequeued Value: " + priorityStringQueue.dequeue());
                        }
                    }
                    break;
                case 3://check is_full
                    if(queueType.equals("integer"))
                    {
                        if(priorityIntegerQueue.is_full())//full case
                        {
                            System.out.println("Queue is full.");
                        }
                        else
                        {
                            System.out.println("Queue is not full");
                        }
                    }
                    else
                    {
                        if(priorityStringQueue.is_full())//full case
                        {
                            System.out.println("Queue is full.");
                        }
                        else
                        {
                            System.out.println("Queue is not full");
                        }
                    }
                    break;
                case 4://check is_empty
                    if(queueType.equals("integer"))
                    {
                        if(priorityIntegerQueue.is_empty())//empty case
                        {
                            System.out.println("Queue is empty.");
                        }
                        else
                        {
                            System.out.println("Queue is not empty");
                        }
                    }
                    else
                    {
                        if(priorityStringQueue.is_empty())//empty case
                        {
                            System.out.println("Queue is empty.");
                        }
                        else
                        {
                            System.out.println("Queue is not empty");
                        }
                    }
                    break;
                case 5://print PQueue size
                    if(queueType.equals("integer"))
                    {
                        System.out.println("Queue size: " + priorityIntegerQueue.size());
                    }
                    else
                    {
                        System.out.println("Queue size: " + priorityStringQueue.size());
                    }
                    break;
                    case 6://display front
                    if(queueType.equals("integer"))
                    {
                        if(priorityIntegerQueue.is_empty())//empty case
                        {
                            System.out.println("Queue is empty.");
                        }
                        else
                        {
                            System.out.println("Front Value: " + priorityIntegerQueue.front());
                        }
                    }
                    else
                    {
                        if(priorityStringQueue.is_empty())//empty case
                        {
                            System.out.println("Queue is empty.");
                        }
                        else
                        {
                            System.out.println("Front Value: " + priorityIntegerQueue.front());
                        }
                    }
                    break;
                case 7://print elements
                    if(queueType.equals("integer"))
                    {
                        if(priorityIntegerQueue.is_empty())//empty case
                        {
                            System.out.println("Queue is empty.");
                        }
                        else
                        {
                            priorityIntegerQueue.printQueue();
                        }
                    }
                    else
                    {
                        if(priorityStringQueue.is_empty())//empty case
                        {
                            System.out.println("Queue is empty.");
                        }
                        else
                        {
                            priorityStringQueue.printQueue();
                        }
                    }
                    break;
                case 8://exit program
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
