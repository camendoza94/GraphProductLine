package search;

import graph.IGraph;

public class DFSSearch extends SearchDecorator {
    public DFSSearch(IGraph IGraph) {
        super(IGraph);
    }

    @Override
    public void searchGraph() {
        IGraph.searchGraph();
        System.out.println("Searching using DFS.");
    }
}
