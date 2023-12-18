package graph.elements.edges;

import graph.elements.nodes.Node;

public class DefaultEdge<T> implements Edge<T> {
    private final Node<T> from;
    private final Node<T> to;

    public DefaultEdge(Node<T> from, Node<T> to) {
        checkNodes(from, to);
        this.from = from;
        this.to = to;
    }

    private void checkNodes(Node<T> from, Node<T> to) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("Ребро не может содержать две одинаковые вершины");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultEdge<?> edge = (DefaultEdge<?>) o;

        if (!from.equals(edge.from)) return false;
        return to.equals(edge.to);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }

    public Node<T> getFrom() {
        return from;
    }

    public Node<T> getTo() {
        return to;
    }
}
