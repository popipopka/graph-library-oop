package graph.util;

import graph.Graph;
import graph.elements.nodes.Node;

import java.util.Set;

public class GraphUtils {
    private GraphUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <V, E> void lazyCopyOfNodes(Graph<V, E> source, Graph<V, E> target) {
        Set<Node<V>> sourceNodes = source.getNodes();

        sourceNodes.forEach(e -> target.addNode(e.getName()));
    }
}
