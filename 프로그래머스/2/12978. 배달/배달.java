import java.util.*;
class Solution {
    static int[] min;
    static int answer = 0;
    static List<NodeV1>[] info;
public static int solution(int N, int[][] road, int K) {
        min = new int[N+1];
        info = new List[N+1];

        for (int i = 1; i <=N ; i++) {
            info[i] = new ArrayList<>();
        }
        for (int i = 2; i <=N ; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < road.length; i++) {
           int x = road[i][0];
           int y = road[i][1];
           int z = road[i][2];

           info[x].add(new NodeV1(x,y,z));
           info[y].add(new NodeV1(y,x,z));
        }

        find(1, N, K);
        return answer;
    }

    public static void find(int num, int N, int K){
        Queue<NodeV1> q = new ArrayDeque<>();
        for (NodeV1 n : info[num]){
            q.add(n);
        }

        while (!q.isEmpty()){
            NodeV1 p = q.poll();
            int start = p.start;
            int end = p.end;
            int value = p.value;

            if (min[end]>min[start]+value){
                min[end] = min[start]+value;
                q.addAll(info[end]);
            }
        }

        for (int i=1; i<=N; i++){
            if (min[i]<=K){
                answer++;
            }
        }
    }

    static class NodeV1 {
        private int start;
        private int end;
        private int value;

        public NodeV1(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}