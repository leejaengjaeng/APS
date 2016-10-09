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

			//famousTeams�� ���� ���� �����ؼ� days���� �����ϸ� ��¥�� �ּ� ������ Ȯ��
			//�����Ⱓ festivalDays�̻� days ����  
			for(int festivalDays = famousTeams; festivalDays <= days ; festivalDays++)
			{
				int tmpSum=0;
				double tmpAvg=0;
				int startDate=0;
				
				//ù������ festivalDays��ŭ�� ��� ���� ����
				for(startDate=0;startDate<festivalDays;startDate++)
					tmpSum+=priceOfDate[startDate];
				tmpAvg = (1.0*tmpSum)/festivalDays;

				if(tmpAvg < avg)
					avg = tmpAvg;
				
				
				//���� ��¥��ŭ �����Ѵٰ� �Ҷ� ����� �ּҸ� ã��
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
