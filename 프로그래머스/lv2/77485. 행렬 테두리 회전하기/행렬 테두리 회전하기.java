import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int[][] maps;
public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		setup(rows,columns);

		for (int i=0; i< queries.length; i++){
			answer[i] = rotate(queries[i]);
		}
		Arrays.stream(answer)
				.forEach(System.out::println);
		return answer;
	}

	private static int rotate(int[] num) {
		int answer = Integer.MAX_VALUE;
		Queue<Integer>q = new LinkedList<>();

		q.add(maps[num[0]][num[1]]);
		int r1 = num[0];
		int c1 = num[1];

		int r2 = num[2];
		int c2 = num[3];

		//위 가로
		for (int i=c1+1; i<=c2; i++){
			q.add(maps[r1][i]);
			maps[r1][i]=q.poll();
			answer = Math.min(answer,maps[r1][i]);
		}
		//오른 세로
		for (int i=r1+1; i<=r2; i++){
			q.add(maps[i][c2]);
			maps[i][c2]=q.poll();
			answer = Math.min(answer,maps[i][c2]);
		}
		//아래 가로
		for (int i=c2-1; i>=c1; i--){
			q.add(maps[r2][i]);
			maps[r2][i]=q.poll();
			answer = Math.min(answer,maps[r2][i]);
		}
		//왼 세로
		for (int i=r2-1; i>=r1; i--){
			q.add(maps[i][c1]);
			maps[i][c1]=q.poll();
			answer = Math.min(answer,maps[i][c1]);
		}
		return answer;
	}

	public static void setup(int rows, int columns){
		maps = new int[rows+1][columns+1];
		int start = 1;
		for (int i=1; i<=rows; i++){
			for (int j=1; j<=columns; j++){
				maps[i][j] = start++;
			}
		}
	}
}