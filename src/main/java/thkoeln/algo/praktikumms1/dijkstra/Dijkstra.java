package thkoeln.algo.praktikumms1.dijkstra;

import java.util.HashMap;
import java.util.ArrayList;
import thkoeln.algo.praktikumms1.graph.*;

public class Dijkstra {
    
    private Network network;
    private Node startNode;
    private Boolean generated;
    private HashMap<Node, Predecessor> predecessors;
    private ArrayList<Node> unsettled, settled;

    private Dijkstra(){}

    public Dijkstra(Network network){
        this.network = network;
        predecessors = new HashMap<Node, Predecessor>();
        unsettled = new ArrayList<Node>();
        settled = new ArrayList<Node>();
        startNode = null;
    }

    public void initializeFrom(Node node){
        throw new UnsupportedOperationException();
    }

    public void initializeFrom(String node){
        throw new UnsupportedOperationException();
    }

    private Node getLowestUnsettled(){
        throw new UnsupportedOperationException();
    }

    private void settleNode(Node node){
        throw new UnsupportedOperationException();
    }

    public void calculatePaths(){
        throw new UnsupportedOperationException();
    }

    public Route generateRoute(Node target){
        throw new UnsupportedOperationException();
    }

    public Route generateRoute(String target){
        throw new UnsupportedOperationException();
    }

    public Route generateRoute(Node start, Node target){
        throw new UnsupportedOperationException();
    }

    public Route generateRoute(String start, String target){
        throw new UnsupportedOperationException();
    }

    public void printPredecessors(){
        System.out.println(predecessors);
    }

    
    private class Predecessor{
        public Node predecessor;
        public int length;

        public Predecessor(Node predecessor, int length){
            this.predecessor = predecessor;
            this.length = length;
        }

        public String toString(){
            if(predecessor==null)
                return "null:" + length;
            return predecessor.name + ":" + length;
        }
    }
}
