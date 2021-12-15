package 백준.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_10825 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] student = new String[n][4];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            student[i][0]=st.nextToken();//과목
            student[i][1]=st.nextToken();//국
            student[i][2]=st.nextToken();//영
            student[i][3]=st.nextToken();//수
        }

   Arrays.sort(student, new Comparator<String[]>() {
       @Override
       public int compare(String[] o1, String[] o2) {
           if(Integer.parseInt(o1[1])!=Integer.parseInt(o2[1])){
               return Integer.compare(Integer.parseInt(o2[1]),Integer.parseInt(o1[1]));
           }else{
               if(Integer.parseInt(o1[2])!=Integer.parseInt(o2[2])){
                   return Integer.compare(Integer.parseInt(o1[2]),Integer.parseInt(o2[2]));
               }else{
                   if(Integer.parseInt(o1[3])!=Integer.parseInt(o2[3])) {
                       return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));
                   }else{
                       return o1[0].compareTo(o2[0]);
                   }
               }
           }

       }
   });

        for (int i=0; i<n; i++){
            sb.append(student[i][0]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }



}
