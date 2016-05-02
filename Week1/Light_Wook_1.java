/*
import java.util.Scanner;
import java.io.FileInputStream;

//class Solution {
public class Light_Wook_1 {
	public static void main(String args[]) throws Exception	{
	  
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;
		int nRow;
		int room[][];
		
		
		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {

			String tmp=null;
			int count=0;
			// 1:->, 2: <-, 3:아래, 4:위
			int direction=1;
			//빛의 현재위치 
			int cx=0,cy=0;
			
			//정 사각형 방
			nRow = sc.nextInt();
			room = new int[nRow][nRow];
			//거울에 한번 반사됐었는지 확인할 배열 
			boolean used[][] = new boolean[nRow][nRow];
			
			//방에 거울 정보를 입력 
			for(int i=0;i<nRow;i++)
			{
				//02, 11처럼 들어오는 값을 0 2, 1 1로 처리하기 위함 
				tmp = sc.next();
				for(int j =0;j<nRow;j++)
				{
					room[j][i]=tmp.charAt(j)-48;
					used[j][i]=false;
				}
			}
				
				
			while(isIn(cx,cy,nRow)==true)
			{
				switch(direction)
				{	
				// →
				case 1:	
					// →  : →
					if(room[cx][cy]==0)
					{
						cx++;
					}
					// → / : ↑
					else if(room[cx][cy]==1)
					{
						direction=4;
					
						if(used[cx][cy]==false) 
						{
							count++;
							used[cx][cy] = true;
						}
					
						cy--;
					}
					// → \ : ↓ 
					else
					{
						direction = 3;
					
						if(used[cx][cy]==false) 
						{
							count++;
							used[cx][cy] = true;
						}
					
						cy++;
					}
					break;
				//←
				case 2:	
					// ←  : ←
					if(room[cx][cy]==0)
					{
						cx--;
					}
					// / ← : ↓
					else if(room[cx][cy]==1)
					{
						direction=3;
					
						if(used[cx][cy]==false) 
						{
							count++;
							used[cx][cy] = true;
						}
					
						cy++;
					}
					// \ ← : ↑ 
					else
					{
						direction = 4;
					
						if(used[cx][cy]==false) 
						{
							count++;
							used[cx][cy] = true;
						}
						cy--;
					}
					break;
				//↓
				case 3:	
					// ↓  : ↓
					if(room[cx][cy]==0)
					{
						cy++;
					}
					// ↓ / : ← 
					else if(room[cx][cy]==1)
					{
						direction= 2;
					
						if(used[cx][cy]==false) 
						{
							count++;
							used[cx][cy] = true;
						}
					
						cx--;
					}
					// ↓ \ : → 
					else
					{
						direction = 1;
						
						if(used[cx][cy]==false) 
						{
							count++;
							used[cx][cy] = true;
						}
					
						cx++;
					}
					break;
				//↑
				case 4:	
					// ↑  : ↑
					if(room[cx][cy]==0)
					{
						cy--;
					}
					// ↑ / : →
					else if(room[cx][cy]==1)
					{
						//
						direction=1;
					
						if(used[cx][cy]==false) 
						{
							count++;
							used[cx][cy] = true;
						}
					
						cx++;
					}
					//  ↑\ : ← 
					else
					{
						direction = 2;
						
						if(used[cx][cy]==false) 
						{
							count++;
							used[cx][cy] = true;
						}
						cx--;
					}
					break;
				}//end of switch
				
			}
			
		
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);	
			System.out.println(count);	
			
		}
	}//end of main
	
	public static boolean isIn(int px, int py,int nRow)
	{
		if(px<0 || px>=nRow)
			return false;
		if(py<0 || py>=nRow)
			return false;
		
		return true;
	}
}
*/