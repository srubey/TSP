import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        NearNbr tsp1 = new NearNbr();
        TwoOptSwap tsp2 = new TwoOptSwap();

        graph.loadVerts();
        graph.createEdges();
        graph.printAdjList();

        List<Vertex> route = tsp1.nrstNbr(graph.getVertices());
        System.out.print("\nRoute using Nearest Neighbor:");
        printRoute(route);
        System.out.print("\nTotal Weight: " + tsp1.total + "\n");

        List<Vertex> newRt = tsp2.twoOptSwp(route, tsp1.total);
        System.out.print("\nRoute using Two Opt Swap:");
        printRoute(newRt);
        System.out.print("\nTotal Weight: " + tsp2.calcTotal(newRt));
    }

    protected static void printRoute(List<Vertex> route){
        Vertex start = route.get(0);  
        System.out.print("\n" + start.name + " --> ");

        for (int i = 1; i < route.size(); ++i) {
            System.out.print(route.get(i).name);
            if(route.get(i) != start)
                System.out.print(" --> ");
        }
    }
}