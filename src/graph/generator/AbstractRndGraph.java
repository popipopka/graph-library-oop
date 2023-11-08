package graph.generator;

import graph.Graph;

import java.util.Random;

public abstract class AbstractRndGraph<E, G extends Graph<Integer, E>> {
    private final int MIN_NODES = 3;
    private final int MIN_EDGES = 3;
    private int nodes;
    private int edges;

    protected G graph;
    protected final Random rnd = new Random();

    protected AbstractRndGraph(G graph, int nodeLimit) {
        checkArguments(nodeLimit);

        this.graph = graph;
        this.nodes = rnd.nextInt(MIN_NODES, nodeLimit);
        this.edges = rnd.nextInt(MIN_EDGES, nodes * ((nodes - 1) / 2));
    }

    private void checkArguments(int nodeLimit) {
        if (nodeLimit <= MIN_NODES) {
            throw new IllegalArgumentException("Кол-во вершин должно быть больше " + MIN_NODES);
        }
    }

    private void generateNodes() {
        for (int i = 1; i <= nodes; i++) {
            graph.addNode(i);
        }
    }

    public G create() {
        generateNodes();

        int from;
        int to;

        for (int i = 1; i <= edges; i++) {
            from = rnd.nextInt(1, nodes);
            to = rnd.nextInt(1, nodes);

            if (from == to || !generateEdge(from, to)) i--;
        }

        return graph;
    }

    protected abstract boolean generateEdge(int from, int to);
}
