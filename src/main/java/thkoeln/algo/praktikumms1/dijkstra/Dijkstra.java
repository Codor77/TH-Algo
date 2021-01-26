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
        startNode = node;
        unsettled.add(startNode);
        for(Node iNode : network.getAllNodes()){
            Predecessor newPred;
            if(iNode == startNode)
                newPred = new Predecessor(null,0);
            else
                newPred = new Predecessor(null,Integer.MAX_VALUE);

            predecessors.put(iNode,newPred);
        }
    }

    public void initializeFrom(String node){
        initializeFrom(network.findNode(node));
    }

    private Node getLowestUnsettled(){
        Node lowestUnsettled = null;
        for(Node node : unsettled){
            if (lowestUnsettled == null) {
                lowestUnsettled = node;
            }
            else if (predecessors.get(node).length < predecessors.get(lowestUnsettled).length){
                lowestUnsettled = node;
            }
        }
        return lowestUnsettled;
    }

    private void settleNode(Node node){
        unsettled.remove(node);
        settled.add(node);
    }

    public void calculatePaths(){
        while (!unsettled.isEmpty()){
            Node lowestUnsettled = getLowestUnsettled();
            int edgeCount = lowestUnsettled.edges.size();
            for(int i = 0; i<edgeCount; i++){
                Edge currentEdge = lowestUnsettled.edges.get(i);
                if(currentEdge.start == lowestUnsettled){
                    int newLength = predecessors.get(lowestUnsettled).length + currentEdge.length;
                    if(newLength < predecessors.get(currentEdge.target).length){
                        predecessors.get(currentEdge.target).predecessor = lowestUnsettled;
                        predecessors.get(currentEdge.target).length = newLength;
                        unsettled.add(currentEdge.target);
                    }
                }
                if(currentEdge.target == lowestUnsettled){
                    int newLength = predecessors.get(lowestUnsettled).length + currentEdge.length;
                    if(newLength < predecessors.get(currentEdge.start).length){
                        predecessors.get(currentEdge.start).predecessor = lowestUnsettled;
                        predecessors.get(currentEdge.start).length = newLength;
                        unsettled.add(currentEdge.start);
                    }
                }
            }
            settleNode(lowestUnsettled);
        }
    }

    public Route generateRoute(Node target){
        Route route = new Route();
        route.addNode(target);
        Node predecessor = predecessors.get(target).predecessor;
        while(predecessor != startNode){
            route.addNode(predecessor);
            predecessor = predecessors.get(predecessor).predecessor;
        }
        route.addNode(predecessor);
        route.setLength(predecessors.get(target).length);
        return route;
    }

    public Route generateRoute(String target){
        return generateRoute(network.findNode(target));
    }

    public Route generateRoute(Node start, Node target){
        Dijkstra tempDijkstra = new Dijkstra(network);
        tempDijkstra.initializeFrom(start);
        tempDijkstra.calculatePaths();
        return tempDijkstra.generateRoute(target);
    }

    public Route generateRoute(String start, String target){
        return generateRoute(network.findNode(start),network.findNode(target));

    }

    public void printPredecessors(){
        System.out.println(predecessors);
    }

    public void printUnsettled(){
        System.out.println(unsettled);
    }
    public void printSettled(){
        System.out.println(settled);
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
