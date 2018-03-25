package graph;

public class WeightedEdge implements IEdge {
    private Vertex v1, v2;
    private int cost;

    @Override
    public Vertex getV1() {
        return v1;
    }

    @Override
    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    @Override
    public Vertex getV2() {
        return v2;
    }

    @Override
    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    @Override
    public void setFrom(int from) {
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
