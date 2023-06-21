import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	//도시개수 N, 도로의 개수 M, 거리정보 K, 출발도시번호 X
	static int N,M,K,X;
	static List<Integer> list[];

	static StringBuilder sb = new StringBuilder();
	static int[] dp = new int[300000+1];
	static List<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new List[N+1];

		for (int i=1; i<=N; i++){
			list[i] = new ArrayList();
			dp[i]=-1;
		}


		for (int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
		}

		dfs(X);

		if (answer.size()>0){
			Collections.sort(answer);
			answer.stream().forEach(x -> {
				System.out.println(x);
			});
		}else{
			System.out.println(-1);
		}
	}

	public static void dfs(int start){
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		dp[start]=0;

		while (!q.isEmpty()){
			int x = q.poll();
			if(dp[x]>K){
				break;
			}
			if(dp[x]==K){
				answer.add(x);
			}

			for (int i = 0; i<list[x].size(); i++){
				int elem = list[x].get(i);
				if(dp[elem]==-1){
					dp[elem]=dp[x]+1;
					q.add(elem);
				}
			}
		}

	}

}

