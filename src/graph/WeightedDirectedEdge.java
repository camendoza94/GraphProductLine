package graph;

public class WeightedDirectedEdge extends WeightedEdge {
    private int from; // indicates if first or second vertex is first

    public void setFrom(int from) {
        this.from = from;
    }
}
