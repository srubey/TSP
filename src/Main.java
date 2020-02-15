public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        RandWalk tsp1 = new RandWalk();
        NearNbr tsp2 = new NearNbr();
        TwoOptSwap tsp3 = new TwoOptSwap();

        //create graph
        graph.loadVerts();  //load vertices from external data file
        graph.createEdges();  //create edges from those vertices
        graph.printAdjList();  //newly created adjacency list

        //create route using Random Walk
        Route r1 = tsp1.randWalkWrapper(graph.getVertices());
        System.out.print("\nRoute using Random Walk:");
        r1.printRoute();
        System.out.print("\nTotal Weight: " + r1.calcDist() + "\n");

        //create route using Nearest Neighbor
        Route r2 = tsp2.nrstNbr(graph.getVertices());
        System.out.print("\nRoute using Nearest Neighbor:");
        r2.printRoute();
        System.out.print("\nTotal Weight: " + r2.calcDist() + "\n");
        String nnTime = String.format("%.3f", tsp2.getTime());
        System.out.print("Total Time: " + nnTime + " sec\n");

        //optimize using 2-Opt-Swaps
        Route r3 = tsp3.twoOptSwp(r2);
        System.out.print("\nRoute using Two Opt Swap:");
        r3.printRoute();
        System.out.print("\nTotal Weight: " + r3.calcDist() + "\n");
        String tosTime = String.format("%.3f", tsp3.getTime());
        System.out.print("Total Time: " + tosTime + " sec\n");
    }
}