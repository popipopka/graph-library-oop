package graph.algorithms;

import graph.VerifiableFields;
import graph.WeightedGraph;

public interface Algorithm<V, E, G> extends Runnable, VerifiableFields {
    G result();
}
