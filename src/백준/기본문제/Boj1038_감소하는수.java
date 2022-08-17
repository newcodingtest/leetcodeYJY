package 백준.기본문제;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Boj1038_감소하는수 {

    static long N;
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(br.readLine());

        if(N<=10) {
            System.out.println(N);
        }else {
            //자리 수 별로 감소 수 구하기
            //1자리 수는 0~9까지 기본적으로 깔고 가고, 2자리 수부터 구하는데 집중하자
            //최대 감소수 표현 자리 수는 10자리임(9876543210)
            for(int i=0; i<10; i++) {
                cal(i,1);
            }
            Collections.sort(list);
            //만약 N번째 자리수까지 값이 없다면 -1출력
            if(list.size()<=N) {
                System.out.println(-1);
            }else {
                //정렬
                System.out.println(list.get((int)N));
            }
        }
    }


    //@param(표현숫자,자리수)
    public static void cal(long value, int len) {
        //자리수가 10자리 넘으면 안됨
        if(len>10) {
            return;
        }
        list.add(value);

        for(int i=0; i<=9; i++) {
            if(value%10>i) {
                //10* 해서 표현 자리수 늘려주고 뒤에 적은숫자 i를 추가해준다., len+1 해서 자리수 늘려주고
                cal((10*value)+i, len+1);
            }
        }

    }
}
