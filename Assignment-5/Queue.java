/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 5
IDE Name: Microsoft Visual Studio
**/


public class Queue<E>
{
    public Node<E> front;
    public Node<E> back;
    public int size;

    private static class Node <E>
    {
        E data;  //data field
        Node<E> next; //link field
       
        Node(E data) //constructor method
        {
            this.data = data;
            this.next = null;
        }
    }

    public Queue()//default constructor
    {
        front = null;
        back = null;
        size = 0;
    }

    public void enqueue(E data)//adds datat to queue
    {
        Node<E> newNode = new Node<E>(data);
        if (front == null)//if queue is empty
        {
            front = back = newNode;
        }
        else//otherwise add at end
        {
            back.next = newNode;
            back = newNode;
        }
        size++;
    }

    public E dequeue()
    {
        if(isEmpty())//checks if the queue is empty before dequeueing
        {
            System.out.println("Queue is empty");
            return null;
        }
        //dequeue the first node and shift front
        E data = front.data;
        front = front.next;
        size--;
        if (front == null)//checks if queue is empty after dequeueing
        {
            back = null;
        }
        return data;
    }

    public E front()
    {
        if(isEmpty())//checks if queue is empty
        {
            System.out.println("Queue is empty");
            return null;
        }
        else//else returns front node data
        {
            return front.data;
        }
    }

    public int size()//returns size of the queue
    {
        return size;
    }

    public boolean isEmpty()//returs whether queue is empty or not
    {
        if(front == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
