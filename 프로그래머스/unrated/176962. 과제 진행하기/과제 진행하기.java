import java.io.IOException;
import java.util.*;
class Solution {
	public static String[] solution(String[][] plans) {
		PriorityQueue<Task> newTask = new PriorityQueue<>();
		Stack<Task> remains = new Stack<>();
		List<String> list = new ArrayList<>();

		for (int i=0; i<plans.length; i++){
			String name = plans[i][0];
			String[] splitTime = plans[i][1].split(":");
			int time = Integer.parseInt(splitTime[0])*60+Integer.parseInt(splitTime[1]);
			int start = Integer.parseInt(splitTime[0])*60;
			int playTime = Integer.parseInt(plans[i][2]);
			newTask.add(new Task(name, time, playTime));
		}

		while (!newTask.isEmpty()){
			//현재 과제
			Task now = newTask.poll();
			int nowStartTime = now.startTime;
			int nowPlayTime = now.playTime;
			
			//최근 과제가 끝난 시각
			int lastTime = nowStartTime;
			
			//새로운 과제가 있는 경우
			if (!newTask.isEmpty()){
				Task nextTask = newTask.peek();

				//현재 과제가 새로운 과제 시간안에 마무리 되는 경우
				if(nowStartTime+nowPlayTime < nextTask.startTime){
					list.add(now.name);
					lastTime+=nowPlayTime;

					//현재 과제 종료후 멈춘과제가 있는경우
					while(!remains.isEmpty()){
						Task remain = remains.pop();

						//멈춘과제가 새로운 과제 시간안에 마무리 되는 경우
						if(lastTime+remain.playTime<=nextTask.startTime){
							list.add(remain.name);
							lastTime+= remain.playTime;;

							//다음 멈춘 과제로 진행
							continue;
						}
						//멈춘과제가 새로운 과제 시간안에 마무리 되지 못하는 경우
						else{
							int lackOfTime = remain.playTime-(nextTask.startTime-lastTime);
							remains.push(new Task(remain.name,lackOfTime));

							break;
						}
					}
				}
				//현재 과제가 새로운 과제 시간안에 딱 마무리 되는 경우
				else if(lastTime+nowPlayTime == nextTask.startTime){
					list.add(now.name);
					continue;
				}
				//현재 과제가 새로운 과제 시간안에 마무리 되지 않는 경우
				else {
					int lackOfTime = nowPlayTime-(nextTask.startTime-lastTime);
					remains.push(new Task(now.name, lackOfTime));
				}
			}

			//새로운 과제가 없는경우
			else {
				//남아있는 과제가 없는경우
				if (remains.isEmpty()){
					list.add(now.name);
					lastTime+=nowPlayTime;
				}
				//남아있는 과제가 있는경우
				else {
					list.add(now.name);
					while (!remains.isEmpty()){
						Task rem = remains.pop();
						list.add(rem.name);
					}
				}
			}
			
		}
		return list.stream().toArray(String[]::new);
	}
    	static class Task implements Comparable<Task> {
		String name;
		int startTime;
		int playTime;


		public Task(String name,
						  int startTime,
						  int playTime){
			this.name = name;
			this.startTime = startTime;
			this.playTime = playTime;
		}
		public Task(String name,
					int playTime){
			this.name = name;
			this.playTime = playTime;
		}

		@Override
		public int compareTo(Task o) {
			return this.startTime - o.startTime;
		}

		private int convertTime(String strTime){
			String[] str = strTime.split(":");
			int result = Integer.parseInt(str[0])*60+Integer.parseInt(str[1]);
			return result;
		}
	}
}