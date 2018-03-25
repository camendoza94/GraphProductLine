package graph;

import search.BFSSearch;
import search.DFSSearch;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Graph implements IGraph {
    private static final int WEIGHTED_DIRECTED = 1;
    private static final int WEIGHTED_UNDIRECTED = 2;
    private static final int UNWEIGHTED_DIRECTED = 3;
    private static final int UNWEIGHTED_UNDIRECTED = 4;
    private ArrayList<Vertex> vertices;
    private ArrayList<IEdge> edges;
    private static final String DFS = "dfs";
    private static final String BFS = "bfs";

    public Graph() {
        super();
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    @Override
    public void searchGraph() {
        // do nothing
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public ArrayList<IEdge> getEdges() {
        return edges;
    }

    public void addEdge(IEdge edge) {
        edges.add(edge);
    }

    public static void main(String[] args) {
        System.out.println("Input the number of vertices");
        final Scanner sis = new Scanner(System.in);
        int number;
        Properties prop = new Properties();
        InputStream file = null;
        IGraph graph;
        boolean directed = false;
        boolean weighted = false;
        try {
            file = new FileInputStream("data/graph.properties");
            // load a properties file
            prop.load(file);

            // get the property value and print it out
            String search = prop.getProperty("search");
            directed = Boolean.parseBoolean(prop.getProperty("directed"));
            weighted = Boolean.parseBoolean(prop.getProperty("weighted"));
            switch (search) {
                case DFS:
                    graph = new DFSSearch(new Graph());
                    break;
                case BFS:
                    graph = new BFSSearch(new Graph());
                    break;
                default:
                    graph = new Graph();
                    break;
            }
        } catch (IOException ex) {
            graph = new Graph();
            ex.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sis.hasNext()) {
            if (sis.hasNextInt()) {
                number = sis.nextInt();
                for (int i = 1; i <= number; i++) {
                    graph.addVertex(new Vertex(i));
                }
                System.out.println("There are " + number + " vertices");
            } else
                System.out.println("Input the number of vertices");
        }
        System.out.println("Input the edges as <vertexFrom> <vertexTo> <cost>.\nWhen finished type quit");
        sis.nextLine();
        // add edges
        AbstractFactoryGraph edgeFactory = FactoryProducer.getFactory("EDGE");
        while (sis.hasNext()) {
            String input = sis.nextLine();
            if (input.equals("quit"))
                break;
            int label1 = Integer.parseInt(input.split(" ")[0]) - 1;
            int label2 = Integer.parseInt(input.split(" ")[1]) - 1;
            int cost = Integer.parseInt(input.split(" ")[2]) - 1;
            IEdge edge;
            if (weighted) {
                if (directed) {
                    edge = edgeFactory != null ? edgeFactory.getEdge(WEIGHTED_DIRECTED) : null;
                } else
                    edge = edgeFactory != null ? edgeFactory.getEdge(WEIGHTED_UNDIRECTED) : null;
            } else {
                if (directed) {
                    edge = edgeFactory != null ? edgeFactory.getEdge(UNWEIGHTED_DIRECTED) : null;
                } else
                    edge = edgeFactory != null ? edgeFactory.getEdge(UNWEIGHTED_UNDIRECTED) : null;
            }
            if (edge != null) {
                edge.setV1(graph.getVertices().get(label1));
                edge.setV2(graph.getVertices().get(label2));
                edge.setFrom(label1);
                edge.setCost(cost);
            }
            graph.addEdge(edge);
        }

        System.out.println(graph.getVertices());
        System.out.println(graph.getEdges());
        graph.searchGraph();
    }
}
