package search;

import graph.IGraph;

public class BFSSearch extends SearchDecorator {
    public BFSSearch(IGraph IGraph) {
        super(IGraph);
    }

    @Override
    public void searchGraph() {
        IGraph.searchGraph();
        System.out.println("Searching using BFS.");
    }
}
