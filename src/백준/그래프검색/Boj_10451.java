package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_10451 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> a = new ArrayList<>(); // 연결 리스트
            for (int i = 0; i <= N; i++) {
                a.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int t = Integer.parseInt(st.nextToken());
                a.get(i).add(t);
            }

            boolean[] visited = new boolean[N + 1];
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(a, visited, i);
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // DFS를 통해서 start와 연결된 점을 visited[i] = true로 처리함.
    public static void DFS(ArrayList<ArrayList<Integer>> a, boolean[] visited, int start) {

        for (int i : a.get(start)) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(a, visited, i);
            }
        }
    }

}
