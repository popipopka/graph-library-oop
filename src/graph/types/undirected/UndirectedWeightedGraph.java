package graph.types.undirected;

import graph.WeightedGraph;
import graph.elements.edges.WeightedEdge;

public class UndirectedWeightedGraph<V, E extends WeightedEdge<V>>
        extends UndirectedGraph<V, E> implements WeightedGraph<V, E> {

    public UndirectedWeightedGraph(Class<? extends WeightedEdge> edgeType) {
        super(edgeType);
    }

    @Override
    public void setEdgeWeight(V from, V to, float weight) {
        E firstEdge = getEdge(from, to);

        if (firstEdge == null) return;

        E secondEdge = getEdge(to, from);

        firstEdge.setWeight(weight);
        secondEdge.setWeight(weight);

    }

    @Override
    public float getEdgeWeight(V from, V to) {
        E edge = getEdge(from, to);
        if(edge == null) return 0;

        return edge.getWeight();
    }
}
