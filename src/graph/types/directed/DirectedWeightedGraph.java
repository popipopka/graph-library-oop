package graph.types.directed;

import graph.WeightedGraph;
import graph.elements.edges.WeightedEdge;

public class DirectedWeightedGraph<V, E extends WeightedEdge<V>>
        extends DirectedGraph<V, E> implements WeightedGraph<V, E> {

    public DirectedWeightedGraph(Class<? extends WeightedEdge> edgeType) {
        super(edgeType);
    }

    @Override
    public void setEdgeWeight(V from, V to, float weight) {
        E edge = getEdge(from, to);

        if(edge == null) return;

        edge.setWeight(weight);
    }

    @Override
    public float getEdgeWeight(V from, V to) {
        E edge = getEdge(from, to);
        if(edge == null) return 0;

        return edge.getWeight();
    }
}
