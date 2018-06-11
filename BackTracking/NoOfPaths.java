import java.util.*;

public class NoOfPaths {

    public static int pathsUtil(int s, int d, Graph g, boolean[] visited, int count){
        visited[s] = true;
        if(s==d){
            count++;
        }
        else{
            Iterator<Integer> iter = g.adjlist[s].iterator();
            while(iter.hasNext()){
                int neighbor = iter.next();
                if(!visited[neighbor]){
                    count = pathsUtil(neighbor,d,g,visited,count);
                }
            }
        }
        visited[s] = false;
        return count;
    }

    public static int paths(int s, int d, Graph g){
        boolean[] visited = new boolean[g.vertexcount];
        int count = 0;
        count = pathsUtil(s,d,g,visited,count);
        return count;
    }

    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        Scanner in = new Scanner(System.in);
        System.out.println("Source Vertex: ");
        int s = in.nextInt();
        System.out.println("Destination Vertex: ");
        int d = in.nextInt();
        System.out.print("No of paths between s and d are: "+paths(s,d,g));
        in.close();
    }
}
