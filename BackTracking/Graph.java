import java.util.LinkedList;

public class Graph{
    int vertexcount;
    LinkedList[] adjlist;
    public Graph(int v){
        this.vertexcount = v;
        adjlist = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjlist[i] = new LinkedList<Integer>();
        }
    }
    public void addEdge(int s, int d){
        adjlist[s].add(d);
    }
}