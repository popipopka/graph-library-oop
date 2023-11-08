package graph.algorithms;

import graph.NodesPath;
import graph.WeightedGraph;
import graph.elements.edges.WeightedEdge;
import graph.types.GraphTypes;

import java.util.*;
import java.util.Map.Entry;

import static graph.algorithms.ExceptionMessageConstants.GRAPH_CONTAIN_A_NEGATIVE_WEIGHTED_EDGE;

public final class DijkstraAlgorithm<V, E extends WeightedEdge<V>, G extends WeightedGraph<V, E>>
        extends AbstractAlgorithm<V, E, G> {

    public DijkstraAlgorithm(G initial, G result, V source) {
        super(initial, result, source);
        if (GraphTypes.isPositiveWeightedGraph(initial)) {
            throw new IllegalArgumentException(GRAPH_CONTAIN_A_NEGATIVE_WEIGHTED_EDGE);
        }
    }

    @Override
    public void run() {
        Set<V> visited = new HashSet<>();
        Queue<V> unsettledNodes = new PriorityQueue<>(Comparator.comparingDouble(e -> paths.get(e).length()));

        setStartDistance();

        V nCur;
        Set<E> nCurEdges;

        V nAdj;
        float nAdjPathLength;

        unsettledNodes.add(super.source);
        while (!unsettledNodes.isEmpty()) {
            nCur = unsettledNodes.poll();

            if (visited.contains(nCur)) continue;
            visited.add(nCur);

            nCurEdges = super.initial.getEdgesOf(nCur);
            for (E e : nCurEdges) {
                nAdj = e.getTo().getName();

                nAdjPathLength = super.paths.get(nCur).length() + e.getWeight();

                if (nAdjPathLength < super.paths.get(nAdj).length()) {
                    addInPath(nCur, nAdj, nAdjPathLength);

                    unsettledNodes.add(nAdj);
                }
            }
        }
    }

    private void setStartDistance() {
        for (Entry<V, NodesPath<V>> e : super.paths.entrySet()) {
            if (!e.getKey().equals(super.source)) {
                e.getValue().setLength(Float.MAX_VALUE);
            }
        }
    }
}
