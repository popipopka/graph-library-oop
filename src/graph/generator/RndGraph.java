package graph.generator;

import graph.Graph;
import graph.elements.edges.DefaultEdge;

public class RndGraph<E extends DefaultEdge<Integer>, G extends Graph<Integer, E>>
        extends AbstractRndGraph<E, G> {
    public RndGraph(G graph, int nodeLimit) {
        super(graph, nodeLimit);
    }

    @Override
    protected boolean generateEdge(int from, int to) {
        return graph.addEdge(from, to);
    }
}
