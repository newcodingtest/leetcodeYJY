
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] pelin = new int[26];
        String input = br.readLine();

        //A~Z: 65~90
        for(int i=0; i<input.length(); i++){
            pelin[input.charAt(i)-'A']++;
        }

        int isPelinCnt = 0;
        for (int i=0; i<pelin.length; i++){
            if(pelin[i]%2!=0){
                isPelinCnt++;
            }
        }

        if(isPelinCnt>1){
            System.out.println("I'm Sorry Hansoo");
        }else{
            int centerIndex=0;
            StringBuffer temp= new StringBuffer();
            StringBuffer result = new StringBuffer();
            for (int i=0; i<pelin.length; i++){
                if(pelin[i]%2!=0){
                    centerIndex=i;
                }
                for (int j=0; j<pelin[i]/2; j++){
                        temp.append((char)(i+'A'));

                }
            }
            if(isPelinCnt==1) {
                result.append(temp.toString() + (char) (centerIndex + 'A') + temp.reverse().toString());
            }else{
                result.append(temp.toString()  + temp.reverse().toString());
            }
            System.out.println(result.toString());
        }

    }
}
