package edu.hw9;

import edu.hw9.task3.Node;
import edu.hw9.task3.ParallelDepthFirstSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class ParallelDepthFirstSearchTest {

    @Test
    void testParallelDepthFirstSearch() {
        Node root = buildGraph();
        Set<Integer> visitedNodes = new HashSet<>();

        ParallelDepthFirstSearch.parallelDepthFirstSearch(root);

        collectVisitedNodes(root, visitedNodes);

        Assertions.assertTrue(visitedNodes.contains(1));
        Assertions.assertTrue(visitedNodes.contains(2));
        Assertions.assertTrue(visitedNodes.contains(3));
        Assertions.assertTrue(visitedNodes.contains(4));
        Assertions.assertTrue(visitedNodes.contains(5));
        Assertions.assertTrue(visitedNodes.contains(6));
        Assertions.assertTrue(visitedNodes.contains(7));
    }

    private void collectVisitedNodes(Node node, Set<Integer> visitedNodes) {
        visitedNodes.add(node.getData());
        if (node.getChildren() != null) {
            for (Node child : node.getChildren()) {
                collectVisitedNodes(child, visitedNodes);
            }
        }
    }

    private Node buildGraph() {
        Node leaf1 = new Node(4);
        Node leaf2 = new Node(5);
        Node leaf3 = new Node(6);
        Node leaf4 = new Node(7);

        Node branch1 = new Node(2, leaf1, leaf2);
        Node branch2 = new Node(3, leaf3, leaf4);

        return new Node(1, branch1, branch2);
    }
}

