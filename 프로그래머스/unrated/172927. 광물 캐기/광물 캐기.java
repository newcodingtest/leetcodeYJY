
import java.util.*;
class Solution {
	/**
	 * @param picks
	 * @param minerals
	 * @return
	 */
public static int solution(int[] picks, String[] minerals) {
		int answer = 0;
		int cnt = Math.min(minerals.length-1/5,picks[0]+picks[1]+picks[2]);
		int dia = 0;
		int iron = 0;
		int ston = 0;

		int[][] sec = new int[cnt][3];
		for (int i=0; i< minerals.length; i+=5){
			if (i/5==cnt){
				break;
			}
			for (int j=i; j<i+5; j++){
				String mins = minerals[j];
				if (mins.equals("diamond")){
					dia+=1;
					iron+=5;
					ston+=25;
				} else if(mins.equals("iron")) {
					dia+=1;
					iron+=1;
					ston+=5;
				} else if(mins.equals("stone")) {
					dia+=1;
					iron+=1;
					ston+=1;
				}

				if (j==minerals.length-1){
					break;
				}
			}
			sec[i/5][0]=dia;
			sec[i/5][1]=iron;
			sec[i/5][2]=ston;
			dia=0;
			iron=0;
			ston=0;
		}
Arrays.sort(sec, (o1, o2) -> (o2[2]-o1[2]));
		for (int i=0; i<cnt; i++){
			//다이아
			if(picks[0]!=0){
				answer+=sec[i][0];
				picks[0]--;
			}
			//아이언
			else if(picks[1]!=0){
				answer+=sec[i][1];
				picks[1]--;
			}
			//돌
			else if(picks[2]!=0){
				answer+=sec[i][2];
				picks[2]--;
			}
		}
		return answer;
	}
}