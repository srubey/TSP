public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        NearNbr tsp1 = new NearNbr();
        TwoOptSwap tsp2 = new TwoOptSwap();

        //create graph
        graph.loadVerts();  //load vertices from external data file
        graph.createEdges();  //create edges from those vertices
        graph.printAdjList();  //newly created adjacency list

        //create route using Nearest Neighbor
        Route r1 = tsp1.nrstNbr(graph.getVertices());
        System.out.print("\nRoute using Nearest Neighbor:");
        r1.printRoute();
        System.out.print("\nTotal Weight: " + r1.calcDist() + "\n");

        //optimize using 2-Opt-Swaps
        Route r2 = tsp2.twoOptSwp(r1);
        System.out.print("\nRoute using Two Opt Swap:");
        r2.printRoute();
        System.out.print("\nTotal Weight: " + r2.calcDist() + "\n");

        System.out.print("Size: " + r2.edges.size() + " \n");
        for(int i = 0; i < r2.edges.size(); ++i)
            System.out.print(r2.edges.get(i).to.name + " ");
    }
}