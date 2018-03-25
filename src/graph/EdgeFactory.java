package graph;

public class EdgeFactory extends AbstractFactoryGraph {

    @Override
    public IEdge getEdge(int edgeType) {
        if (edgeType == 1) {
            return new WeightedDirectedEdge();
        } else if (edgeType == 4) {
            return new Edge();
        } else if (edgeType == 3) {
            return new DirectedEdge();
        } else if (edgeType == 2) {
            return new WeightedEdge();
        }
        return null;
    }
}
