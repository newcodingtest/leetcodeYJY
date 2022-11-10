package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1969_DNA {

    static int MIN;
    static int result = 0;
    static String[][] dna;
    static int[] ACGT;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        dna = new String[n][length];
        ACGT = new int[4];

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<length; j++){
                dna[i][j] = String.valueOf(str.charAt(j));
            }
        }

        for (int i=0; i<length; i++) {
            ACGT[0] = 0; //A
            ACGT[1] = 0; //C
            ACGT[2] = 0; //G
            ACGT[3] = 0; //T

            for (int j=0; j<n; j++){
                if(dna[j][i].equals("A")){
                    ACGT[0]++;
                }else if(dna[j][i].equals("C")){
                    ACGT[1]++;
                }else if(dna[j][i].equals("G")){
                    ACGT[2]++;
                }else if(dna[j][i].equals("T")){
                    ACGT[3]++;
                }
            }

            int idx = 0;
            int max = 0;
            for(int k=0; k<4; k++){
                if(max<ACGT[k]){
                    max = ACGT[k];
                    idx = k;
                }
            }
            add(idx);

            int temp = n-Math.max(ACGT[0]>ACGT[1]?ACGT[0]:ACGT[1],ACGT[2]>ACGT[3]?ACGT[2]:ACGT[3]);

            result+=temp;
        }

        System.out.println(sb.toString());
        System.out.println("result = " + result);
    }

    public static void add(int n){
        switch (n){
            case 0:
                sb.append("A");
                break;
            case 1:
                sb.append("C");
                break;
            case 2:
                sb.append("G");
                break;
            case 3:
                sb.append("T");
                break;
        }
    }

}
