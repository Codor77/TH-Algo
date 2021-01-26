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
 * (Ergo Arraylist statt Array)
 */
public class AwesomePriorityQueue <T extends Comparable<T>>{
    private ArrayList<T> Heap; 
    public int size; 
  
    public AwesomePriorityQueue() {
        this.size = 0; 
        Heap = new ArrayList<T>();
//        Heap.add(0,null);
    } 
  
    // Function to return the position of 
    // the parent for the node currently 
    // at pos 
    private int parent(int pos) {
//        if(pos == 1)
//            return 1;
        return (pos-1) / 2;
    } 
  
    // Function to return the position of the 
    // left child for the node currently at pos 
    private int leftChild(int pos) {
        return (pos * 2)+1;
    } 
  
    // Function to return the position of 
    // the right child for the node currently 
    // at pos 
    private int rightChild(int pos) {
        return (pos * 2)+2;
    } 
  
    // Function that returns true if the passed 
    // node is a leaf node 
    private boolean isLeaf(int pos) {
        if (pos > ((size-2) / 2) && pos < size) {
            return true;
        }
        return false;
    } 
  
    // Function to swap two nodes of the heap 
    private void swap(int fpos, int spos) {
        T fNode = Heap.get(fpos);
        T sNode = Heap.get(spos);

        Heap.set(fpos,sNode);
        Heap.set(spos,fNode);
    } 
  
    // Function to heapify the node at pos 
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if(leftChild(pos) < size){
                if(rightChild(pos) < size){
                    if (Heap.get(pos).compareTo(Heap.get(leftChild(pos))) > 0 || Heap.get(pos).compareTo(Heap.get(rightChild(pos))) > 0) {
                        if (Heap.get(leftChild(pos)).compareTo(Heap.get(rightChild(pos))) < 0) {
                            swap(pos, leftChild(pos));
                            minHeapify(leftChild(pos));
                        }
                        else {
                            swap(pos, rightChild(pos));
                            minHeapify(rightChild(pos));
                        }
                    }
                }
            }
        }
    } 
  
    // Function to insert a node into the heap 
    public void insert(T element) {
        Heap.add(size,element);
        int current = size;
        size++;

        while (Heap.get(current).compareTo(Heap.get(parent(current))) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
//        System.out.println(element+" inserted");
    } 
  
    // Function to print the contents of the heap 
    public void print() {
//        for (int i = 1; i <= (size-2) / 2; i++) {
//            System.out.print(" PARENT : " + Heap.get(i)
//                             + " LEFT CHILD : " + Heap.get(2 * i)
//                             + " RIGHT CHILD :" + Heap.get(2 * i + 1));
//            System.out.println();
//        }
        for(int i = 0; i < size;i++){
            System.out.println("POS "+i+": "+Heap.get(i));
        }
    } 
  
    // Function to build the min heap using 
    // the minHeapify 
    public void minHeap() {
        for (int pos = ((size-2) / 2); pos > 0; pos--) {
            minHeapify(pos);
        }
    } 
  
    // Function to remove and return the minimum 
    // element from the heap 
    public T extractMin() {
        T min = Heap.get(0);
//        for(int i = 1;i < size;i++){
//            Heap.set(i-1,Heap.get(i));
//        }
        size--;
        Heap.set(0, Heap.get(size));
        Heap.remove(size);
        minHeapify(0);
//        System.out.println(min+" removed");
        return min;
    }
    public ArrayList<T> getHeap(){
        return Heap;
    }
}
