public class TwoOptSwap {
    protected Route twoOptSwp(Route oldRoute){
        long bestDist = oldRoute.calcDist();
        long newDist;
        Route newRoute;
        Route curRoute = oldRoute;

        for(int i = 1; i < oldRoute.vertices.size()-2; ++i){
            for(int j = i+1; j < oldRoute.vertices.size()-1; ++j){
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

    protected Route twoOptSwpHlp(Route oldRoute, int i, int j){
        Route newRoute = new Route();
        int temp = j;

        //create new vertex list
        for(int k = 0; k < i; ++k)
            newRoute.vertices.add(oldRoute.vertices.get(k));

        for(int l = i; l <= j; ++l){
            newRoute.vertices.add(oldRoute.vertices.get(temp));
            --temp;
        }

        for(int m = j+1; m < oldRoute.vertices.size(); ++m)
            newRoute.vertices.add(oldRoute.vertices.get(m));

        //create new edgelist
        for(int n = 1; n < newRoute.vertices.size(); ++n){
            for(Edge e:newRoute.vertices.get(n).edges) {
                if(e.to == newRoute.vertices.get(n - 1))
                    newRoute.edges.add(e);
            }
        }

        return newRoute;
    }

    protected long calcTotal(Route route){
        return route.calcDist();
    }
}
