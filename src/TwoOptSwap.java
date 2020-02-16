import java.util.Random;
import java.util.Collections;

public class TwoOptSwap {
    protected long startTime;
    protected long endTime;

    protected Route twoOptSwp(Route oldRoute){
        long bestDist = oldRoute.calcDist();
        long newDist;
        Route newRoute;
        Route curRoute = oldRoute;

        startTime = System.currentTimeMillis();

        for(int i = 1; i < oldRoute.vertices.size()-2; ++i){
//            long startTest = System.currentTimeMillis();  //for debugging purposes
            for(int j = i+1; j < oldRoute.vertices.size()-1; ++j){
                newRoute = twoOptSwpHlp(curRoute, i, j);
                newDist = calcTotal(newRoute);

                if(newDist < bestDist){
                    bestDist = newDist;
                    curRoute = newRoute;
                }
            }

            //this test shows that the bulk of the completion time is taken in each
            //iteration of this for-loop, not in the creation of the new edgelist,
            //which was originally a concern
/*            long endTest = System.currentTimeMillis();
            float oneIterTime = (endTest - startTest)/1000f;
            String test = String.format("%.8f", oneIterTime);
            System.out.print("Single Iteration: " + test + "\n");  */
        }

        endTime = System.currentTimeMillis();

        return curRoute;
    }

    protected Route twoOptSwpHlp(Route oldRoute, int i, int j){
        Route newRoute = new Route();
        Random random = new Random();
        int temp = j;

        //create new vertex list
        for (int k = 0; k < i; ++k)
            newRoute.vertices.add(oldRoute.vertices.get(k));

        for (int l = i; l <= j; ++l) {
            newRoute.vertices.add(oldRoute.vertices.get(temp));
            --temp;
        }

        for (int m = j + 1; m < oldRoute.vertices.size(); ++m) {
            newRoute.vertices.add(oldRoute.vertices.get(m));
        }

        //for debugging purposes -- time to create edgelist is trivial (< 1 ms)
//      long startTest = System.currentTimeMillis();

        //create new edgelist
        for (int n = 0; n < newRoute.vertices.size(); ++n) {
            for (Edge e : newRoute.vertices.get(n).edges) {
                if (n != newRoute.vertices.size() - 1 && e.to == newRoute.vertices.get(n + 1))
                    newRoute.edges.add(e);
            }
        }

/*        long endTest = System.currentTimeMillis();
        float edgeTest = (endTest - startTest)/1000f;
        String time = String.format("%.8f", edgeTest);
        System.out.print("\nEdgelist Time: " + time + "\n");  */

        return newRoute;
    }

    protected long calcTotal(Route route){
        return route.calcDist();
    }

    protected float getTime(){
        return (endTime - startTime)/1000f;
    }
}
