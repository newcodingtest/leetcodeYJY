class Solution {
    static final char EMPTY_SPACE = '.';
    static char[][] block;
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        block = new char[board.length][board[0].length()];

        for (int i=0; i<board.length; i++){
            block[i] = board[i].toCharArray();
        }

        while (true){
            int cnt = sim(m, n);
            if (cnt == 0){
                break;
            }
            answer+=cnt;
        }
        return answer;
    }
    
      private static int sim(int m, int n){
        boolean[][] check = new boolean[m][n];
        int cnt = 0;

        for (int i=0; i<m-1; i++){
            for (int j=0; j<n-1; j++){
                if (block[i][j] != EMPTY_SPACE && check4Block(i,j)){
                    check[i][j] = check[i+1][j] = check[i][j+1] = check[i+1][j+1] = true;
                }
            }
        }

        cnt = count4BlockAndChangeToBlank(check, m, n);

        while(fillInEmptyBlock(m,n));

        return cnt;
    }

    private static boolean fillInEmptyBlock(int m, int n){
        boolean isAllMoved = false;

        for (int i=0; i<n; i++){
            for (int j=0; j<m-1; j++){
                if (block[j][i] != EMPTY_SPACE && block[j+1][i] == EMPTY_SPACE){
                    block[j+1][i] = block[j][i];
                    block[j][i] = EMPTY_SPACE;
                    isAllMoved = true;
                }
            }
        }
        return isAllMoved;
    }

    private static int count4BlockAndChangeToBlank(boolean[][] check, int m, int n){
        int cnt = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (check[i][j]){
                    cnt++;
                    block[i][j]='.';
                }
            }
        }
        return cnt;
    }

    private static boolean check4Block(int i, int j) {
        char target = block[i][j];
        //주변 4개의 블록이 같은지 확인한다.
        if (target==block[i+1][j] && target==block[i][j+1] && target==block[i+1][j+1]){
            return true;
        }
        return false;
    }
}