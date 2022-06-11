package 백준.문자열;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
// 문자열의 시작과 끝은 공백이 아니다.
// '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
public class Boj17413_문자열2 {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        doPrint(input);
    }

    public static void doPrint(String str) {
        boolean noChange = false;

        for(int i = 0; i<str.length(); i++) {
            //< >안에 존재하는 문자열
            if(str.charAt(i)=='<') {
                reversePrint();
                noChange = true;
                System.out.print(str.charAt(i));
            }else if(str.charAt(i)=='>') {
                System.out.print(str.charAt(i));
                noChange = false;
            }else if(noChange) {
                System.out.print(str.charAt(i));
            }
            //< >안에 존재하지 않는 문자열
            else {
                //공백은 <> 밖에서도 존재가 가능하며,
                //공백 앞에 있고, <> 밖에 존재하는 다른 문자열을 먼저 거꾸로 출력해주자,
                //공백이 나왔다는 뜻은 공백 이전과 공백 다음에, 문자열이 존재한다는 의미이다.
                if(str.charAt(i)==' ') {
                    reversePrint();
                    System.out.print(str.charAt(i));
                }
                else {
                    stack.push(str.charAt(i));
                }
            }
        }

        //공백뒤에 남은 문자열 출력
        reversePrint();
    }

    public static void reversePrint() {
        while(!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}
