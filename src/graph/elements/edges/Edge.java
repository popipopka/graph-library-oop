package graph.elements.edges;

import graph.elements.nodes.Node;

public interface Edge<T> {
    Node<T> getFrom();
    Node<T> getTo();
}
