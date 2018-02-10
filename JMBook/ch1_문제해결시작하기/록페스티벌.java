package JMBook.ch1_문제해결시작하기;

import java.io.FileNotFoundException;
import java.io.IOException;

import JMBook.Chapter;
import JMBook.Problem;

/**
 * @author Jaeyoung Lee
 */
public class 록페스티벌 extends Problem{
	private static final String PROBLE_MNAME = "록페스티벌";

	public 록페스티벌() throws FileNotFoundException {
		setInput(Chapter.CH1.getInputSource(PROBLE_MNAME));
	}

	@Override
	protected void solution() throws IOException {
		int days = scanner.nextInt();
		int teams = scanner.nextInt();

		int[] costs = new int[days];
		for(int index=0; index < days ; index++){
			costs[index] = scanner.nextInt();
		}

		double avgMin = Double.MAX_VALUE;
		for(int day = teams ; day <= days ; day++) {

			//int dayCostSum = 0;	-> WRONG : 초기화 위치가 잘못되었음!
			for(int startDay = 0 ; startDay <= days - day ; startDay++){
				int dayCostSum = 0;

				for(int position=startDay; position < day + startDay ; position++){
					dayCostSum += costs[position];
				}
				double dayMin = (double)dayCostSum/day;
				if(avgMin > dayMin){
					avgMin = dayMin;
					System.out.println("start day , day: "  + startDay + "," + day);
				}
			}
		}
		System.out.printf("%.10f",avgMin);
		System.out.println();
	}
}
