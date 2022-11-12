package 프로그래머스.level2.완전탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기 {
    static boolean[] isVisited;
    static boolean[][] map;
    static int answer = Integer.MAX_VALUE;
    static List<Integer>[] relation;
    static int N;

    public static int solution(int n, int[][] wires) {
        N = n;

        map = new boolean[n+1][n+1];
        relation = new List[n+1];

        for (int i=1; i<=n; i++){
            relation[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++){
            relation[wires[i][0]].add(wires[i][1]);
            relation[wires[i][1]].add(wires[i][0]);
        }

        for (int i=0; i<n-1; i++){
            int x = wires[i][0];
            int y = wires[i][1];

            map[x][y]=true;
            map[y][x]=true;
            answer = Math.min(answer,dfs(n,x));
            map[x][y]=false;
            map[y][x]=false;
        }
        return answer;
    }

    public static int dfs(int n, int start){
        isVisited = new boolean[n+1];
        Queue<Integer>q = new LinkedList<>();
        q.add(start);

        int cnt = 1;
        while (!q.isEmpty()){
            int parent = q.poll();
            isVisited[parent]=true;
            for (int elem : relation[parent]){
                if(!isVisited[elem]){
                    if(!map[parent][elem]){
                        q.add(elem);
                        cnt++;
                    }
                }
            }
        }

        return (Math.abs(n-2*cnt));

    }


    public static void main(String[] args){
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int n = 9;

        int[][] wires1 = {{1,2},{2,3},{3,4}};
        int n1 = 4;

        System.out.println(   solution(n1,wires1));
    }
}
