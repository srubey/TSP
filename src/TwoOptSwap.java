import java.util.*;

public class TwoOptSwap {
    protected List<Vertex> twoOptSwp(List<Vertex> oldRoute, long priorBest){
        long bestDist = priorBest;
        long newDist;
        List<Vertex> newRoute;
        List<Vertex> curRoute = oldRoute;

        for(int i = 1; i < oldRoute.size()-2; ++i){
            for(int j = i+1; j < oldRoute.size()-1; ++j){
                newRoute = twoOptSwpHlp(curRoute, i, j);
                newDist = calcTotal(newRoute);

                if(newDist < bestDist){
                    bestDist = newDist;
                    curRoute = newRoute;
                }
            }
        }
        return curRoute;
    }

    protected List<Vertex> twoOptSwpHlp(List<Vertex> oldRoute, int i, int j){
        List<Vertex> route = new ArrayList<Vertex>();
        int temp = j;

        for(int k = 0; k < i; ++k) {
            route.add(oldRoute.get(k));
        }

        for(int l = i; l <= j; ++l){
            route.add(oldRoute.get(temp));
            --temp;
        }

        for(int m = j+1; m < oldRoute.size(); ++m) {
            route.add(oldRoute.get(m));
        }

        return route;
    }

    protected long calcTotal(List<Vertex> newRoute){
        long total = 0;

        for(int i = 1; i < newRoute.size(); ++i) {
            for (Edge e : newRoute.get(i).edges){
                if(e.to == newRoute.get(i-1))
                    total += e.weight;
            }
        }

        return total;
    }
}
