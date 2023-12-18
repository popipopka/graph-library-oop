package graph.types.directed;

import graph.AbstractGraph;
import graph.elements.edges.Edge;
import graph.elements.nodes.Node;

import java.util.HashSet;

public class DirectedGraph<V, E extends Edge<V>> extends AbstractGraph<V, E> {
    public DirectedGraph(Class<? extends Edge> edgeType) {
        super(edgeType);
    }

    @Override
    protected boolean addEdgeInternal(V from, V to) {
        E e = edgeCreator.createInstance(edgeType, this.nodes.get(from), this.nodes.get(to));

        if(!this.edges.containsKey(from)) {
            this.edges.put(from, new HashSet<>());
        }

        return this.edges.get(from).add(e);
    }

    @Override
    protected void deleteEdgeInternal(V from, V to) {
        edges.remove(getEdge(from, to));
    }
}
