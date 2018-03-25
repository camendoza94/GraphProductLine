package search;

import graph.Graph;
import graph.IGraph;

public abstract class SearchDecorator extends Graph implements IGraph {
    IGraph IGraph;

    SearchDecorator(IGraph IGraph) {
        super();
        this.IGraph = IGraph;
    }

    public void searchGraph() {
        IGraph.searchGraph();
    }
}
