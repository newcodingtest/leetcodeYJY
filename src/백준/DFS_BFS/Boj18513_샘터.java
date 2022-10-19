package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18513_샘터 {
    static int N,K;
    static int[] move = {-1,1}; //왼, 오
    static HashMap<Integer, Boolean> visited = new HashMap<>();
    static List<Integer> sam = new ArrayList<>();
    static List<Integer> house = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static int cnt = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            q.add(Integer.parseInt(st.nextToken()));
        }
        bfs();

    }

    public static void bfs(){
        int sum=0;

        while (!q.isEmpty()){
            if(cnt==K){
                System.out.println("sum = " + sum);
                break;
            }
            int samul = q.poll();

            for (int i=0; i<2; i++){
                Integer key = samul + move[i];

                if(!isVisited(key)){
                    visited.put(key,true);
                    q.add(key);
                    house.add(key);
                    sum+=Math.abs(samul-key);
                    ++cnt;
                }
            }
        }
    }

    public static boolean isVisited(Integer key){
        if (visited.containsKey(key)){
            return true;
        }
        return false;
    }

    static class Node{
        int key;
        int cnt;

        public Node(int key, int cnt){
            this.key = key;
            this.cnt = cnt;
        }
    }
}
