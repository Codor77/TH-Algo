package thkoeln.algo.praktikumms2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import thkoeln.algo.praktikumms1.graph.Node;

public class PrioQueueTests {
    @Test
    public void testInsert(){
        AwesomePriorityQueue<UnsettledNode> queue = new AwesomePriorityQueue<UnsettledNode>();
        assertEquals(0, queue.size, "Der Queue wurde gerade initialisiert und sollte 0 Elemente enthalten, enthält aber "+queue.size);
        queue.insert(new UnsettledNode(new Node("Test10"), 10));
        assertEquals(1, queue.size, "Dem Queue wurde ein item hinzugefügt und er sollte jetzt eine Größe von 1 haben, er hat aber eine Größe von " + queue.size);        
        queue.insert(new UnsettledNode(new Node("Test20"), 20));
        assertEquals(2, queue.size, "Dem Queue wurden zwei items hinzugefügt und er sollte jetzt eine Größe von 2 haben, er hat aber eine Größe von " + queue.size);        
    }

    @Test
    public void testExtractMin(){
        AwesomePriorityQueue<UnsettledNode> queue = new AwesomePriorityQueue<UnsettledNode>();
        queue.insert(new UnsettledNode(new Node("Test10"), 10));
        queue.insert(new UnsettledNode(new Node("Test20"), 20));
        UnsettledNode testNode = queue.extractMin();
        assertEquals("Test10", testNode.node.name, "Es wurde erwartet, dass node Test10 zurückgegeben wird, es kam aber " + testNode.node.name);
        assertEquals(10, testNode.distance, "Es wurde erwartet, dass der zurückgegebene Node eine Distanz von 10 hat, er hat aber " + testNode.distance);
        assertEquals(1, queue.size, "Zwei items wurden hinzugefügt, eines wieder durch Extraktion entfernt, der Queue sollte also 1 Element enthalten, enthält aber " + queue.size);
        queue.insert(new UnsettledNode(new Node("Test15"), 15));
        testNode = queue.extractMin();
        assertEquals("Test15", testNode.node.name, "Es wurde erwartet, dass node Test15 zurückgegeben wird, es kam aber " + testNode.node.name);
        assertEquals(15, testNode.distance, "Es wurde erwartet, dass der zurückgegebene Node eine Distanz von 15 hat, er hat aber " + testNode.distance);
    }

}
