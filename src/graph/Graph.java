package graph;

import graph.elements.nodes.Node;

import java.util.Set;

public interface Graph<V,E> {
    boolean addNode(V name);

    Node<V> deleteNode(V name);

    Set<Node<V>> deleteAllNode();

    Node<V> getNode(V name);

    Set<Node<V>> getNodes();

    boolean containsNode(V name);

    boolean addEdge(V from, V to);

    void deleteEdge(V from, V to);

    E getEdge(V from, V to);

    Set<E> getEdgesOf(V nodeName);

    Set<E> getEdges();

    void deleteEdgesOf(V nodeName);

    void deleteAllEdges();

    boolean containsEdge(V from, V to);

    int size();

    int order();
}
