package graph.algorithms;

import graph.Graph;
import graph.elements.edges.Edge;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFSAlgorithm<V, E extends Edge<V>, G extends Graph<V, E>> extends FirstSearchAlgorithm<V, E, G> {
    public BFSAlgorithm(G initial, G result, V source) {
        super(initial, result, source);
    }

    @Override
    public void run() {
        Set<V> visited = new HashSet<>();
        Queue<V> nodesQueue = new ArrayDeque<>();

        nodesQueue.add(super.source);

        V cur;

        while(!nodesQueue.isEmpty()) {
            cur = nodesQueue.poll();
            visited.add(cur);

            for (V n : getAdjacentNodes(cur)) {
                if(!visited.contains(n)) {
                    nodesQueue.add(n);
                    visited.add(n);

                    addInPath(cur, n, 0);
                }
            }
        }
    }
}
