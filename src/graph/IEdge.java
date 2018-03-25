package graph;

public interface IEdge {
    Vertex getV1();

    void setV1(Vertex v1);

    Vertex getV2();

    void setV2(Vertex v2);

    void setFrom(int from);

    void setCost(int cost);
}
