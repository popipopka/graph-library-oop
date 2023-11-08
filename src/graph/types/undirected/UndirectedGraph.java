package graph.types.undirected;

import graph.AbstractGraph;
import graph.elements.edges.Edge;
import graph.elements.nodes.Node;

import java.util.HashSet;

public class UndirectedGraph<V, E extends Edge<V>> extends AbstractGraph<V, E> {

    public UndirectedGraph(Class<? extends Edge> edgeType) {
        super(edgeType);
    }

    @Override
    protected boolean addEdgeInternal(V from, V to) {
        E eFirst = edgeCreator.createInstance(edgeType, this.nodes.get(from), this.nodes.get(to));
        E eSecond = edgeCreator.createInstance(edgeType, this.nodes.get(to), this.nodes.get(from));

        this.edges.putIfAbsent(from, new HashSet<>());
        this.edges.putIfAbsent(to, new HashSet<>());

        this.edges.get(from).add(eFirst);
        return this.edges.get(to).add(eSecond);
    }

    @Override
    protected void deleteEdgeInternal(V from, V to) {
        E firstEdge = getEdge(from, to);
        E secondEdge = getEdge(to, from);

        edges.remove(firstEdge);
        edges.remove(secondEdge);
    }
}
