import java.util.Iterator;
import java.util.*;

public class NearNbr {
    protected List<Vertex> result;
    protected long total;

    protected NearNbr(){
        result = new ArrayList<Vertex>();
        total = 0;
    }

    protected List<Vertex> nrstNbr(List<Vertex> vertices){
        Iterator<Vertex> itr = vertices.iterator();
        Vertex start = itr.next();  //pick a starting element
        Vertex current = start;
        Vertex toVisit;  //vertex to visit
        long wt;  //weight to compare
        int count = 1;

        current.visited = true;
        result.add(current);

        while(count < vertices.size()){
            wt = 1000000;
            toVisit = null;

            for(Edge e:current.edges) {
                //search unvisited edges for lowest weight
                if (e.to.visited == false && e.weight < wt) {
                    toVisit = e.to;
                    wt = e.weight;
                }
            }

            current = toVisit;
            current.visited = true;
            result.add(current);
            total += wt;

            ++count;
        }

        //return to the start and add weight
        Vertex temp = current;
        current = start;
        result.add(current);
        for(Edge e:current.edges){
            if(e.to == temp)
                total += e.weight;
        }

        return result;
    }
}