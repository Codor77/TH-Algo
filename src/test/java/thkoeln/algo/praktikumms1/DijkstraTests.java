package thkoeln.algo.praktikumms1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import thkoeln.algo.praktikumms1.dijkstra.Dijkstra;
import thkoeln.algo.praktikumms1.dijkstra.Route;
import thkoeln.algo.praktikumms1.graph.*;

public class DijkstraTests {
    
    @Test
    public void routeFindingTestSimple(){

        Network network = Network.getInstance();
        network.clear();
        network.addNode("A");
        network.addNode("B");
        network.addEdge("A", "B", 5);
    
        network.addNode("C");
        network.addEdge("C", "A", 20);
        network.addNode("D");
        network.addEdge("D", "B", 3);
        network.addNode("E");
        network.addEdge("E", "D", 7);
        network.addEdge("E", "A", 16);
    
        Dijkstra dijkstra = new Dijkstra(network);
        
        
        dijkstra.initializeFrom("A");
        dijkstra.calculatePaths();

        Route testRoute = dijkstra.generateRoute("C");



        assertEquals(testRoute.getNodes().size(), 2, "Diese Route sollte 2 Knoten enthalten, enthält aber" +testRoute.getNodes().size());
        assertEquals(testRoute.getNodes().get(0).name, "C", "Knoten C (Ziel) sollte an Position 0 der Route stehen, es war aber " + testRoute.getNodes().get(0).name);
        assertEquals(testRoute.getNodes().get(1).name, "A", "Knoten A (Start) sollte an Position 1 der Route stehen, es war aber " + testRoute.getNodes().get(1).name);
        assertEquals(20, testRoute.getLength(), "Die erwartete Länge der Route war 20, diese hat aber eine Länge von " +testRoute.getLength());

        testRoute = dijkstra.generateRoute("E");
        assertEquals(testRoute.getNodes().size(), 4, "Diese Route sollte 4 Knoten enthalten, enthält aber " +testRoute.getNodes().size());
        assertEquals(testRoute.getNodes().get(0).name, "E", "Knoten E (Ziel) sollte an Position 0 der Route stehen, es war aber " + testRoute.getNodes().get(0).name);
        assertEquals(testRoute.getNodes().get(1).name, "D", "Knoten D (vorletzter Knoten) sollte an Position 1 der Route stehen, es war aber " + testRoute.getNodes().get(0).name);
        assertEquals(testRoute.getNodes().get(2).name, "B", "Knoten B (zweiter Knoten) sollte an Position 2 der Route stehen, es war aber " + testRoute.getNodes().get(0).name);
        assertEquals(testRoute.getNodes().get(3).name, "A", "Knoten A (Start) sollte an Position 3 der Route stehen, es war aber " + testRoute.getNodes().get(1).name);
        assertEquals(15, testRoute.getLength(), "Die erwartete Länge der Route war 15, diese hat aber eine Länge von " +testRoute.getLength());
    }

    @Test
    public void testRoutefindingMoreComplex(){
        Network network = Network.getInstance();
        network.clear();
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
        
        
        dijkstra.initializeFrom("A");
        dijkstra.calculatePaths();

        Route testRoute = dijkstra.generateRoute("E");

        assertEquals(testRoute.getNodes().size(), 2, "Diese Route sollte 2 Knoten enthalten, enthält aber" +testRoute.getNodes().size());
        assertEquals(testRoute.getNodes().get(0).name, "E", "Knoten E (Ziel) sollte an Position 0 der Route stehen, es war aber " + testRoute.getNodes().get(0).name);
        assertEquals(testRoute.getNodes().get(1).name, "A", "Knoten A (Start) sollte an Position 1 der Route stehen, es war aber " + testRoute.getNodes().get(1).name);
        assertEquals(14, testRoute.getLength(), "Die erwartete Länge der Route war 14, diese hat aber eine Länge von " +testRoute.getLength());

        dijkstra.initializeFrom("E");
        dijkstra.calculatePaths();

        testRoute = dijkstra.generateRoute("A");

        assertEquals(testRoute.getNodes().size(), 2, "Diese Route sollte 2 Knoten enthalten, enthält aber" +testRoute.getNodes().size());
        assertEquals(testRoute.getNodes().get(0).name, "A", "Knoten A (Ziel) sollte an Position 0 der Route stehen, es war aber " + testRoute.getNodes().get(0).name);
        assertEquals(testRoute.getNodes().get(1).name, "E", "Knoten E (Start) sollte an Position 1 der Route stehen, es war aber " + testRoute.getNodes().get(1).name);
        assertEquals(14, testRoute.getLength(), "Die erwartete Länge der Route war 14, diese hat aber eine Länge von " +testRoute.getLength());

    }


}
