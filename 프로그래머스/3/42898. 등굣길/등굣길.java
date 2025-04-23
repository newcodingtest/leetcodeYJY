import java.io.IOException;


class Solution {

    static int[][] map;

    public static int solution(int m, int n, int[][] puddles) {

        map = new int[n+1][m+1];
        map[1][1] = 1;
        for (int[] water : puddles){
            map[water[1]][water[0]]= -1;
        }
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (map[i][j]==-1){
                    continue;
                }
                if (map[i][j-1]>0){
                    map[i][j] = (map[i][j]+map[i][j-1])%1_000_000_007;
                }

                if (map[i-1][j]>0){
                    map[i][j] = (map[i][j]+map[i-1][j])%1_000_000_007;
                }

            }
        }

        return map[n][m];
    }
}