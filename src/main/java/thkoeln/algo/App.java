package thkoeln.algo;

import thkoeln.algo.praktikumms1.graph.Network;
import thkoeln.algo.praktikumms1.graph.Node;
import thkoeln.algo.praktikumms1.dijkstra.*;
import thkoeln.algo.praktikumms2.AwesomePriorityQueue;
import thkoeln.algo.praktikumms2.InefficientPriorityQueue;
import thkoeln.algo.praktikumms2.UnsettledNode;


import java.util.ArrayList;
import java.util.Collections;



public class App {

    public static void main(String[] args) throws Exception {

        Network network = Network.getInstance();

        network.addNode("A");
        network.addNode("B");
        network.addEdge("A", "B", 5);

        network.addNode("C");
        network.addEdge("C", "A", 20);
        network.addNode("D");
        network.addEdge("D", "B", 3);
        network.addNode("E");
        network.addEdge("E", "D", 7);
        network.addEdge("E", "A", 14);

        Dijkstra dijkstra = new Dijkstra(network);
        dijkstra.printPredecessors();
        dijkstra.initializeFrom("A");
        dijkstra.printPredecessors();
        dijkstra.calculatePaths();
        dijkstra.printPredecessors();
        System.out.println(dijkstra.generateRoute("C"));
        System.out.println(dijkstra.generateRoute("E"));
        System.out.println(dijkstra.generateRoute("E","A"));


        System.out.println(network.getAllNodes());
        System.out.println(network.getAllEdges());

        System.out.println(network.findNode("A").edges.size());

        network.removeNode("A");

        System.out.println(network);

        network.clear();
        System.out.println(network);

        testPrioQueues(10);
        testPrioQueues(100);
        testPrioQueues(1000);
        testPrioQueues(10000);
        testPrioQueues(100000);

        }

    private static void testPrioQueues(int elements){
        ArrayList<UnsettledNode> testNodes = new ArrayList<UnsettledNode>();
        for(int i = 0;i<elements;i++){
            testNodes.add(new UnsettledNode(new Node(i+""),i));
        }

        Collections.shuffle(testNodes);

        System.out.println("ShittyPrioQueue at " + elements + " elements:");
        InefficientPriorityQueue<UnsettledNode> shittyQueue = new InefficientPriorityQueue<UnsettledNode>();

        long timer = System.nanoTime();
        for(int i=0;i<testNodes.size();i++){
            shittyQueue.insert(testNodes.get(i));
        }
        long time = System.nanoTime()-timer;
        System.out.println("Shitty insert: " + time);

        timer = System.nanoTime();
        while(shittyQueue.getSize()>0){
            shittyQueue.extractMin();
        }
        time = System.nanoTime()-timer;
        System.out.println("Shitty extract: " + time);

        System.out.println("AwesomePrioQueue at " + elements + " elements:");
        AwesomePriorityQueue<UnsettledNode> awesomeQueue = new AwesomePriorityQueue<UnsettledNode>();

        timer = System.nanoTime();
        for(int i=0; i<testNodes.size();i++){
            awesomeQueue.insert(testNodes.get(i));
        }
        time = System.nanoTime()-timer;
        System.out.println("Awesome insert: "+ time);

        timer = System.nanoTime();
        while(awesomeQueue.size >0){
            awesomeQueue.extractMin();
        }
        time = System.nanoTime()-timer;
        System.out.println("Awesome extract: "+ time);
    }
}
