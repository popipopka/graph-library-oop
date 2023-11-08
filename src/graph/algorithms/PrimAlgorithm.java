package graph.algorithms;

import graph.NodesPath;
import graph.WeightedGraph;
import graph.elements.edges.WeightedEdge;
import graph.elements.nodes.Node;

import java.util.*;

public class PrimAlgorithm<V, E extends WeightedEdge<V>, G extends WeightedGraph<V, E>>
        extends AbstractAlgorithm<V, E, G> {

    public PrimAlgorithm(G initial, G result, V source) {
        super(initial, result, source);
    }

    @Override
    public void run() {
        Set<V> visited = new HashSet<>();
        Queue<E> priorityEdges = new PriorityQueue<>(Comparator.comparingDouble(E::getWeight));

        setStartPaths();
        visited.add(super.source);
        priorityEdges.addAll(super.initial.getEdgesOf(super.source));

        E eCur;

        V nCur;
        V nAdj;

        while (!priorityEdges.isEmpty()) {
            eCur = priorityEdges.poll();
            nCur = eCur.getTo().getName();

            if (visited.contains(nCur)) continue;
            visited.add(nCur);

            nAdj = eCur.getFrom().getName();
            addInPath(nAdj, nCur, eCur.getWeight());

            for (E e : super.initial.getEdgesOf(nCur)) {
                nAdj = e.getTo().getName();

                if (!visited.contains(nAdj)) {
                    priorityEdges.add(e);
                }
            }
        }

    }

    private void setStartPaths() {
        NodesPath<V> path;
        for (Node<V> n : super.initial.getNodes()) {
            path = new NodesPath<>();
            path.add(n);

            super.paths.put(n.getName(), path);
        }
    }
}
