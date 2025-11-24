/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 5
IDE Name: Microsoft Visual Studio
**/
import java.util.*;

public class TestQueue 
{
    //printing menu
    public static void print_menu()
    {
        System.out.println();
        System.out.println("--------MAIN MENU--------");
        System.out.println("1 - Enqueue element");
        System.out.println("2 - Dequeue element");
        System.out.println("3 - Get front element");
        System.out.println("4 - Get queue size");
        System.out.println("5 - Is Empty queue?");
        System.out.println("6 - Print queue");
        System.out.println("7 - Exit program");
        System.out.println();
    }
    public static void main(String[] args)
    {
        //initializing variables
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new Queue<Integer>();
        int userOption = 0;
        int newIntValue = 0;
        while(userOption != 7)
        {
            print_menu();
            System.out.println("Enter option number: ");
            userOption = scanner.nextInt();
            scanner.nextLine();
            switch(userOption)//switch for options
            {
                case 1://adding element to queue
                    System.out.println("Enter the value you want to add: ");
                    newIntValue = scanner.nextInt();
                    queue.enqueue(Integer.valueOf(newIntValue));
                    break;
                case 2://removing from queue
                    Integer dequeuedInteger = queue.dequeue();
                    if(dequeuedInteger != null)
                    {
                        System.out.println("Item dequeued: " + dequeuedInteger.intValue());
                    }
                    break;
                case 3://getting front element
                    if(queue.front() != null)
                    {
                        System.out.println("Front item: " + queue.front().intValue());
                    }
                    break;
                case 4://getting queue size
                    System.out.println("Queue size: " + queue.size());
                    break;
                case 5://seeing if empty
                    if(queue.isEmpty())
                    {
                        System.out.println("Queue is empty");
                    }
                    else
                    {
                        System.out.println("Queue is not empty");
                    }
                case 6://printing queue
                    if(queue.isEmpty())
                    {
                        System.out.println("Queue is empty");
                    }
                    else
                    {
                        Queue<Integer> copyQueue = new Queue<Integer>();
                        System.out.println("Queue:");
                        while(!queue.isEmpty())//print queue
                        {
                            Integer dequeuedValue = queue.dequeue();
                            //making copy of queue to preserve order
                            copyQueue.enqueue(dequeuedValue);
                            System.out.println(dequeuedValue.intValue());
                        }
                        while(!copyQueue.isEmpty())//recreating original queue
                        {
                            queue.enqueue(copyQueue.dequeue());
                        }
                    }
                case 7://exit program
                System.out.println("Exiting program");
                    break;
                default://all other inputs
                    System.out.println("Invalid option");
                    break;
            }
        }
        scanner.close();
    }
}
