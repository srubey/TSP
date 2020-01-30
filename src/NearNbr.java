import java.util.Iterator;
import java.util.*;

public class NearNbr {
    protected Route route;

    protected NearNbr(){
        route = new Route();
    }

    protected Route nrstNbr(List<Vertex> vertices){
        Iterator<Vertex> itr = vertices.iterator();
        Vertex start = itr.next();  //pick a starting element
        Vertex current = start;
        Vertex toVisit;  //vertex to visit
        Edge shortEdge;
        long wt;  //weight to compare
        int count = 1;

        current.visited = true;
        route.vertices.add(current);

        while(count < vertices.size()){
            wt = 1000000;
            toVisit = null;
            shortEdge = null;

            for(Edge e:current.edges) {
                //search unvisited edges for lowest weight
                if (e.to.visited == false && e.weight < wt) {
                    toVisit = e.to;
                    wt = e.weight;
                    shortEdge = e;
                }
            }

            current = toVisit;
            current.visited = true;
            route.vertices.add(current);
            route.edges.add(shortEdge);

            ++count;
        }

        //return to the start and add weight
        route.vertices.add(start);
        for(Edge e:current.edges){
            if(e.to == start)
                route.edges.add(e);
        }

        return route;
    }
}