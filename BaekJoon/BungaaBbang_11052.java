package baekjoon;
/*
 * 		int size[] �� input�� , �̰ɷ� boolean isIn[][]�� ����
 * 		boolean canContain[][] �� ���� �� �ִ� ��츦 ��� �־�ΰ� 
 * 		int maxContain[]�� ��� 
 */
import java.util.Scanner;

public class BungaaBbang_11052 {

	private static int tmpCnt;
	private static boolean canContain[][];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int boxCnt = Integer.parseInt(sc.nextLine());
		int size[] = new int[boxCnt];
		canContain = new boolean[boxCnt][boxCnt];
		int maxContain[] = new int[boxCnt];
		
		//size�Է¹ޱ�
		for(int i=0;i<boxCnt;i++)
			size[i] = sc.nextInt();
		sc.nextLine();
		
		//canContain �����
		for(int i=0;i<boxCnt;i++)
			for(int j=i;j<boxCnt;j++)
				if(size[i]<size[j])	canContain[i][j] = true;
		//maxContain �����
		int maxTmpCnt=0;
		maxContain[0]=0;
		for(int i=1;i<boxCnt;i++)
		{
			for(int j=0;j<i;j++)
			{
				maxTmpCnt=0;
				if(canContain[j][i])
				{
					tmpCnt=0;
					dfs(i,j);
					if(maxTmpCnt < tmpCnt)
						maxTmpCnt = tmpCnt;
					
					System.out.println("hit <i,j> :"+i+","+j+" -> "+tmpCnt);
				}
			}
			maxContain[i] = maxContain[i-1] + maxTmpCnt;
		}
		
		for(int e:maxContain)
			System.out.print(e+", ");
	}
	public static void dfs(int j,int max)
	{
		tmpCnt++;
		for(int k=j;k<max;j++)
		{
			if(canContain[j][k])
				dfs(k,max);
		}
		
	}
}