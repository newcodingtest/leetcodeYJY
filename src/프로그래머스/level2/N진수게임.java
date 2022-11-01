package 프로그래머스.level2;

//n 	t	m	p	result
//2	    4	2	1	"0111"
//16	16	2	1	"02468ACE11111111"
//16	16	2	2	"13579BDF01234567"
public class N진수게임 {
    public static void main(String[] args){

       System.out.println( solution1(2,4,2,1));
    }

    public static String solution1(int n, int t, int m, int p){
        StringBuilder t1 = new StringBuilder();
        StringBuilder t2 = new StringBuilder();
        for (int i=0; t1.length()<=t*m; i++){

            t1.append(진수변환(n,i));
        }
        for (int i=p-1; t2.length()<t; i+=m){
            t2.append(t1.charAt(i));
        }
        return t2.toString();
    }
    public static String solution2(int n, int t, int m, int p){
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        // convert의 길이가 미리 구할 숫자 갯수 * 게임 참가 인원만큼 될 때 까지 n진수로 변환
        for(int i = 0; convert.length() <= t * m; i++){
            convert.append(Integer.toString(i, n));
        }

        // 튜브의 순서에 해당하는 글자들만 추출
        for(int i = p - 1;  answer.length() < t; i += m){
            answer.append(convert.charAt(i));
        }

        return answer.toString().toUpperCase();
    }

    public static String 진수변환(int n, int target){
        if(n==0 || target==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        while(target>0){
            if(target%n<10){
                sb.append(target%n);
            }else{
                sb.append((char)(target%n-10+'A'));
            }
            target/=n;

        }
        return sb.reverse().toString();
    }
}
