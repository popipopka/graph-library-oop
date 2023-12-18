package graph.algorithms;

import graph.Graph;
import graph.elements.edges.Edge;

import java.util.*;

public class DFSAlgorithm<V, E extends Edge<V>, G extends Graph<V, E>> extends FirstSearchAlgorithm<V, E, G> {
    public DFSAlgorithm(G initial, G result, V source) {
        super(initial, result, source);
    }

    @Override
    public void run() {
        Set<V> visited = new HashSet<>();
        Deque<V> nodesStack = new ArrayDeque<>();

        nodesStack.addLast(this.source);

        V cur;

        while(!nodesStack.isEmpty()) {
            cur = nodesStack.pollLast();

            if(visited.contains(cur)) continue;
            visited.add(cur);

            for (V n : getAdjacentNodes(cur)) {
                if(!visited.contains(n)) {
                    nodesStack.addLast(n);

                    addInPath(cur, n, 0);
                }
            }
        }
    }
}
