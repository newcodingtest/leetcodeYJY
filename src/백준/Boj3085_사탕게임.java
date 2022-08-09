package 백준;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj3085_사탕게임 {
    static char[][] alpa;
    static int N;
    static int cnt = 0;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
//		if(3>N) {
//			System.exit(-1);
//		}
        alpa = new char[N][N];

        for(int i=0; i<N; i++) {
            String[] temp = br.readLine().split("");
            for(int j=0; j<N; j++) {
                alpa[i][j]=temp[j].charAt(0);
            }
        }

        changeRow();
        changeCol();

        System.out.println(cnt);
    }

    //열 변경
    public static void changeRow() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                //if(alpa[i][j]!=alpa[i][j+1]) {
                char temp = alpa[i][j+1];
                alpa[i][j+1]=alpa[i][j];
                alpa[i][j]=temp;
                search();
                alpa[i][j]=alpa[i][j+1];
                alpa[i][j+1]=temp;
                //}

            }
        }
    }

    //행 변경
    public static void changeCol() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                //if(alpa[j][i]!=alpa[j+1][i]) {
                char temp = alpa[j+1][i];
                alpa[j+1][i]=alpa[j][i];
                alpa[j][i]=temp;
                search();
                alpa[j][i]=alpa[j+1][i];
                alpa[j+1][i]=temp;
                //}

            }
        }
    }

    private static void search() {
        //열 검사
        for(int i=0; i<N; i++) {
            int tempCnt = 1;
            for(int j=0; j<N-1; j++) {
                if(alpa[i][j]==alpa[i][j+1]) {
                    tempCnt++;
                }else {
                    tempCnt = 1;
                }
                cnt = Math.max(cnt, tempCnt);
            }

        }
        //행 검사
        for(int i=0; i<N; i++) {
            int tempCnt = 1;
            for(int j=0; j<N-1; j++) {
                if(alpa[j][i]==alpa[j+1][i]) {
                    tempCnt++;
                }else {
                    tempCnt = 1;
                }
                cnt = Math.max(cnt, tempCnt);
            }

        }
    }
}
