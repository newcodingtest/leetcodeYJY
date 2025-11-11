import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    static long answer = 0;
    static List<String> oper = new ArrayList<>();
    static boolean[] isVisited;
    static String[] op = new String[]{"+","-","*"};
    static String[] orderity = new String[3];
    static List<Long> num;
    //우승 시 받을 수 있는 가장 큰 상금 금액을(절대값도 포함)
   public static long solution(String expression) {
        num = Arrays.stream(expression.split("-|\\+|\\*"))
                .map(s -> Long.parseLong(s))
                .collect(Collectors.toList());

        for (int i=0; i<expression.length(); i++){
            if (expression.charAt(i)=='-' || expression.charAt(i)=='+'
            || expression.charAt(i)=='*' || expression.charAt(i)=='/'){
                oper.add(String.valueOf(expression.charAt(i)));
            }
        }
        isVisited = new boolean[op.length];

        dfs(0);

        return answer;
    }

    private static void dfs(int cnt){
        if (cnt==op.length){
            calc();
            return;
        }

        for (int i=0; i<op.length; i++){
            if (!isVisited[i]){
                isVisited[i]=true;
                orderity[cnt] = op[i];
                dfs(cnt+1);
                isVisited[i]=false;
            }
        }
    }

    private static void calc() {
        List<Long> tmpNums = new ArrayList<>(num);
        List<String>tmpOper = new ArrayList<>(oper);

        for (int i = 0; i < orderity.length; i++) {
            String order = orderity[i];
            for (int j = 0; j < tmpOper.size() ; j++) {
                if (order.equals(tmpOper.get(j))){
                    long result = calc(tmpNums.get(j),tmpNums.get(j+1), order);
                    tmpNums.remove(j+1);
                    tmpNums.remove(j);
                    tmpOper.remove(j);

                    tmpNums.add(j, result);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(tmpNums.get(0)));
    }

    private static long calc(long n1, long n2, String op){
        //System.out.println(n1+" "+op+" "+n2);
        return switch (op){
            case "+" -> n1+n2;
            case "-" -> n1-n2;
            case "*" -> n1*n2;
            default -> 0;
        };
    }
}