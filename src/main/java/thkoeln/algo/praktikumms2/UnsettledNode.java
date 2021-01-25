package thkoeln.algo.praktikumms2;

import thkoeln.algo.praktikumms1.graph.Node;


public class UnsettledNode implements Comparable<UnsettledNode> {
    
    public final Node node;
    public int distance;

    private UnsettledNode(){
        node = null;
        distance = 0;

    }

    public UnsettledNode(Node node, int distance){
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(UnsettledNode o) {
        return distance - o.distance;
    }

}
