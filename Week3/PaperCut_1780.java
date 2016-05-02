package Week3;

import java.util.Scanner;

public class PaperCut_1780 {

	public static int base[][];

	// -1, 0, 1 count
	public static int cM=0;
	public static int cZ=0;
	public static int cP=0;
	

	public static void main(String args[])
	{
		int[] state = new int[3];
		Scanner sc = new Scanner(System.in);
		int sx=0,sy=0;
		int length = sc.nextInt();
		
		base = new int[length][length];
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<length;j++)
			{
				base[i][j]=sc.nextInt();
			}
		}
		int tValue=-99;
		DNQ(sx,sy,length);
		
		System.out.println(cM);
		System.out.println(cZ);
		System.out.println(cP);	

	}
	//종이가 모두 같으면 해당 숫자 리턴, 아니면 -99 리턴
	public static int isAllSame(int xS,int yS,int length )
	{
		int xs=xS,ys=yS,leng=length;
		int retV = base[xs][ys];
		
		for(int i=0;i<leng;i++)
		{
			for(int j=0;j<leng;j++)
			{
				if(base[xs][ys]!=retV) return -99;
				else
				{
					ys++;
				}
			}
			ys=yS;
			xs++;
		}
		return retV;
	}
	
	public static void DNQ(int xS,int yS, int length)
	{
		//현재 종이가 모두 같은지 확인
		int tFlag = isAllSame(xS,yS,length);		
		int xs=xS;
		int ys=yS;
		int leng=length/3;
	
		//모두 같지않다면 9등분해서 종이 9개를 다시 넣기
		if(tFlag==-99)
		{
			DNQ(xs,ys,leng);
			DNQ(xs+leng,ys,leng);
			DNQ(xs+leng+leng,ys,leng);

			DNQ(xs,ys+leng,leng);
			DNQ(xs+leng,ys+leng,leng);
			DNQ(xs+leng+leng,ys+leng,leng);

			DNQ(xs,ys+leng+leng,leng);
			DNQ(xs+leng,ys+leng+leng,leng);
			DNQ(xs+leng+leng,ys+leng+leng,leng);
		}
		//모두 같다면 카운트 증가
		else
		{
			if(tFlag==-1)cM++;
			else if(tFlag==0)cZ++;
			else if(tFlag==1)cP++;
			else System.out.println("ERR");
		}
	}// end of loop
}