package graph.algorithms;

import graph.NodesPath;
import graph.WeightedGraph;
import graph.elements.edges.WeightedEdge;
import graph.elements.nodes.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static graph.algorithms.ExceptionMessageConstants.*;

public class FloydWarshallAlgorithm<V, E extends WeightedEdge<V>, G extends WeightedGraph<V, E>>
        extends AbstractAlgorithm<V, E, G> {

    Map<V, Map<V, NodesPath<V>>> allPaths = new HashMap<>();

    public FloydWarshallAlgorithm(G initial, G result, V source) {
        super(initial, result, source);
    }

    @Override
    public void run() {
        setStartAllPaths();

        float oldLength;
        float newLength;

        V medium;
        V from;
        V to;

        Set<Node<V>> allNodes = super.initial.getNodes();
        for (Node<V> m : allNodes) {
            medium = m.getName();
            for (Node<V> f : allNodes) {
                from = f.getName();
                for (Node<V> t : allNodes) {
                    to = t.getName();

                    oldLength = this.allPaths.get(from).get(to).length();
                    newLength = this.allPaths.get(from).get(medium).length() + this.allPaths.get(medium).get(to).length();

                    if (newLength < oldLength) {
                        addInAllPaths(from, medium, to, newLength);
                    }
                }
            }
        }
    }

    public void setSource(V name) {
        if(!super.initial.containsNode(name)) {
            throw new IllegalArgumentException(GRAPH_NOT_CONTAIN_THE_SOURCE_NODE);
        }

        super.source = name;
    }

    @Override
    public G result() {
        super.paths.putAll(this.allPaths.get(super.source));
        result.deleteAllEdges();
        createEdges();

        return super.result();
    }

    private void addInAllPaths(V from, V medium, V to, float newLength) {
        super.paths.putAll(this.allPaths.get(from));
        addInPath(medium, to, newLength);
    }

    private void setStartAllPaths() {
        fillAllPaths();

        V from;
        V to;
        float newLength;

        for (E e : super.initial.getEdges()) {
            from = e.getFrom().getName();
            to = e.getTo().getName();
            newLength = e.getWeight();

            addInAllPaths(from, from, to, newLength);
        }
    }

    private void fillAllPaths() {
        V cur;
        Map<V, NodesPath<V>> curValue;

        V other;
        NodesPath<V> path;

        Set<Node<V>> allNodes = super.initial.getNodes();
        for (Node<V> node : allNodes) {
            cur = node.getName();
            curValue = new HashMap<>();
            this.allPaths.put(cur, curValue);

            for (Node<V> otherNode : allNodes) {
                other = otherNode.getName();
                path = new NodesPath<>();
                path.add(otherNode);

                if (!otherNode.equals(node)) {
                    path.setLength(Float.MAX_VALUE);
                }

                Objects.requireNonNull(curValue).put(other, path);
            }
        }
    }
}
