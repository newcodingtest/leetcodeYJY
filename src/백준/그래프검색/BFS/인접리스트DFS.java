package 백준.그래프검색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class DfsGraph{
    private int V;
    private ArrayList<ArrayList<Integer>>dfsGraph;
    private boolean[] visitArr;

    public DfsGraph(int count){
        this.V = count;
        this.dfsGraph = new ArrayList<ArrayList<Integer>>();

        for (int i=0; i<this.V+1; i++){
            this.dfsGraph.add(new ArrayList<Integer>());
        }

        this.visitArr = new boolean[this.V+1];
    }
    public ArrayList<ArrayList<Integer>> getGraph(){
        return this.dfsGraph;
    }

    public ArrayList<Integer>getNode(int i){
        return this.dfsGraph.get(i);
    }

    public void put(int x, int y){
        this.dfsGraph.get(x).add(y);
        this.dfsGraph.get(y).add(x);
    }

    public void printGraphToAdjList(){
     for (int i=1; i<this.dfsGraph.size(); i++){
         System.out.println("정점"+i+"의 인접리스트");

         for (int j=0; j<this.dfsGraph.get(i).size(); j++){
             System.out.println(" -> "+this.dfsGraph.get(i).get(j));
         }
         System.out.println();
      }
    }

    public void clearVisitArr(){
        for (int i=0; i<this.visitArr.length; i++){
            this.visitArr[i] = false;
        }
    }

    public void dfs(int idx){
        this.visitArr[idx] = true;
        System.out.println(idx + " ");
        
        for (int i : this.dfsGraph.get(idx)){
            if(this.visitArr[i] == false){
                dfs(i);
            }
        }
    }

}


public class 인접리스트DFS {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = 0; // 정점
        int E = 0; // 간선
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        DfsGraph dfsGraph = new DfsGraph(V);

        dfsGraph.put(1,2);
        dfsGraph.put(1,3);
        dfsGraph.put(2,4);
        dfsGraph.put(2,5);
        dfsGraph.put(3,6);
        dfsGraph.put(3,7);
        dfsGraph.put(4,8);
        dfsGraph.put(5,8);
        dfsGraph.put(6,8);
        dfsGraph.put(7,8);

        dfsGraph.printGraphToAdjList();

        dfsGraph.dfs(1);
    }
}
