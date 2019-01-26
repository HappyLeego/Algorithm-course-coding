package nuaa.lily;

import java.util.Arrays;
import java.util.Comparator;


public class MeetingProgram {
	public static class Progrem{
		int start;
		int end;
		public Progrem(int start,int end){
			this.start = start;
			this.end = end;
		}
	}
	public static class ProgremComparator implements Comparator<Progrem>{

		@Override
		public int compare(Progrem o1, Progrem o2) {
			
			return o1.end - o2.end;
		}
	}
	
	public static int maxTimes(Progrem[] progrems,int cur){
		Arrays.sort(progrems,new ProgremComparator());
		int result = 0;
		for(int i = 0; i < progrems.length; i++){
			if(cur <= progrems[i].start){
				result++;
				cur = progrems[i].end;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Progrem[] progrems = new Progrem[3];
		progrems[0] = new Progrem(1,3);
		progrems[1] = new Progrem(2,4);
		progrems[2] = new Progrem(4,5);
		
		System.out.println(maxTimes(progrems, 0));
		
	}
}
