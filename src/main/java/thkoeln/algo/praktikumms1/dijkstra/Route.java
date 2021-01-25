package thkoeln.algo.praktikumms1.dijkstra;

import java.util.ArrayList;
import thkoeln.algo.praktikumms1.graph.Node;

public class Route {
    private ArrayList<Node> nodes;
    private int length;

    public Route(){
        nodes = new ArrayList<Node>();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void setLength(int length){
        this.length = length;
    }

    public String toString(){
        String route = "Route: ";
        for(int i=0;i<nodes.size();i++){
            route += nodes.get(i).name + ":";
        }
        route += " length = " + length;
        return route;
    }

    public ArrayList<Node> getNodes(){
        return nodes;
    }

    public int getLength(){
        return length;
    }
}
