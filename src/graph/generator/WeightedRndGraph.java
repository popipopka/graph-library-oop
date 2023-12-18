package graph.generator;

import graph.WeightedGraph;
import graph.elements.edges.WeightedEdge;

public class WeightedRndGraph<E extends WeightedEdge<Integer>, G extends WeightedGraph<Integer, E>>
        extends AbstractRndGraph<E, G> {
    private int minWeight = 0;
    private int maxWeight = 10;

    public WeightedRndGraph(G graph, int nodeLimit, int minWeight, int maxWeight) {
        super(graph, nodeLimit);
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public WeightedRndGraph(G graph, int nodeLimit) {
        super(graph, nodeLimit);
    }

    @Override
    protected boolean generateEdge(int from, int to) {
        if (!graph.addEdge(from, to)) return false;

        int weight = rnd.nextInt(minWeight, maxWeight);

        graph.setEdgeWeight(from, to, weight);
        return true;
    }
}
