import java.util.Iterator;
import java.util.*;

public class NearNbr {
//    protected List<Vertex> result;
//    protected long total;
    protected Route route;

    protected NearNbr(){
//        result = new ArrayList<Vertex>();
//        total = 0;
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
//            route.totalDist += wt;

            ++count;
        }

        //return to the start and add weight
        Vertex temp = current;
        current = start;
        route.vertices.add(current);
        for(Edge e:current.edges){
            if(e.to == temp) {
                route.edges.add(e);
//                route.totalDist += e.weight;
            }
        }

        return route;
    }
}