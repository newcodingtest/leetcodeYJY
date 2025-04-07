import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        List<Information> info = new ArrayList<>();
        for (int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int solved = Integer.parseInt(st.nextToken());
            int enterYear = Integer.parseInt(st.nextToken());
            String firstName = st.nextToken();

            info.add(new Information(solved, enterYear, firstName));
        }

        //입학년도
        info.sort(Comparator.comparingInt(o -> o.enterYear));
        String str = String.valueOf(info.get(0).enterYear%2000)+
                String.valueOf(info.get(1).enterYear%2000)+
                String.valueOf(info.get(2).enterYear%2000);
        System.out.println(str);

        //푼 문제
        info.sort(Comparator.comparingInt(Information::getSolved).reversed());
        str = info.get(0).firstName.substring(0,1)+
                info.get(1).firstName.substring(0,1)+
                info.get(2).firstName.substring(0,1);
        System.out.println(str);
    }

    public static class Information {
        int solved;
        int enterYear;
        String firstName;

        public Information(int solved,
                           int enterYear,
                           String firstName){
            this.solved = solved;
            this.enterYear = enterYear;
            this.firstName = firstName;

        }

        public  int getSolved(){
            return this.solved;
        }
    }

}
