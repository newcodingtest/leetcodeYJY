package 프로그래머스.level2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 카카오프렌즈컬러링북 {
    static boolean[][] visited;
    static int[][] globalPicture;
    static List<Integer> list = new ArrayList<Integer>();
    static int[] answer = new int[2];
    static int cnt = 0;

    public static int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[picture.length][picture[0].length];
        globalPicture = picture;

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i=0; i<globalPicture.length; i++) {
            for(int j=0; j<globalPicture[0].length; j++) {
                if(globalPicture[i][j]!=0) {
                    search(i, j);
                }else if(cnt>0) {
                    list.add(cnt);
                    cnt=0;
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        answer[0] = list.size();
        answer[1] = list.get(0);

        return answer;
    }

    public static void search(int x, int y) {
        if(visited[x][y]) {
            return;
        }

        cnt++;
        int element = globalPicture[x][y];
        visited[x][y]=true;

        if(x-1>=0 && !visited[x-1][y] &&  globalPicture[x-1][y]==element) {
            search(x-1, y);
        }
        if(x+1<globalPicture.length && !visited[x+1][y] &&  globalPicture[x+1][y]==element) {
            search(x+1, y);
        }
        if(y-1>=0 && !visited[x][y-1] && globalPicture[x][y-1]==element) {
            search(x, y-1);
        }
        if( y+1<globalPicture[0].length && !visited[x][y+1] && globalPicture[x][y+1]==element) {
            search(x, y+1);
        }

    }
}
