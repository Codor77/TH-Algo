package thkoeln.algo.praktikumms1.graph;

import java.util.ArrayList;

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
        Node newNode = new Node(name);
        addNode(newNode);
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void removeNode(String name){
        Node node = findNode(name);
        if(node == null) {
            System.out.println("Node '" + name + "' does not exist!");
            return;
        }
        removeNode(node);
    }

    public void removeNode(Node node){
        int edgeCount = node.edges.size();
        for(int i = 0; i<edgeCount; i++){
            Edge currentEdge = node.edges.get(0);
            removeEdge(currentEdge);
        }
        nodes.remove(node);
    }

    public Node findNode(String name){
        for(Node node : nodes){
            if(node.name == name)
                return node;
        }
        return null;
    }

    public void addEdge(Node start, Node target, int length){
        Edge newEdge = new Edge(start,target,length);
        addEdge(newEdge);
    }

    public void addEdge(String start, String target, int length){
        Node startNode = findNode(start);
        Node targetNode = findNode(target);
        addEdge(startNode, targetNode, length);
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public void removeEdge(Edge edge){
        edges.remove(edge);
        edge.start.edges.remove(edge);
        edge.target.edges.remove(edge);
    }

    public ArrayList<Node> getAllNodes(){
        return nodes;
    }

    public ArrayList<Edge> getAllEdges(){
        return edges;
    }

    public void clear(){
        nodes.clear();
        edges.clear();
    }

    public String toString(){
        return nodes.toString() + "\n" + edges.toString();
    }
}