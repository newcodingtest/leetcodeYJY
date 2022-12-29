package 프로그래머스.level2.완전탐색;

public class 피로도 {
    static boolean[] isVisited;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }

    public static void dfs(int cnt, int k, int[][] dungeons){

        for (int i=0; i<dungeons.length; i++){
            if(!isVisited[i] && k>=dungeons[i][0]){
                isVisited[i]=true;
                dfs(cnt+1,k-dungeons[i][1],dungeons);
                isVisited[i]=false;
            }
        }
        answer = Math.max(answer,cnt);
    }

    public static void main(String[] args){

    }

}
