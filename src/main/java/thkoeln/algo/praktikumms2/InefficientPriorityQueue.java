package thkoeln.algo.praktikumms2;

import java.util.ArrayList;

/***
 * Das hier ist, wie unschwer zu erkennen ist, eine korrekte aber extrem ineffiziente
 * Implementierung eines Min Extractors, sie dient dem Vergleich mit dem 
 * zu implementierenden Heap und sollte entsprechend nicht verändert werden.
 * Die öffentlichen Methodennamen entsprechen denen eines Heaps, die Operationen sind 
 * aber hier natürlich weitaus primitiver.
 */
public class InefficientPriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> unsortedItems; 

    public InefficientPriorityQueue(){
        unsortedItems = new ArrayList<T>();
    }

    public void insert(T node){
        unsortedItems.add(node);
    }

    public T extractMin(){
        T item = getMin();
        unsortedItems.remove(item);
        return item;
    }

    public T getMin(){
        int minPos=0;
        for(int i=0; i<unsortedItems.size();i++){
            if(unsortedItems.get(minPos).compareTo(unsortedItems.get(i))>0){
                minPos=i;
            }
        }
        T item = unsortedItems.get(minPos);
        return item;
    }

    public int getSize(){
        return unsortedItems.size();
    }
}
