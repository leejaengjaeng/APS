/*
import java.util.Date;
import java.util.Scanner;
import java.io.FileInputStream;

public class Fish_Bom_1 {
	public static void main(String args[]) throws Exception	{
	  
		Scanner sc = new Scanner(System.in);

		int nRow = sc.nextInt();	
		int net = sc.nextInt();		// (net/2-1)가지 패턴의 모양이 있음 
		int nFish = sc.nextInt();
		int count=0;
		int maxCount=0;
		int cMax = (net/2)-1;
		int[][] fishes = new int[nFish][2];
		
				
		//물고기의 위치를 입력 받음
		for(int i=0;i<nFish;i++)
		{
			fishes[i][0] = sc.nextInt();
			fishes[i][1] = sc.nextInt();
		}

		// 물고기 위치를 기준으로 얼마나 잡을 수 있는 지 확인
		for(int n=0;n<nFish;n++)
		{
			//그물 펼칠 모양
			for(int r =1; r<=cMax;r++)
			{
				//펼칠 수 있는 최대 범위 내에서 전체 조사
				for(int i =fishes[n][0]-r;i<fishes[n][0];i++)
				{
					for(int j=fishes[n][1]-(net/2)-r; j<fishes[n][1];j++)
					{
						//정해진 패턴, 방향에 대해서 모든 물고기가 근처에 있는지 확인
						for(int f=0; f<nFish; f++)
						{
							if(isIn(fishes[f][0],fishes[f][1],i,j,r,(net/2)-r)==true) 
							{
								count++;
							}
						}
						if(maxCount < count) 
						{
							maxCount = count;
			}
							count=0;

					}
				}
			}
		}

		System.out.println(maxCount);

	}//end of main
	
	//netR : 그물의 가로길이, netC : 그물의 세로길이 
	public static boolean isIn(int fx,int fy,int cx,int cy,int netR,int netC)
	{
		if(cx<=fx && ((cx+netR) >= fx))
		{
			if(cy <= fy && ((cy+netC) >= fy))
				return true;
		}
		return false;
	}
}
*/