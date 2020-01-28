import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        NearNbr tsp1 = new NearNbr();
        TwoOptSwap tsp2 = new TwoOptSwap();

        graph.loadVerts();
        graph.createEdges();
        graph.printAdjList();

        Route r1 = tsp1.nrstNbr(graph.getVertices());
        System.out.print("\nRoute using Nearest Neighbor:");
        printRoute(r1);
        System.out.print("\nTotal Weight: " + r1.calcDist() + "\n");

        Route r2 = tsp2.twoOptSwp(r1);
        System.out.print("\nRoute using Two Opt Swap:");
        printRoute(r2);
        System.out.print("\nTotal Weight: " + r2.calcDist() + "\n");
    }

    protected static void printRoute(Route route){
        Vertex start = route.vertices.get(0);
        System.out.print("\n" + start.name + " --> ");

        for (int i = 1; i < route.vertices.size(); ++i) {
            System.out.print(route.vertices.get(i).name);
            if(route.vertices.get(i) != start)
                System.out.print(" --> ");
        }
    }
}