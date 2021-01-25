package thkoeln.algo.praktikumms1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import thkoeln.algo.praktikumms1.graph.*;

public class NetworkFeatureTests {
    

    @Test
    public void testClearNetwork(){
        Network network = Network.getInstance();
        network.clear();
        Node na = new Node("A");
        network.addNode(na);
        network.addNode("B");
        network.clear();
        assertEquals(0, network.getAllNodes().size(), 
        "Netz wurde gecleared und sollte 0 nodes enthalten, enthält aber "+network.getAllNodes().size());
    }

    @Test
    public void testAddGetNodes(){
        Network network = Network.getInstance();
        network.clear();
        Node na = new Node("A");
        network.addNode(na);
        network.addNode("B");

        assertEquals(na, network.getAllNodes().get(0), 
        "Knoten A (Objektübergabe) wurde nicht korrekt eingefügt");
        assertEquals("B", network.getAllNodes().get(1).name, 
        "Knoten B (Erzeugung per Name) wurde nicht korrekt eingefügt");
    }
    @Test
    public void testAddGetEdges(){
        Network network = Network.getInstance();
        network.clear();
        Node na = new Node("A");
        Node nb = new Node("B");
        Node nc = new Node("C");
        network.addNode(na);
        network.addNode(nb);
        network.addNode(nc);
        network.addEdge("A", "B", 5);
        network.addEdge(nc, na, 20);

        assertEquals(na, network.getAllEdges().get(0).start, 
        "Startpunkt der ersten Edge (Generierung per Name) ist inkorrekt"); 
        assertEquals(nb, network.getAllEdges().get(0).target, 
        "Zielpunkt der ersten Edge (Generierung per Name) ist inkorrekt"); 
        assertEquals(nc, network.getAllEdges().get(1).start, 
        "Startpunkt der zweiten Edge (Generierung per Referenz) ist inkorrekt"); 
        assertEquals(na, network.getAllEdges().get(1).target,
         "Zielpunkt der zweiten Edge (Generierung per Referenz) ist inkorrekt"); 
        assertEquals(5, network.getAllEdges().get(0).length, 
        "Länge der ersten Edge (Generierung per Name) ist inkorrekt"); 
        assertEquals(20, network.getAllEdges().get(1).length, 
        "Länge der zweiten Edge (Generierung per Referenz) ist inkorrekt"); 
    }

    @Test
    public void testRemoveNode(){
        Network network = Network.getInstance();
        network.clear();
        Node na = new Node("A");
        Node nb = new Node("B");
        network.addNode(na);
        network.addNode(nb);

        assertEquals(2, network.getAllNodes().size(), 
        "Anzahl an Knoten stimmt nicht nach einfügen");

        network.removeNode(na);

        assertEquals(nb, network.getAllNodes().get(0), 
        "Falscher Knoten entfernt oder kein Knoten entfernt");
        assertEquals(1, network.getAllNodes().size(), 
        "Anzahl an Knoten stimmt nicht nach entfernen eines Knotens");

        network.removeNode("B");

        assertEquals(0, network.getAllNodes().size(), 
        "Knotenliste sollte leer sein, ist aber nicht der Fall");

    }
    @Test
    public void testRemoveEdge(){
        Network network = Network.getInstance();
        network.clear();
        Node na = new Node("A");
        Node nb = new Node("B");
        network.addNode(na);
        network.addNode(nb);

        Edge eab = new Edge(na, nb, 15);
        network.addEdge(eab);
        assertEquals(1, network.getAllEdges().size(), 
        "Netzwerk wurde Edge zugewiesen und sollte jetzt 1 Edge enthalten, enthält aber " +network.getAllEdges().size());
        network.removeEdge(eab);
        assertEquals(0, network.getAllEdges().size(), 
        "Edge wurde aus Netzwerk entfernt, sollte jetzt 0 Edgea enthalten, enthält aber " +network.getAllEdges().size());
    }
}
