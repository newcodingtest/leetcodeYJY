package 백준.그래프검색.BFS;

import java.util.LinkedList;
import java.util.Stack;

public class Stack이용한DFS{
    static class Graph {
        int V;
        LinkedList<Integer> list[];

        public Graph(int count) {
            this.V = count;
            list = new LinkedList[count];
            for (int i = 0; i < V; i++) {
                list[i] = new LinkedList<>();
            }
        }

        public void addEdge(int x, int y) {
            list[x].addFirst(y);
            list[y].add(x);
        }

        public void DFS(int start) {
            System.out.println("");
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(start);
            while (!stack.isEmpty()) {
                int v = stack.pop();
                if (!visited[v]) {
                    System.out.print(v + " ");
                    visited[v] = true;
                    for (int i = 0; i < list[v].size(); i++) {
                        int dest = list[v].get(i);
                        if (!visited[dest]) {
                            stack.push(dest);
                        }
                    }
                }
            }
        }
            public void printGraph(){
                for (int i = 0; i < V; i++) {
                    LinkedList<Integer> nodeList = list[i];
                    if (nodeList.isEmpty() == false) {
                        System.out.print(i);
                        for (int j = 0; j < nodeList.size(); j++) {
                            System.out.print(nodeList.get(j));
                        }
                    }
                    System.out.println();
                }
            }
        }
public static void main(String[] args){
    Graph graph = new Graph(6);
    graph.addEdge(0,1);
    graph.addEdge(0,2);
    graph.addEdge(1,2);
    graph.addEdge(1,3);
    graph.addEdge(3,4);
    graph.addEdge(2,3);
    graph.addEdge(4,0);
    graph.addEdge(4,1);
    graph.addEdge(4,5);

    graph.DFS(0);
}

}

