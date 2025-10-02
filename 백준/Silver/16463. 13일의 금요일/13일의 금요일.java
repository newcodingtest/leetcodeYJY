import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class Main {
    static int[] daysWithLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //366
    static int[] daysWithoutLeap = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //365
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        int daySum = 0;
        int answer = 0;
        //dp[1] = dp[n-1]+13 = 7나누면 4가 나와야 한다.
        for (int i=2019; i<=year; i++){
            if (isLeapYear(i)){
                for (int j=0; j<12; j++){
                    if ((daySum+13)%7==4){
                        answer++;
                    }
                    daySum+=daysWithLeap[j];
                }
            } else {
                for (int j=0; j<12; j++){
                    if ((daySum+13)%7==4){
                        answer++;
                    }
                    daySum+=daysWithoutLeap[j];
                }
            }
        }

        System.out.println(answer);
    }
    //금요일 n%7 == 5이면 금, 13일
    //2019년도부터 N년까지 누적되는 13일의 금요일 계산하기, 2019년도 1월1일은 화요일, 2월이 29일이면 윤년, 윤년은 400의 배수년도
    //100의 배수가 아니면서 4의 배수인 연도는 윤년

    public static boolean isLeapYear(int year){
        if (year%400==0){
            return true;
        }
        if (year%4==0 && year%100!=0){
            return true;
        }
        return false;
    }




}

