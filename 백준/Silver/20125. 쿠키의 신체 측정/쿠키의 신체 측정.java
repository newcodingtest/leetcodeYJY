import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[][] map;
    static int N;
    //1.심장이 위치한 좌표
    //2.왼쪽 팔 길이, 오른쪽 팔 길이, 허리 길이, 왼쪽 다리길이, 오른쪽 다리길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i=0; i<N; i++){
            String[] str = br.readLine().split("");
            for (int j=0; j<str.length; j++){
                map[i][j] = str[j];
            }
        }

        Location heart = null;
        for (int i=0; i<N; i++){
            int len = 0;
            int col = 0;
            int row = 0;
            for (int j=0; j<N; j++){
                if (map[i][j].equals("*")){
                    col=i;
                    row=j;
                    len++;
                }
            }
            if (len==1){
                sb.append((col+2)+" ").append((row+1)+"\n");
                heart = new Location(col+1, row);
                break;
            }
        }
        Location waist = null;
        for (int j=heart.col+1; j<N; j++){
            if (!map[j][heart.row].equals("*")){
                waist = new Location(j-1,heart.row);
                break;
            }
        }

        sb.append(leftArmsLen(heart)+" ")
          .append(rightArmsLen(heart)+" ")
          .append(waistLen(heart)+" ")
          .append(leftLegsLen(waist)+" ")
          .append(rightLegsLen(waist));

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static class Location {
        private int col;
        private int row;

        public Location(int col, int row){
            this.col = col;
            this.row = row;
        }
    }

    static int leftArmsLen(Location heart){
        int len = 0;
        for (int i=heart.row-1; i>=0; i--){
            if (map[heart.col][i].equals("*")){
                len++;
            } else {
                break;
            }
        }
        return len;
    }
    static int rightArmsLen(Location heart){
        int len = 0;
        for (int i=heart.row+1; i<N; i++){
            if (map[heart.col][i].equals("*")){
                len++;
            } else {
                break;
            }
        }
        return len;
    }
    static int leftLegsLen(Location waist){
        int len = 0;
        for (int i=waist.col+1; i<N; i++){
            if (map[i][waist.row-1].equals("*")){
                len++;
            } else {
                break;
            }
        }
        return len;
    }
    static int rightLegsLen(Location waist){
        int len = 0;
        for (int i=waist.col+1; i<N; i++){
            if (map[i][waist.row+1].equals("*")){
                len++;
            } else {
                break;
            }
        }
        return len;
    }

    static int waistLen(Location heart){
        int len = 0;
        for (int i=heart.col+1; i<N; i++){
            if (map[i][heart.row].equals("*")){
                len++;
            } else {
                break;
            }
        }
        return len;
    }

}
