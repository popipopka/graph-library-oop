package graph.util;

import graph.elements.edges.DefaultEdge;
import graph.elements.edges.DefaultWeightedEdge;
import graph.generator.RndGraph;
import graph.generator.WeightedRndGraph;
import graph.types.directed.DirectedGraph;
import graph.types.directed.DirectedWeightedGraph;
import graph.types.undirected.UndirectedGraph;
import graph.types.undirected.UndirectedWeightedGraph;

public class RndGraphCreator {
    public static DirectedGraph<Integer, DefaultEdge<Integer>> directed(int nodeLimit) {
        DirectedGraph<Integer, DefaultEdge<Integer>> g = new DirectedGraph<>(DefaultEdge.class);
        return new RndGraph<>(g, nodeLimit).create();
    }

    public static UndirectedGraph<Integer, DefaultEdge<Integer>> undirected(int nodeLimit) {
        UndirectedGraph<Integer, DefaultEdge<Integer>> g = new UndirectedGraph<>(DefaultEdge.class);
        return new RndGraph<>(g, nodeLimit).create();
    }

    public static DirectedWeightedGraph<Integer, DefaultWeightedEdge<Integer>> directedWeighted(int nodeLimit, int minWeight, int maxWeight) {
        DirectedWeightedGraph<Integer, DefaultWeightedEdge<Integer>> g = new DirectedWeightedGraph<>(DefaultWeightedEdge.class);
        return new WeightedRndGraph<>(g, nodeLimit).create();
    }

    public static UndirectedWeightedGraph<Integer, DefaultWeightedEdge<Integer>> undirectedWeighted(int nodeLimit, int minWeight, int maxWeight) {
        UndirectedWeightedGraph<Integer, DefaultWeightedEdge<Integer>> g = new UndirectedWeightedGraph<>(DefaultWeightedEdge.class);
        return new WeightedRndGraph<>(g, nodeLimit).create();
    }
}
