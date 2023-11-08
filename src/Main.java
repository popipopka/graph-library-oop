import graph.elements.edges.DefaultEdge;
import graph.elements.edges.DefaultWeightedEdge;
import graph.types.directed.DirectedGraph;
import graph.types.directed.DirectedWeightedGraph;
import graph.types.undirected.UndirectedGraph;
import graph.types.undirected.UndirectedWeightedGraph;
import graph.util.RndGraphCreator;

public class Main {
    public static void main(String[] args) {
        UndirectedGraph<Integer, DefaultEdge<Integer>> ug = RndGraphCreator.undirected(7);

        DirectedGraph<String, DefaultEdge<String>> dg = new DirectedGraph<>(DefaultEdge.class);

        UndirectedWeightedGraph<Float, DefaultWeightedEdge<Float>> uwg = new UndirectedWeightedGraph<>(DefaultWeightedEdge.class);

        DirectedWeightedGraph<Integer, DefaultWeightedEdge<Integer>> dwg = RndGraphCreator.directedWeighted(5, -3, 4);
    }
}
