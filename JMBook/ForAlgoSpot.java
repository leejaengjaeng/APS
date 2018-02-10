package JMBook;

/**
 * 제출시 패키지 삭제, class명 Main
 */
import java.util.Scanner;
public class ForAlgoSpot {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int days = scanner.nextInt();
			int teams = scanner.nextInt();

			int[] costs = new int[days];
			for(int index=0; index < days ; index++){
				costs[index] = scanner.nextInt();
			}

			double avgMin = Double.MAX_VALUE;
			for(int day = teams ; day <= days ; day++) {

				for(int startDay = 0 ; startDay <= days - day ; startDay++){
					int dayCostSum = 0;

					for(int position=startDay; position < day + startDay ; position++){
						dayCostSum += costs[position];
					}
					double dayMin = (double)dayCostSum/day;
					if(avgMin > dayMin){
						avgMin = dayMin;
					}
				}
			}
			System.out.printf("%.10f\n",avgMin);
		}
	}
}

/*
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
            String name = sc.next();
            System.out.println("Hello, " + name + "!");
        }
    }
}
 */