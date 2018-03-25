package graph;

import java.util.ArrayList;

public interface IGraph {
    void searchGraph();

    ArrayList<Vertex> getVertices();

    void addVertex(Vertex vertex);

    ArrayList<IEdge> getEdges();

    void addEdge(IEdge edge);
}
