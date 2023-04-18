import java.io.IOException;
class Solution {
static int MAX = 0;
    static boolean[] isVisited;
    public static int solution(int k, int[][] dungeons) {

        isVisited = new boolean[dungeons.length];

        bfs(k,0,dungeons);
        return MAX;
    }

    // (현재 남은 피로도, ,시작위치,방문한 던전수, 방문 가능한 던전 누적값, 던전)
    public static void bfs(int k, int cnt, int[][] dungeons){
        for (int i=0; i<dungeons.length; i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                if(k>=dungeons[i][0] && k-dungeons[i][1]>=0){
                    bfs(k-dungeons[i][1],cnt+1,dungeons);
                }
                isVisited[i]=false;

            }
        }

        MAX = Math.max(MAX,cnt);
    }

}