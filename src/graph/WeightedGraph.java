package graph;

public interface WeightedGraph<V, E> extends Graph<V, E> {
    default void addEdge(V from, V to, float weight) {
        addEdge(from, to);
        setEdgeWeight(from, to, weight);
    }

    void setEdgeWeight(V from, V to, float weight);
    float getEdgeWeight(V from, V to);
}
