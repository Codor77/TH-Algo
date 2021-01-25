package thkoeln.algo.praktikumms2;

import java.util.ArrayList;

/***
 * Hier kommt eure viel bessere Implementierung rein!
 * Implementiert hierfür einen Binary Heap (ist von den Heaps 
 * so ziemlich der verständlichste)
 * 
 * Die Struktur orientiert sich an folgendem Code:
 * https://www.geeksforgeeks.org/min-heap-in-java/
 * 
 * Der Verständlichkeit halber kann er gerne benutzt werden, 
 * muss allerdings angepasst werden um mit Generics 
 * (oder zumindest UnsettledNodes) zu funktionieren.
 * (Ergo Arraylist statts Array)
 */
public class AwesomePriorityQueue <T extends Comparable<T>>{
    private ArrayList<T> Heap; 
    public int size; 
  
    public AwesomePriorityQueue() 
    { 
        this.size = 0; 
        Heap = new ArrayList<T>(); 
    } 
  
    // Function to return the position of 
    // the parent for the node currently 
    // at pos 
    private int parent(int pos) 
    { 
        throw new UnsupportedOperationException();
    } 
  
    // Function to return the position of the 
    // left child for the node currently at pos 
    private int leftChild(int pos) 
    { 
        throw new UnsupportedOperationException();
    } 
  
    // Function to return the position of 
    // the right child for the node currently 
    // at pos 
    private int rightChild(int pos) 
    { 
        throw new UnsupportedOperationException();
    } 
  
    // Function that returns true if the passed 
    // node is a leaf node 
    private boolean isLeaf(int pos) 
    { 
        throw new UnsupportedOperationException();
    } 
  
    // Function to swap two nodes of the heap 
    private void swap(int fpos, int spos) 
    { 
        throw new UnsupportedOperationException();
    } 
  
    // Function to heapify the node at pos 
    private void minHeapify(int pos) 
    { 
  throw new UnsupportedOperationException();
    } 
  
    // Function to insert a node into the heap 
    public void insert(T element) 
    { 
        throw new UnsupportedOperationException();
    } 
  
    // Function to print the contents of the heap 
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap.get(i) 
                             + " LEFT CHILD : " + Heap.get(2 * i) 
                             + " RIGHT CHILD :" + Heap.get(2 * i + 1)); 
            System.out.println(); 
        } 
    } 
  
    // Function to build the min heap using 
    // the minHeapify 
    public void minHeap() 
    { 
        throw new UnsupportedOperationException();
    } 
  
    // Function to remove and return the minimum 
    // element from the heap 
    public T extractMin() 
    { 
        throw new UnsupportedOperationException();
    } 
}
