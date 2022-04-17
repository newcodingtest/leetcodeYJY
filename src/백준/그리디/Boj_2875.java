    package 백준.그리디;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Boj_2875 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            int women = Integer.parseInt(st.nextToken());
            int man = Integer.parseInt(st.nextToken());
            int except = Integer.parseInt(st.nextToken());

            int count=0;
            while(women>=2 && man>=1 && women+man>=3+except){
                women-=2;
                man--;
                count++;
            }
            System.out.println(count);
        }
    }
