package algoSpot;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class FESTIVAL {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int cnt = Integer.parseInt(sc.nextLine());
		
		for(int ci=0;ci<cnt;ci++)
		{
			int days = sc.nextInt();
			int famousTeams = sc.nextInt();
			sc.nextLine();
			
			int priceOfDate[] = new int[days];
			for(int i=0;i<days;i++)
				priceOfDate[i] = sc.nextInt();
			sc.nextLine();
			
			double avg = 987654321.0;

			//famousTeams의 숫자 부터 시작해서 days까지 증가하며 날짜별 최소 가격을 확인
			//축제기간 festivalDays이상 days 이하  
			for(int festivalDays = famousTeams; festivalDays <= days ; festivalDays++)
			{
				int tmpSum=0;
				double tmpAvg=0;
				int startDate=0;
				
				//첫날부터 festivalDays만큼의 비용 합을 구함
				for(startDate=0;startDate<festivalDays;startDate++)
					tmpSum+=priceOfDate[startDate];
				tmpAvg = (1.0*tmpSum)/festivalDays;

				if(tmpAvg < avg)
					avg = tmpAvg;
				
				
				//같은 날짜만큼 진행한다고 할때 평균의 최소를 찾음
				while(startDate<days)
				{
					tmpSum = tmpSum - priceOfDate[startDate-festivalDays] + priceOfDate[startDate];
					tmpAvg = (tmpSum*1.0)/festivalDays;
					if(tmpAvg < avg)
						avg = tmpAvg;

					startDate++;
				}
				
			}
			System.out.println(avg);
		}
		
	}
}
