/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 4
IDE Name: Microsoft Visual Studio
**/

public class Stack<E>
{
    public Node <E> top;
    public int size;

    private static class Node <E>
    {
        E data;  //data field
        Node<E> next; //link field
       
        Node(E data, Node<E> next) //constructor method
        {
            this.data = data;
            this.next = next;
        }
    }    
    //constructor method to create a list of object with head, tail, and size. 
    public Stack()
    {
        top = null;
    }
    public void push(E data)
    {
        //create new node with provided data
        Node<E> newNode = new Node<E>(data,top);
        top = newNode;
        size++;
    }
    public E pop()
    {
        //case for stack being empty
        if(isEmpty())
        {
            return null;
        }
        else
        {
            //removing top item in stack
            E tempData = top.data;
            top = top.next;
            size--;
            return tempData;
        }
    }
    public E top()
    {
        //case for stack being empty
        if(isEmpty())
        {
            System.out.println("Stack empty");
            return null;
        }
        else
        {
            return top.data;
        }
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        if(size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
