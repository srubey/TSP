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

    protected void printRoute(){
        Vertex start = vertices.get(0);
        System.out.print("\n" + start.name + " --> ");

        for (int i = 1; i < vertices.size(); ++i) {
            System.out.print(vertices.get(i).name);
            if(vertices.get(i) != start)
                System.out.print(" --> ");
        }
    }
}
