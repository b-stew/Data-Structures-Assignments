/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 7
IDE Name: Microsoft Visual Studio
**/

// Generic code for class priority_queue_heap for Assignment 7 

public class PQ_heap<E extends Comparable<E>>
{	
	private Heap<E> heap;

	// Constructor method
    PQ_heap() 
	{
		this.heap = new Heap<>();
	};

	// Return true if priority queue is empty; otherwise return false
    public boolean is_empty() 
	{
		return heap.getSize() == 0;
	};
	
	// Return true if priority queue is full; otherwise return false
    public boolean is_full() 
	{
		return heap.getSize() == this.heap.capacity;
	};

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
    public E front() 
	{
		if(is_empty())
		{
			return null;
		}
		else
		{
			return heap.getFront();
		}
	};

	// return number of elements in the queue
    public int size() 
	{
		return heap.getSize();
	};
   
	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
    public E dequeue() 
	{
		if(is_empty())
		{
			return null;
		}
		else
		{
			return heap.remove();
		}
	};

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
    public void enqueue(E value) 
	{
		heap.add(value);
	};

	public void printQueue()
	{
		heap.printHeap();
	}
};
