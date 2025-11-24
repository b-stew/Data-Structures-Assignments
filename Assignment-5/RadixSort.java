/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 5
IDE Name: Microsoft Visual Studio
**/
import java.util.*;

public class RadixSort 
{
    public static Queue<Integer>[] queueArray;
    public static void radixSort(int[] arr)
    {
        queueArray = new Queue[10];
        int maxLength = 0;
        for(int i = 0; i < 10; i++)//create new Integer queues for array
        {
            queueArray[i] = new Queue<Integer>();
        }
        for(int value: arr)//loop to find the longest element
        {
            if(countDigits(value) > maxLength)
            {
                maxLength = countDigits(value);
            }
        }
        for(int i = 1; i <= maxLength; i++)
        {
            for(int value: arr)//loop to take specified digit and add it to respective queues
            {
                queueArray[extractDigit(value, i)].enqueue(value);
            }
            int j = 0;
            for(Queue<Integer> queue: queueArray)//loop to recreate the numbers using previous queues
            {
                while(!queue.isEmpty())
                {
                    arr[j] = queue.dequeue();
                    j++;
                }
            }
        }
    }
    public static int countDigits(int value)//counts number of digits in value provided
    {
        int count = 0;
        if(value == 0)//if value is 0
        {
            return 1;
        }
        while(value != 0)//loop to count digits with integer division
        {
            value /= 10;
            count++;
        }
        return count;
    }
    public static int extractDigit(int value, int digitIndex)//extracts specidied digit at index
    {
        return (int) (value / Math.pow(10, digitIndex - 1)) % 10;
    }
    public static void printArray(int[] arr)//prints array
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(i+1 == arr.length)//if element is last in array
            {
                System.out.println(arr[i]);
            }
            else//all other elements
            {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println();
    }
    public static void print_menu()//prints menu
    {
        System.out.println();
        System.out.println("---------------MAIN MENU---------------");
        System.out.println("1 - Read array size");
        System.out.println("2 - Read array values");
        System.out.println("3 - Run Radix Sort and print outputs");
        System.out.println("4 - Exit program");
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int arraySize = 0, userOption = 0;
        int[] userValues = null;
        while(userOption != 4)
        {
            print_menu();
            System.out.println("Enter option number: ");
            userOption = scanner.nextInt();
            switch(userOption)
            {
                case 1://reading array size
                    System.out.println("Enter array size: ");
                    arraySize = scanner.nextInt();
                    userValues = new int[arraySize];
                    break;
                case 2://reading array valuues
                    if(userValues == null)//if size not entered
                    {
                        System.out.println("Enter array size first");
                        break;
                    }
                    for(int i = 0; i < arraySize; i++)//loop to accept values
                    {
                        System.out.println("Enter value " + (i+1) + ":");
                        userValues[i] = scanner.nextInt();
                    }
                    break;
                case 3:
                    if(userValues == null)//if size not entered
                    {
                        System.out.println("Enter array size first");
                        break;
                    }
                    System.out.println("Array values before sorting:\t");
                    printArray(userValues);

                    radixSort(userValues);

                    System.out.println("Array values after sorting:\t");
                    printArray(userValues);
                    break;
                case 4://exit program
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
