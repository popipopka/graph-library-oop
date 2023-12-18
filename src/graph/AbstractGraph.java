package graph;

import graph.elements.edges.Edge;
import graph.elements.nodes.Node;
import graph.util.ClassCreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractGraph<V, E extends Edge<V>> implements Graph<V, E> {
    protected Class<E> edgeType;
    protected ClassCreator<E> edgeCreator = new ClassCreator<>();

    protected final Map<V, Node<V>> nodes = new HashMap<>();
    protected Map<V, Set<E>> edges = new HashMap<>();

    protected AbstractGraph(Class<? extends Edge> edgeType) {
        this.edgeType = (Class<E>) edgeType;
    }

    @Override
    public boolean addNode(V name) {
        if (containsNode(name)) return false;

        Node<V> node = new Node<>(name);
        this.nodes.put(name, node);

        return true;
    }

    @Override
    public Node<V> deleteNode(V name) {
        Node<V> node = this.nodes.get(name);
        if (node == null) return null;

        this.nodes.remove(name);
        deleteEdgesOf(name);

        return node;
    }

    @Override
    public Set<Node<V>> deleteAllNode() {
        Set<Node<V>> copyNodes = getNodes();
        nodes.clear();
        return copyNodes;
    }

    @Override
    public Node<V> getNode(V name) {
        return nodes.get(name);
    }

    @Override
    public Set<Node<V>> getNodes() {
        return Set.copyOf(nodes.values());
    }

    @Override
    public boolean containsNode(V name) {
        return nodes.containsKey(name);
    }

    @Override
    public E getEdge(V from, V to) {
        Set<E> eFrom = getEdgesOf(from);

        if (eFrom.isEmpty()) return null;

        Node<V> nTo = nodes.get(to);
        for (E e : eFrom) {
            if (e.getTo().equals(nTo)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean addEdge(V from, V to) {
        if(this.containsEdge(from, to)) return false;

        return addEdgeInternal(from, to);
    }

    protected abstract boolean addEdgeInternal(V from, V to);

    @Override
    public void deleteEdge(V from, V to) {
        if (!edges.containsKey(from)) return;

        deleteEdgeInternal(from, to);
    }

    protected abstract void deleteEdgeInternal(V from, V to);

    @Override
    public Set<E> getEdgesOf(V nodeName) {
        Set<E> allEdges = this.edges.get(nodeName);

        if(allEdges == null) return new HashSet<>();

        return Set.copyOf(allEdges);
    }

    @Override
    public Set<E> getEdges() {
        Set<E> allEdges = new HashSet<>();

        for(V n : this.nodes.keySet()) {
            allEdges.addAll(getEdgesOf(n));
        }

        return allEdges;
    }

    @Override
    public void deleteEdgesOf(V nodeName) {
        if(!edges.containsKey(nodeName)) return;

        getEdgesOf(nodeName).clear();
    }

    @Override
    public void deleteAllEdges() {
        edges.clear();
    }

    @Override
    public boolean containsEdge(V from, V to) {
        if (!this.nodes.containsKey(from) || !this.nodes.containsKey(to)) {
            return false;
        }

        return getEdge(from, to) != null;
    }

    @Override
    public int size() {
        return edges.size();
    }

    @Override
    public int order() {
        return nodes.size();
    }
}
