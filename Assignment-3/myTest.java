/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 3
IDE Name: Microsoft Visual Studio
**/

import java.util.Scanner;

public class myTest
{
   public static void printMenu()
   {
      System.out.println();
      System.out.println("---------MAIN MENU--------");
      System.out.println("1 - Add First Node");
      System.out.println("2 - Add Last Node");
      System.out.println("3 - Add At Index");
      System.out.println("4 - Remove First Node");
      System.out.println("5 - Remove Last Node");
      System.out.println("6 - Remove At Index");
      System.out.println("7 - Print List Size");
      System.out.println("8 - Print List (Forward)");
      System.out.println("9 - Print List (In Reverse)");
      System.out.println("10 - Exit program");
      System.out.println("Enter option number: ");
   }
   public static void main (String[] args)
   {
      LinkedList myList = new LinkedList(); //create a list object
      Scanner scanner = new Scanner(System.in);
      //define variables
      int option = 0;
      int userData = 0;
      int userIndex = 0;
      while(option != 10)
      {
         printMenu();
         option = scanner.nextInt();
         scanner.nextLine();
         if(option == 1)
         {
            System.out.println("Enter number: ");
            userData = scanner.nextInt();
            scanner.nextLine();
            myList.addFirstNode(userData);
         }
         else if(option == 2)
         {
            System.out.println("Enter number: ");
            userData = scanner.nextInt();
            scanner.nextLine();
            myList.addLastNode(userData);
         }
         else if(option == 3)
         {
            System.out.println("Enter the index value: ");
            userIndex = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter number: ");
            userData = scanner.nextInt();
            scanner.nextLine();
            myList.addAtIndex(option, userData);
         }
         else if(option == 4)
         {
            myList.removeFirstNode();
         }
         else if(option == 5)
         {
            myList.removeLastNode();
         }
         else if(option == 6)
         {
            System.out.println("Enter the index value: ");
            userIndex = scanner.nextInt();
            scanner.nextLine();
            myList.removeAtIndex(userIndex);
         }
         else if(option == 7)
         {
            System.out.println("List size: " + myList.countNodes());
         }
         else if(option == 8)
         { 
            myList.printList();
         }
         else if(option == 9)
         {
            myList.printInReverse(myList.head);
         }
         else if(option == 10)
         {
            break;
         }
         else
         {
            System.out.println("Invalid option");
         }
      } 
      scanner.close();
   } 
}
    
