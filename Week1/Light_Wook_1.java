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
			// 1:->, 2: <-, 3:�Ʒ�, 4:��
			int direction=1;
			//���� ������ġ 
			int cx=0,cy=0;
			
			//�� �簢�� ��
			nRow = sc.nextInt();
			room = new int[nRow][nRow];
			//�ſ￡ �ѹ� �ݻ�ƾ����� Ȯ���� �迭 
			boolean used[][] = new boolean[nRow][nRow];
			
			//�濡 �ſ� ������ �Է� 
			for(int i=0;i<nRow;i++)
			{
				//02, 11ó�� ������ ���� 0 2, 1 1�� ó���ϱ� ���� 
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
				// ��
				case 1:	
					// ��  : ��
					if(room[cx][cy]==0)
					{
						cx++;
					}
					// �� / : ��
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
					// �� \ : �� 
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
				//��
				case 2:	
					// ��  : ��
					if(room[cx][cy]==0)
					{
						cx--;
					}
					// / �� : ��
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
					// \ �� : �� 
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
				//��
				case 3:	
					// ��  : ��
					if(room[cx][cy]==0)
					{
						cy++;
					}
					// �� / : �� 
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
					// �� \ : �� 
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
				//��
				case 4:	
					// ��  : ��
					if(room[cx][cy]==0)
					{
						cy--;
					}
					// �� / : ��
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
					//  ��\ : �� 
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
			
		
			// �� �κп��� ������ ����Ͻʽÿ�.
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