package graph.algorithms;

import graph.Graph;
import graph.elements.edges.Edge;

import java.util.HashSet;
import java.util.Set;

public abstract class FirstSearchAlgorithm<V, E extends Edge<V>, G extends Graph<V, E>> extends AbstractAlgorithm<V, E, G> {
    protected FirstSearchAlgorithm(G initial, G result, V source) {
        super(initial, result, source);
    }

    protected Set<V> getAdjacentNodes(V name) {
        Set<V> adjNodes = new HashSet<>();
        Set<E> nEdges = super.initial.getEdgesOf(name);

        for (E e : nEdges) adjNodes.add(e.getTo().getName());

        return adjNodes;
    }
}
