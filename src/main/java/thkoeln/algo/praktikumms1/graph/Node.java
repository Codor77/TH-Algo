package thkoeln.algo.praktikumms1.graph;

import java.util.ArrayList;

public class Node {
    public final String name;
    public ArrayList<Edge> edges;

    private Node(){
        name = null;
    }

    public Node(String name){
        this.name = name;
        edges = new ArrayList<Edge>();
    }

    public ArrayList<Node> getNeighbors(){
        ArrayList<Node> neighbors = new ArrayList<Node>();
        for (int i=0;i<edges.size();i++){
            Edge edge = edges.get(i);
            if(edge.start != this){
                neighbors.add(edge.start);
            }
            else{
                neighbors.add(edge.target);
            }
        }
        return neighbors;
    }

    public String toString(){
        return name;
    }

}
