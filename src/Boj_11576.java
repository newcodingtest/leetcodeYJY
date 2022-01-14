import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


/*
17진법을 8진법으로 바꿔야 하며 , 2자리의 수가 주어지는데 각 자리수가 2 16이라고 해보자.

우선 17진법을 8진법으로 바꾸려면 17진법 ->10진법 ->8진법으로 바꿔야한다.

2 16이 처음에는 뭔가 했는데 알고보니 각각의 숫자가 아니라 하나의 숫자였다. 2가 1의 자리

16이 0의 자리 였다.



그래서 17진법을 10진법으로 바꾸면

2*(17)^1 +16*(17)^0 =34+16=50



10진법을 8진법으로 바꾸면



50=(8*6)+2

6=(8*0)+6

* */
public class Boj_11576 {
    static  StringTokenizer st;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[count+1];
        st = new StringTokenizer(br.readLine()," ");
        for (int i=1; i<= count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i=1; i<= count; i++){
           result += arr[i] * Math.pow(a, count-i);
        }

        Stack<Integer> stack = new Stack<>();
        while(result!=0){
            stack.push(result%b);

            result /= b;
        }

        while(!stack.isEmpty()){
            if (stack.size()== 1){
                sb.append(stack.peek());
            }else{
                sb.append(stack.peek()+" ");
            }
            stack.pop();
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
