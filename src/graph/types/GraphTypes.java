package graph.types;

import graph.WeightedGraph;
import graph.elements.edges.WeightedEdge;

import java.util.Set;

public class GraphTypes {
    private GraphTypes() {
        throw new IllegalStateException("utility class");
    }

    public static <V, E extends WeightedEdge<V>> boolean isPositiveWeightedGraph(WeightedGraph<V, E> graph) {
        Set<E> allEdges = graph.getEdges();

        for(E e: allEdges) {
            if (e.getWeight() < 0) {
                return true;
            }
        }
        return false;
    }
}
