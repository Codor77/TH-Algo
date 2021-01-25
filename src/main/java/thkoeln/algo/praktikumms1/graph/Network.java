package thkoeln.algo.praktikumms1.graph;

import java.util.ArrayList;
import java.util.Dictionary;

public class Network {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private static Network self;

    private Network(){
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }

    public static Network getInstance(){
        if(self==null){
            self= new Network();
        }
        return self;
    }

    public void addNode(String name){
        throw new UnsupportedOperationException();
    }

    public void addNode(Node node){
        throw new UnsupportedOperationException();
    }

    public void removeNode(String name){
        throw new UnsupportedOperationException();
    }

    public void removeNode(Node node){
        throw new UnsupportedOperationException();
    }

    public Node findNode(String name){
        throw new UnsupportedOperationException();
    }

    public void addEdge(Node start, Node target, int length){
        throw new UnsupportedOperationException();
    }

    public void addEdge(String start, String target, int length){
        throw new UnsupportedOperationException();
    }

    public void addEdge(Edge edge){
        throw new UnsupportedOperationException();
    }

    public void removeEdge(Edge edge){
        throw new UnsupportedOperationException();
    }

    public ArrayList<Node> getAllNodes(){
        throw new UnsupportedOperationException();
    }

    public ArrayList<Edge> getAllEdges(){
        throw new UnsupportedOperationException();
    }

    public void clear(){
        throw new UnsupportedOperationException();
    }

    public String toString(){
        return nodes.toString() + "\n" + edges.toString();
    }
}
