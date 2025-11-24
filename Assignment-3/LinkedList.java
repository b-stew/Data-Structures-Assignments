/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 3
IDE Name: Microsoft Visual Studio
**/

public class LinkedList
{
   public Node head, tail;

   //constructor method to create a list of object with head, tail, and size. 
   public LinkedList()
   {
      head = null;
      tail = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (tail == null) 
         head = tail = new Node(data); //empty list
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   public void addFirstNode(int data)
   {
      Node newNode = new Node(data);
      if(head == null)//if list is empty
      {
         head = tail = newNode;
      }
      else//if list isnt empty
      {
         newNode.next = head;
         head = newNode;
      }
   }
      
   //method #2: add node at index
   public void addAtIndex(int index, int data)
   {
      if(index == 0)
      {
         addFirstNode(data);
         return;
      }
      Node newNode = new Node(data);
      Node prevNode = head;
      //loop through list to get to node before target index
      for(int i = 0; i < index - 1; i++)
      {
         prevNode = prevNode.next;
         if(prevNode == null)
         {
            System.out.println("Out of bounds...");
            return;
         }
      }
      //adding new node if successful
      newNode.next = prevNode.next;
      prevNode.next = newNode;
   }
      
   //method #3: remove first node
   public void removeFirstNode()
   {
      if(head == null)//if list is empty
      {
         System.out.println("List is empty");
      }
      else//if list isnt empty
      {
         head = head.next;
      }
   }
      
   //method #4: remove last node
   public void removeLastNode()
   {
      Node tempNode = head;
      while(tempNode.next != tail)//loop through list to get to node before last node
      {
         tempNode = tempNode.next;
      }
      //removing last node
      tempNode.next = null;
      tail = tempNode;
   }
    
   //method #5: remove node at index
   public void removeAtIndex(int index)
   {
      if(index == 0)//if first node
      {
         removeFirstNode();
         return;
      }
      Node prevNode = head;
      //loop to previous node
      for(int i = 0; i < index - 1; i++)
      {
         prevNode = prevNode.next;
         if (prevNode == null || prevNode.next == null) 
         {
            System.out.println("Index out of bounds");
            return;
         }
      }
      prevNode.next = prevNode.next.next;
   }
          
   //method #6: countNodes
   public int countNodes()
   {
      int listSize= 0;
      Node currNode = head;
      while (currNode != null)
      {
         listSize++;
         currNode = currNode.next;
      }
      return listSize;      
   }
   
   //method #7: pritnInReverse  (Recursive method)
   public void printInReverse(Node L)
   {
      //complete this method as recursive methods
      if(L != null)
      {
         printInReverse(L.next);
         System.out.println(L.data + " ");
      }
      else
      {
         return;
      }
   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = head;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

