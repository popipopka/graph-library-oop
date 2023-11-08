package graph.algorithms;

import graph.Graph;
import graph.NodesPath;
import graph.WeightedGraph;
import graph.elements.edges.Edge;
import graph.elements.nodes.Node;
import graph.util.GraphUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static graph.algorithms.ExceptionMessageConstants.*;

public abstract class AbstractAlgorithm<V, E extends Edge<V>, G extends Graph<V, E>> implements Algorithm<V, E, G> {
    protected final G initial;
    protected final G result;
    protected final Map<V, NodesPath<V>> paths = new HashMap<>();
    protected V source;

    protected AbstractAlgorithm(G initial, G result, V source) {
        this.initial = initial;
        this.source = source;
        this.result = result;
        checkFields();
        GraphUtils.lazyCopyOfNodes(this.initial, this.result);
        fillPaths();
    }

    @Override
    public void checkFields() {
        if (this.initial == null) {
            throw new NullPointerException(INITIAL_GRAPH_IS_NULL);
        }
        if (this.result == null) {
            throw new NullPointerException(RESULT_GRAPH_IS_NULL);
        }
        if (!this.initial.containsNode(source)) {
            throw new IllegalArgumentException(GRAPH_NOT_CONTAIN_THE_SOURCE_NODE);
        }
    }

    public NodesPath<V> getPathTo(V target) {
        if (!result.containsNode(target)) {
            throw new NullPointerException(GRAPH_NOT_CONTAIN_THE_TARGET_NODE);
        }

        return paths.get(target);
    }

    private void fillPaths() {
        NodesPath<V> path;
        for (Node<V> n : this.initial.getNodes()) {
            path = new NodesPath<>();
            path.add(n);

            this.paths.put(n.getName(), path);
        }
    }

    protected void addInPath(V source, V target, float length) {
        NodesPath<V> pSource = this.paths.get(source);
        NodesPath<V> pTarget = this.paths.get(target);
        pTarget.clear();

        pSource.getNodes().forEach(pTarget::add);
        pTarget.add(this.initial.getNode(target));
        pTarget.setLength(length);

        this.paths.put(target, pTarget);
    }

    protected void createEdges() {
        List<Node<V>> nodes;

        V from;
        V to;
        for (NodesPath<V> p : this.paths.values()) {
            nodes = p.getNodes();

            for (int i = 0; i < nodes.size() - 1; i++) {
                from = nodes.get(i).getName();
                to = nodes.get(i + 1).getName();

                if (!this.result.containsEdge(from, to)) {
                    this.result.addEdge(from, to);

                    moveEdgeWeightInitialToResult(from, to);
                }
            }
        }
    }

    private void moveEdgeWeightInitialToResult(V from, V to) {
        if (initial instanceof WeightedGraph) {
            ((WeightedGraph<V, E>) this.result)
                    .setEdgeWeight(
                            from,
                            to,
                            ((WeightedGraph<V, E>) this.initial).getEdgeWeight(from, to));
        }
    }

    @Override
    public G result() {
        createEdges();
        return result;
    }
}
