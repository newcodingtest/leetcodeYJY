import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj_11576 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[count+1];
        for (int i=1; i<= count; i++){
            arr[i] = Integer.parseInt(br.readLine());
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
                sb.append(stack.pop());
            }else{
                sb.append(stack.pop()+" ");
            }
        }
    }
}
