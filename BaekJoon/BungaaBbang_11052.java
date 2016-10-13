package baekjoon;
/*
 * 		int size[] 는 input값 , 이걸로 boolean isIn[][]을 만듬
 * 		boolean canContain[][] 에 넣을 수 있는 경우를 모두 넣어두고 
 * 		int maxContain[]을 계산 
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
		
		//size입력받기
		for(int i=0;i<boxCnt;i++)
			size[i] = sc.nextInt();
		sc.nextLine();
		
		//canContain 만들기
		for(int i=0;i<boxCnt;i++)
			for(int j=i;j<boxCnt;j++)
				if(size[i]<size[j])	canContain[i][j] = true;
		//maxContain 만들기
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