package graph;

import graph.elements.nodes.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class NodesPath<V> {
    private final List<Node<V>> nodes = new LinkedList<>();
    private float length = 0;

    public float length() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void add(Node<V> node) {
        nodes.add(node);
    }

    public void remove(Node<V> node) {
        nodes.remove(node);
    }

    public void clear() {
        this.nodes.clear();
        this.length = 0;
    }

    public int size() {
        return nodes.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public List<Node<V>> getNodes() {
        return nodes;
    }

    public boolean contains(Node<V> node) {
        return nodes.contains(node);
    }

    public void increaseLength(float value) {
        this.length += value;
    }

    public void decreaseLength(float value) {
        this.length -= value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{").append("\n\t");

        builder.append("path: ");
        for (int i = 0; i < nodes.size(); i++) {
            builder.append(nodes.get(i).toString());

            if (i != nodes.size() - 1) builder.append(" --> ");
        }

        builder.append("\n\t").append("length = ").append(length);

        builder.append("\n").append("}");

        return builder.toString();
    }
}
