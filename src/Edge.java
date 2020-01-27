public class Edge {
    protected Vertex to;
    protected long weight;

    protected Edge(Vertex copyTo, long copyWeight){
        this.to = copyTo;
        this.weight = copyWeight;
    }

    protected void print(){
        System.out.print("(" + to.name + ", " + weight + ")");
    }
}