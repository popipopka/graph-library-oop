package graph.elements.edges;

import graph.elements.nodes.Node;

public class DefaultWeightedEdge<T>
        extends DefaultEdge<T> implements WeightedEdge<T> {

    private float weight;

    public DefaultWeightedEdge(Node<T> from, Node<T> to) {
        super(from, to);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
