package graph;

public class Edge implements IEdge {
    private Vertex v1, v2;

    public Vertex getV1() {
        return v1;
    }

    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    @Override
    public void setFrom(int from) {
    }

    @Override
    public void setCost(int cost) {
    }
}
