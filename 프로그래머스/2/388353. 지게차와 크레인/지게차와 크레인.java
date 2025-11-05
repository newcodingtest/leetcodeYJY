class Solution {
        static char[][] arr;
    static boolean[][] isVisited;

    //위 아래 오 왼
    static int[] moveCol = {-1,1,0,0};
    static int[] moveRow = {0,0,1,-1};
    static int n,m,answer;
    public static int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        arr = new char[n][m];
        answer = n*m;

        for (int i=0; i<n; i++){
            arr[i] = storage[i].toCharArray();
        }


        for (int i=0; i<requests.length; i++){
            String pattern = requests[i];
            if(pattern.length()>1){
                usrCrane(pattern.charAt(0));
            } else {
                usrForkLift(pattern.charAt(0));
            }
        }

        return answer;
    }


    private static void usrForkLift(char pattern) {
        isVisited = new boolean[n][m];
        //테두리 제거
        //세로
        for (int i=0; i<n; i++){
            if (!isVisited[i][0]){
                dfs(i,0,pattern);
            }
            if (!isVisited[i][m-1]){
                dfs(i,m-1,pattern);
            }
        }
        //가로
        for (int i=0; i<m; i++){
            if (!isVisited[0][i]){
                dfs(0,i,pattern);
            }
            if (!isVisited[n-1][i]){
                dfs(n-1,i,pattern);
            }
        }
    }

    private static void usrCrane(char pattern){
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (arr[i][j]==pattern){
                    answer--;
                    arr[i][j]=0;
                }
            }
        }
    }

    private static void dfs(int col, int row, char pattern){
        isVisited[col][row] = true;

        if (arr[col][row]==0){
            for (int i = 0; i < 4; i++) {
                int ncol = col+moveCol[i];
                int nrow = row+moveRow[i];
                if (isValid(ncol, nrow)){
                    if (!isVisited[ncol][nrow]){
                        dfs(ncol, nrow, pattern);
                    }
                }
            }
        }

        if (arr[col][row]==pattern){
            answer--;
            arr[col][row]=0;
        }
    }


    public static boolean isValid(int col, int row){
        if (col<0 || row<0 || col>arr.length-1 || row>arr[0].length-1){
            return false;
        }
        return true;
    }
}