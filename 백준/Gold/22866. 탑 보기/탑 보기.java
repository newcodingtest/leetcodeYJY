import java.io.*;
import java.util.*;

class Main {
           public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());

        //왼쪽, 오른쪽, 볼수있는 건물 개수
        int[] cnt = new int[input+1];
        //최근 볼수있는 건물중 가장 가까운 건물의 idx (왼쪽부터 최신으로 기록될듯, 추후 오른쪽 비교시 왼쪽과의 거리비교 필요)
        int[] near = new int[input+1];
        int[] top = new int[input+1];

        Arrays.fill(near, -100_000);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=input; i++){
            top[i] = Integer.parseInt(st.nextToken());
        }
        //오른쪽 검사
        Stack<Integer> stack = new Stack<>();
        for (int i=1; i<=input; i++){
            //현재 건물보다 큰 건물들만 stack에 남긴다.
            while (!stack.isEmpty() && top[stack.peek()]<=top[i]){
                stack.pop();
            }
            //현재 건물 기준 왼쪽에 큰 건물이 존재하는 개수
            cnt[i] = stack.size();
            //큰 건물들 중에서 가장 가까운 건물의 idx
            if (stack.size()>0){
                near[i] = stack.peek();
            }
            //다음 비교를 위해 현재 건물 stack에 넣기
            stack.push(i);
        }

        //왼쪽 검사
        stack = new Stack<>();
        for (int i=input; i>0; i--){
            //현재 건물보다 큰 건물들만 stack에 남긴다.
            while (!stack.isEmpty() && top[stack.peek()]<=top[i]){
                stack.pop();
            }
            //현재 건물 기준 왼쪽에 큰 건물이 존재하는 개수
            cnt[i] += stack.size();

            //큰 건물들 중에서 가장 가까운 건물의 구하기
            if (stack.size()>0){
                //가장 가까운 건물을 구하기 위해서 왼쪽에 존재하는 건물들과의 거리 비교를 해야함, 가장 가까운 건물이 택해짐
                //오른쪽 건물이 왼쪽 건물보다 가까운 경우, 오른쪽 건물을 가깝운 건물로 선정
                if ((stack.peek()-i)<(i-near[i])){
                    near[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        for (int i=1; i<=input; i++){
            sb.append(cnt[i]+" ");
            if (cnt[i]>0){
                sb.append(near[i]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}