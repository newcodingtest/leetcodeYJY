import java.io.*;
import java.util.*;

public class Main {
	static int[] nums,temp;
	static boolean[] isVisited;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	// 중복되는 수열을 여러 번 출력하면 안되며
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		temp = new int[N];
		isVisited = new boolean[N+1];
		st = new StringTokenizer(br.readLine());

		for (int i=0; i<N; i++){
			nums[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		bts(0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void bts(int now){
		if (M==now){
			for (int i=0; i<M; i++){
				sb.append(temp[i]+" ");
			}
			sb.append("\n");
		}else{
			for (int j=0; j<N; j++){
				temp[now] = nums[j];
				bts(now+1);
			}
		}
	}
}


