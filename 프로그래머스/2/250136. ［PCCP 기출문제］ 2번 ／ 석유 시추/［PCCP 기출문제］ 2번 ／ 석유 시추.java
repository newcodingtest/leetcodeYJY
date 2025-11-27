import java.util.*;
class Solution {
    static boolean[][] isVisited;
    static int[] MAX;
    static int[] moveCol = {0,0,-1,1};
    static int[] moveRow = {-1,1,0,0};
  /**
     * 
     * 시추관 하나를 설치해 뽑을 수 있는 가장 많은 석유량을 return 하도록 solution 함수를 완성해 주세요.
     *
     * 0:빈땅, 1:석유
     * */
    public static int solution(int[][] land) {
        isVisited = new boolean[land.length][land[0].length];
        MAX = new int[land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j]==0){
                    isVisited[i][j]=true;
                }
            }
        }
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (!isVisited[i][j]){
                    isVisited[i][j]=true;
                    find(i,j, land);
                }
            }
        }
        Arrays.sort(MAX);
        return MAX[MAX.length-1];
    }

    public static void find(int x, int y, int[][] land){
        Queue<int[]>q = new ArrayDeque<>();
        q.add(new int[]{x,y});

        int maxRow = y;
        int minRow = y;
        int cnt = 1;
        while (!q.isEmpty()){
            int[] location = q.poll();
            int col = location[0];
            int row = location[1];
            for (int i = 0; i < 4; i++) {
                int ncol = col+moveCol[i];
                int nrow = row+moveRow[i];

                if (!isValid(ncol, nrow, land)) continue;

                if (!isVisited[ncol][nrow]){
                    cnt++;
                    maxRow = Math.max(maxRow, nrow);
                    minRow = Math.min(minRow, nrow);
                    isVisited[ncol][nrow]=true;
                    q.add(new int[]{ncol,nrow});
                }
            }
        }
        for (int i = minRow; i <=maxRow ; i++) {
            MAX[i]+=cnt;
        }
    }

    public static boolean isValid(int col, int row, int[][]land){
        if (col<0 || row<0 || col>=land.length || row>=land[0].length){
            return false;
        }
        return true;
    }
}