package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1707 {
    static int v, e, gc;
    static BufferedReader br;
    static StringTokenizer st;
    static List<Integer>[] list;
    public static void main(String[] args)throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        gc = Integer.parseInt(br.readLine());

        for (int i = 0; i<gc; i++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new ArrayList[v+1];

            for (int j = 1; j<=v; j++){
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j<e; j++){
                st = new StringTokenizer(br.readLine());

                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());

                list[one].add(two);
                list[two].add(one);
            }

            boolean flag = true;
            int[] visit = new int[v+1];
            Queue<Integer> q = new LinkedList<>();

            for (int j = 1; j<=v; j++){
                if(visit[j]==0){
                    q.add(j);
                    visit[j]=1;
                    while(!q.isEmpty() && flag){
                        int temp = q.poll();
                        for (int next : list[temp]){
                            if(visit[next]==0){
                                q.add(next);
                                visit[next] = visit[temp] * -1;
                            }else if(visit[next] == visit[temp]){
                                flag=false;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(flag ? "YES":"NO");
        }

    }
}
