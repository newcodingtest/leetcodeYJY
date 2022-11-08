package 프로그래머스.level2;

public class N_Queen {
    static int N;
    static int ans = 0;
    static boolean[][] map;

    public static void dfs(int col){
        if(col== N){
            ans++;
            return;
        }
        for (int i=0; i<N; i++){
            map[col][i]=true;
            if(isValid(col,i)){
                dfs(col+1);
            }
            map[col][i]=false;
        }
    }

    public static boolean isValid(int col, int row){
        //가로
        for (int i=0; i<N; i++){
            if(i == row)
                continue;

            if(map[col][i]){
                return false;
            }
        }
        //세로
        for (int i=0; i<N; i++){
            if(i==col)
                continue;

            if(map[i][row]){
                return false;
            }
        }

        int diff = Math.abs((col-row));
        //대각선
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(col==i && row==j)continue;
                int crossX = Math.abs((i-col));
                int crossY = Math.abs((j-row));
                if(crossX==crossY && map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int solution(int n) {
        N = n;
        int answer = 0;
        map = new boolean[n][n];
        dfs(0);
        answer = ans;
        return answer;
    }

    public static void main(String[] args) {
        solution(4);
        System.out.println(ans);
    }

}
