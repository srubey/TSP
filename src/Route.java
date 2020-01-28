import java.util.*;

public class Route {
    List<Vertex> vertices;
    List<Edge> edges;

    protected Route(){
        vertices = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
    }

    protected long calcDist(){
        long totalDist = 0;

        for(Edge e:edges)
            totalDist += e.weight;

        return totalDist;
    }
}
