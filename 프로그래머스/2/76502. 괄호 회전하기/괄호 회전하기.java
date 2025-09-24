import java.io.IOException;
import java.util.*;
class Solution {
        static Stack<String> stack = new Stack<>();
    static Set<String> dup = new HashSet<>();
 public static int solution(String s) {
        int answer = 0;
       answer = dfs(s, 0);

        return answer;
    }

    public static int dfs(String s, int cnt){
        if (dup.contains(s)){
            return cnt;
        }
        dup.add(s);

        String pre = s.substring(0, s.length()-1);
        String suf = s.substring(s.length()-1);

        String next = suf+pre;

        if (is괄호(s)){
            return dfs(next, cnt+1);
        } else {
             return dfs(next, cnt);
        }
    }


    public static boolean is괄호(String str){

        String[] arr = str.split("");
        for (int i = 0; i < arr.length; i++) {
            if (!(isPair(arr[i], "(",")") && isPair(arr[i], "[","]") && isPair(arr[i], "{","}"))){
                return false;
            }
        }
        return stack.empty();
    }

    public static boolean isPair(String a, String b, String c){
        if (a.equals(b)){
            stack.push(a);
        } else if(a.equals(c)){
            if (!stack.isEmpty() && stack.peek().equals(b)){
                stack.pop();
            }else {
                return false;
            }
        }
        return true;
    }
}