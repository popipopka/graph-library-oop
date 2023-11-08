package graph.elements.edges;

public interface WeightedEdge<T> extends Edge<T> {
    void setWeight(float weight);
    float getWeight();
}
