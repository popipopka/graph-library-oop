package graph.algorithms;

public final class ExceptionMessageConstants {
    private ExceptionMessageConstants() {
        throw new IllegalStateException("Constants class");
    }

    public static final String INITIAL_GRAPH_IS_NULL = "Initial graph is null";
    public static final String RESULT_GRAPH_IS_NULL = "Initial graph is null";

    public static final String GRAPH_CONTAIN_A_NEGATIVE_WEIGHTED_EDGE = "Graph contain the a negative weighted edge";
    public static final String GRAPH_NOT_CONTAIN_THE_SOURCE_NODE = "Graph not contain the source node";
    public static final String GRAPH_NOT_CONTAIN_THE_TARGET_NODE = "Graph not contain the source node";
}
